package com.social.glearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.glearning.model.Post;
import com.social.glearning.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService ;
	
	
	@PostMapping("/{userId}")
	public Post createPost(@PathVariable("userId") String userId,@RequestBody Post post) {
		postService.createPost(userId, post);
		return post;
	}

}
