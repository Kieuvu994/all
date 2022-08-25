package com.coeding.springmvc.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coeding.springmvc.entity.Categoryz;
import com.coeding.springmvc.entity.Orderitemz;
import com.coeding.springmvc.entity.Orderz;
import com.coeding.springmvc.entity.Productz;
import com.coeding.springmvc.entity.Shippingaddressz;
import com.coeding.springmvc.global.GlobalDara;
import com.coeding.springmvc.service.CartService;
import com.coeding.springmvc.service.OrderItemService;
import com.coeding.springmvc.service.OrderService;
import com.coeding.springmvc.service.ProductService;
import com.coeding.springmvc.service.RabbitmqService;
import com.coeding.springmvc.service.ShippingaddressService;

@Controller
public class CartController {

	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderitemService;
	
	@Autowired
	ShippingaddressService shippingService;
	
	@Autowired
	RabbitmqService rabbitmqService;
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(Model model,@PathVariable int id) {
		
		System.out.println("!!!!!!!!!!!!!!!!!");
		if (GlobalDara.cart == null) {
			GlobalDara.cart.add(productService.findById(id).get());
		} else {
			int index = isExisting(id);
			if (index == -1) {
				GlobalDara.cart.add(productService.findById(id).get());
			} else {
				int qty = GlobalDara.cart.get(index).getQuantity() + 1;
				System.out.println("ddddd" +qty);
				GlobalDara.cart.get(index).setQuantity(qty);
				GlobalDara.cart.get(index).setTotalPrice(GlobalDara.cart.get(index).getPrice().multiply(BigDecimal.valueOf(GlobalDara.cart.get(index).getQuantity())) );
				System.out.println(getInfo(index));
			}
		}
		return "redirect:/shop-grid";
	}
	//test quantity
	private String getInfo(int index) {
		return String.format("{\"quantity\":%d,\"totalPrice\":%.2f}", GlobalDara.cart.get(index).getQuantity(), GlobalDara.cart.get(index).getTotalPrice());
	}
	
/////////////////////////////////////////// CART SHOP /////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/shoping-cart")
	public String cartGet(Model model, RedirectAttributes attributes) {
//		if (principal == null) {
//			return "redirect:/login";
//		}
		int qty = 0;
		for (int j = 0; j < GlobalDara.cart.size(); j++) {
			 qty += GlobalDara.cart.get(j).getQuantity();
		}
		model.addAttribute("cartCount", qty);
		model.addAttribute("total", 
				GlobalDara.cart.stream().map(x -> x.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add));
		//GlobalDara.cart.stream().mapToDouble(Productz::getPrice).sum()
		model.addAttribute("cart", GlobalDara.cart);
		
		//Caculate total price
		
		BigDecimal total=new BigDecimal(0.00);
		for (int i = 0; i < GlobalDara.cart.size(); i++) {
			//System.out.println(GlobalDara.cart.get(i).getPrice().multiply(BigDecimal.valueOf( GlobalDara.cart.get(i).getQuantity())));
			
			total = total.add( GlobalDara.cart.get(i).getPrice().multiply(BigDecimal.valueOf( GlobalDara.cart.get(i).getQuantity())));
			
		}
		System.out.println(total);
		
		model.addAttribute("totalCart", total);
		return "shoping-cart";
	}
	
	//not used yet
	@PostMapping("/shoping-cart/add/{id}")
	public String cartAddQty(Model model, @PathVariable int id) {
		
		int qty = GlobalDara.cart.get(id).getQuantity() + 1;
		GlobalDara.cart.get(id).setQuantity(qty);
		model.addAttribute("qty", GlobalDara.cart.get(id).getQuantity());
		model.addAttribute("totalCart", GlobalDara.cart.get(id).getPrice().multiply( BigDecimal.valueOf(GlobalDara.cart.get(id).getQuantity())));
		
		return "shoping-cart";
	}
	
	@GetMapping("/cart/removeItem/{index}")
	public String cartRemove(@PathVariable int index) {
		GlobalDara.cart.remove(index);
		return "redirect:/shoping-cart";
	}
	
	
	private int isExisting(int id) {
		for (int i = 0; i < GlobalDara.cart.size(); i++) {
			if (GlobalDara.cart.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////        CHECKOUT        /////////////////////////////////////////////////////
	@GetMapping("/checkout")
	public String checkout(Model model, RedirectAttributes attributes) {
		if (GlobalDara.cart.size() == 0) {
			attributes.addFlashAttribute("message","Don't have products in cart!!");
			return "redirect:/shoping-cart";
		}
		System.out.println("Checkout GET");
		
		BigDecimal total=new BigDecimal(0.00);
		for (int i = 0; i < GlobalDara.cart.size(); i++) {
			total = total.add( GlobalDara.cart.get(i).getPrice().multiply(BigDecimal.valueOf( GlobalDara.cart.get(i).getQuantity())));
		}
		BigDecimal shippingPrice = new BigDecimal(35.00).setScale(2);
		BigDecimal taxPrice = total.multiply(new BigDecimal(0.1)).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		int qty = 0;
		for (int j = 0; j < GlobalDara.cart.size(); j++) {
			 qty += GlobalDara.cart.get(j).getQuantity();
		}
		
		model.addAttribute("cartCount", qty);//orderitem
		model.addAttribute("total", total.add(shippingPrice).add(taxPrice));//order
		model.addAttribute("shippingPrice", shippingPrice);//order vs shippingaddress
		//GlobalDara.cart.stream().mapToDouble(Productz::getPrice).sum()
		model.addAttribute("cart", GlobalDara.cart);//orderitem
		model.addAttribute("taxPrice", taxPrice);//order
		
		model.addAttribute("shipping", new Shippingaddressz());
		
		return "checkout";
	}
	
	
	@PostMapping("/order")
	public String checkOut(Model model, @ModelAttribute("shipping") Shippingaddressz shipping, Orderz order) {
//	public String checkOut(Model model, Shippingaddressz shipping, Orderz or) {
		// orderService.addOrderAndOrderDetail(or, cartService);
		System.out.println("Checkout POST");
		System.out.println("Checkout convert to Order Page POST order -> : " + "ID {" + order.getId() +  ", ["+ order.getCreatedAt() + ", "+ order.getDeliveredAt()
		 + ", "+ order.getIsDelivered() + ", "+ order.getIsPaid() + ", "+ order.getPaidAt() + ", "+ order.getPaymentMethod()
		 + ",ShippingAddress can null:{ "+ order.getShippingaddresszs() + "}, "+ order.getTaxPrice() + ", "+ order.getTotalPrice()+ ", "+ order.getShippingPrice());
		Orderz o = orderService.createOrder(order);
		
		rabbitmqService.converToSendRabbit(o, shipping);
		GlobalDara.cart.clear();
		/////////////////////////////  PLACE ORDER  /////////////////////////////////////
		System.out.println(" Order Page [GET]: Payment Method......");
		
		
//////////////////////////////////////////////////////// get invoice ////////////////////////////////////////////////////////
		List<Orderitemz> item = orderitemService.findOrderItemByOrderID(o.getId());
		int qty = 0;
		for (Orderitemz orderitemz : item) {
			qty += orderitemz.getQty();
		}		
		model.addAttribute("orderItemCount", qty);
		model.addAttribute("order", orderService.findById(o.getId()));
		model.addAttribute("shipping", shippingService.findShippingAddressByOrderID(o.getId()));
		model.addAttribute("orderitem", orderitemService.findOrderItemByOrderID(o.getId()));
		
		return "order";
	}
	
	
/////////////////////// PAYPAL METHOD //////////////////////////////////////////////////////////////////////////////////
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}