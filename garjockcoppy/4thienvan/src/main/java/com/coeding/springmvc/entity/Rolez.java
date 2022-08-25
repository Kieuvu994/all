package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rolez database table.
 * 
 */
@Entity
@NamedQuery(name="Rolez.findAll", query="SELECT r FROM Rolez r")
public class Rolez implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="_id")
	private int id;

	private String name;

	//bi-directional many-to-many association to Userz
	@ManyToMany
	@JoinTable(
		name="user_roles"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="user_id")
			}
		)
	private List<Userz> userzs;

	public Rolez() {
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

	public List<Userz> getUserzs() {
		return this.userzs;
	}

	public void setUserzs(List<Userz> userzs) {
		this.userzs = userzs;
	}

}