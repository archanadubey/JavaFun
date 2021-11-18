package com.archana.pizzaorder.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long orderNumber;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="YYYY-MM-dd  hh:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="YYYY-MM-dd  hh:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	 
	private User orderByUser;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pizza_id")
	 
	private Pizza pizzaOrdered;
	
	public Order() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getOrderByUser() {
		return orderByUser;
	}

	public void setOrderByUser(User orderByUser) {
		this.orderByUser = orderByUser;
	}

	public Pizza getPizzaOrdered() {
		return pizzaOrdered;
	}

	public void setPizzaOrdered(Pizza pizzaOrdered) {
		this.pizzaOrdered = pizzaOrdered;
	}
	
	// two many to one realation ship
	// user 
	//pizza 
	
	//createdAT 
	//order number;
	
// last number and increament.
	
	

}
