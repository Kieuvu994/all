package com.coeding.springmvc.dto;

import java.math.BigDecimal;

import com.coeding.springmvc.entity.Orderz;
import com.coeding.springmvc.entity.Productz;
import com.coeding.springmvc.entity.Sizez;
import com.coeding.springmvc.entity.Topping;

	public class OrderitemDTO {
		private int id;
		private Orderz orderz;
		private Productz productz;
		private Sizez sizez;
		private Topping topping;
		private String name;
		private BigDecimal price;
		private int qty;
		private String image;
	
		//	public Orderitemz(Orderz orderz, Productz productz, Sizez sizez, Topping topping, String name, BigDecimal price,
		//	int qty) {
		//this.orderz = orderz;
		//this.productz = productz;
		//this.sizez = sizez;
		//this.topping = topping;
		//this.name = name;
		//this.price = price;
		//this.qty = qty;
		//}
		//
		public OrderitemDTO(int id, String name, Orderz orderz, Productz productz, Sizez sizez, Topping topping, BigDecimal price,
			int qty, String image) {
		this.id = id;
		this.name = name;
		this.orderz = orderz;
		this.productz = productz;
		this.sizez = sizez;
		this.topping = topping;
		this.price = price;
		this.qty = qty;
		this.image = image;
		}
		
		public int getId() {
		return this.id;
		}
		
		public void setId(int id) {
		this.id = id;
		}
		
		public Orderz getOrderz() {
		return this.orderz;
		}
		
		public void setOrderz(Orderz orderz) {
		this.orderz = orderz;
		}
		
		public Productz getProductz() {
		return this.productz;
		}
		
		public void setProductz(Productz productz) {
		this.productz = productz;
		}
		
		public Sizez getSizez() {
		return this.sizez;
		}
		
		public void setSizez(Sizez sizez) {
		this.sizez = sizez;
		}
		
		public Topping getTopping() {
		return this.topping;
		}
		
		public void setTopping(Topping topping) {
		this.topping = topping;
		}
		
		public String getName() {
		return this.name;
		}
		
		public void setName(String name) {
		this.name = name;
		}
		
		public BigDecimal getPrice() {
		return this.price;
		}
		
		public void setPrice(BigDecimal price) {
		this.price = price;
		}
		
		public int getQty() {
		return this.qty;
		}
		
		public void setQty(int qty) {
		this.qty = qty;
		}
		
		public String getImage() {
		return this.image;
		}
		
		public void setImage(String image) {
		this.image = image;
		}


}
