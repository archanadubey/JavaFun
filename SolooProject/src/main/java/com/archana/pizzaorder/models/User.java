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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
		private Long id;
	 	@NotBlank
	    @Size(max= 15)
	    private String firstName;
	    @NotBlank
	    @Size(max= 15)
	    private String lastName;
	    @Email
	    @NotBlank
	    private String email;
	    private String password;
	    @Transient
	    private String confirmPassword;
	 
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
		
	   
	    // one user can place many order
	    @OneToMany(mappedBy="creator",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	    private List<Pizza> orderPizza;
	    
	    //one user can make many comments
	    @OneToMany(mappedBy="usersComments",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	    private List<Comment> comments;
	    
	    @OneToMany(mappedBy="orderByUser",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	    private List<Order> orders;
	    
	    @OneToMany(mappedBy="makePayment",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	    private List<Payment> paymentByUser;
	    
	    
	    @ManyToMany(fetch=FetchType.LAZY)
	    @JoinTable(
		        name = "likes", 
		        joinColumns = @JoinColumn(name = "user_id"), 
		        inverseJoinColumns = @JoinColumn(name = "comment_id")
		    )
	    private List<Comment> commentsLiked;
		 
		public User() {
			
		}
		public List<Pizza> getOrderPizza() {
			return orderPizza;
		}
		public void setOrderPizza(List<Pizza> orderPizza) {
			this.orderPizza = orderPizza;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() { 
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
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
		public List<Comment> getComments() {
			return comments;
		}
		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}
		public List<Comment> getCommentsLiked() {
			return commentsLiked;
		}
		public void setCommentsLiked(List<Comment> commentsLiked) {
			this.commentsLiked = commentsLiked;
		}
		public List<Order> getOrders() {
			return orders;
		}
		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}
		public List<Payment> getPaymentByUser() {
			return paymentByUser;
		}
		public void setPaymentByUser(List<Payment> paymentByUser) {
			this.paymentByUser = paymentByUser;
		}
		

}
