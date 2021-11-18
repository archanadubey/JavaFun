package com.archana.pizzaorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archana.pizzaorder.models.Comment;
import com.archana.pizzaorder.models.User;
import com.archana.pizzaorder.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository cRepo;
	
	// Get all Comment
	public List<Comment> getAllComments(){
		return this.cRepo.findAll();
	}
	// Create Comment 
	public Comment createComment(Comment comment) {
		return this.cRepo.save(comment);
	}
	//get one Comment
	
	public Comment GetOneComment(Long id) {
		return this.cRepo.findById(id).orElse(null);
		
	}
	//Update/edit Comment
	
	public Comment updateComment(Comment comment) {
		return this.cRepo.save(comment);
		
	}
	
	//likes the comments
	public void likeComment(User user , Comment comment) {
	List <User> userWholikes=comment.getLikers();
	userWholikes.add(user);
	this.cRepo.save(comment);
	}
	
	//Unlikes the comment 
	
	public void unlikeComment(User user , Comment comment) {
		List <User> whounlikeComment=comment.getLikers();
		whounlikeComment.remove(user);
		this.cRepo.save(comment);
		
	}

	// Delete Comment 
	public String DeleteComment(Long id) {
		 this.cRepo.findById(id);
		 return "Comment susscessfull deleted";
	}
	

}
