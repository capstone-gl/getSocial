package com.social.glearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.glearning.model.Comments;
import com.social.glearning.service.CommentsSevice;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	
	@Autowired
	private CommentsSevice commentService;
	
	@PostMapping("/{userId}/{postId}/{commentBy}")
	public void createCommentOnPost(@PathVariable("userId") String userId,@PathVariable("postId") Long postId,@PathVariable("commentBy") String commentBy,@RequestBody Comments comment) {
		commentService.postComment(userId,postId,commentBy,comment);
	}

}
