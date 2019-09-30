package com.social.glearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.glearning.GlConstants;
import com.social.glearning.dao.PostDao;
import com.social.glearning.dao.UserDao;
import com.social.glearning.model.Post;
import com.social.glearning.model.User;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public String createPost(String userId,Post post) {
		
		String postCreated = GlConstants.POST_CREATED;
		User user = userDao.getUser(userId);
		Long postId = user.getPostNo() + 1;
		user.setPostNo(postId);
		if(user.getPosts() != null && user.getPosts().size()>0) {
			post.setPostId(postId);
			user.getPosts().add(post);
		}else {
			List<Post> posts = new ArrayList<Post>();
			post.setPostId(postId);
			posts.add(post);
			user.setPosts(posts);
		}
		userDao.createUser(user,false);
		
		return postCreated;
	}

}
