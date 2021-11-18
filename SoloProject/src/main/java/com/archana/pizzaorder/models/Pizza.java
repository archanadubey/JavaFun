package com.archana.pizzaorder.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pizzas")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	@NotEmpty
	//private String orderPizza;
	
	private String topping;
	private String size;
	private String amount;
	private Double price;
	
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
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User creator;
	
	
	 @OneToMany(mappedBy="pizzaOrdered",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	    private List<Order> pizzaQuantity;
	 
	public Pizza() {
		
	}

	

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getOrderPizza() {
//		return orderPizza;
//	}
//
//	public void setOrderPizza(String orderPizza) {
//		this.orderPizza = orderPizza;
//	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public Number getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public List<Order> getpizzaQuantity() {
		return pizzaQuantity;
	}
	public void setpizzaQuantity(List<Order> pizzaQuantity) {
		this.pizzaQuantity = pizzaQuantity;
	}
	
	

}
