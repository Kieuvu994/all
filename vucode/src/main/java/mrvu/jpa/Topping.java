package mrvu.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the topping database table.
 * 
 */
@Entity
@NamedQuery(name="Topping.findAll", query="SELECT t FROM Topping t")
public class Topping implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;

	private String name;

	private BigDecimal price;

	public Topping() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

}