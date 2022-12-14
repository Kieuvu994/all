package vu.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import static javax.persistence.AccessType.FIELD;


/**
 * The persistent class for the size database table.
 * 
 */
@Entity
@NamedQuery(name="Size.findAll", query="SELECT s FROM Size s")
@Access(FIELD)
public class Size implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private BigDecimal price;

	private String size;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="size")
	private List<Orderitem> orderitems;

	public Size() {
	}
	public Size(int id, BigDecimal i, String size) {
		super();
		this.id = id;
		this.price = i;
		this.size = size;
	}
	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"price\":" + price + ", \"size\": \"" + size + "\"}";
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setSize(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setSize(null);

		return orderitem;
	}

}