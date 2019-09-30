package com.social.glearning.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.glearning.dao.CommentDao;
import com.social.glearning.dao.PostDao;
import com.social.glearning.dao.UserDao;
import com.social.glearning.model.Comments;
import com.social.glearning.model.Post;
import com.social.glearning.model.User;

@Service
public class CommentsSeviceImpl implements CommentsSevice {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void postComment(String userId, Long postId, String commmentBy, Comments comment) {
		User user = userDao.getUser(userId);
		if(user != null && user.getId() != null) {
			List<Post> posts = user.getPosts();
			if(posts != null && posts.size()>0) {
				for(Post post : posts) {
					if(post.getPostId().equals(postId)) {
						comment.setCommentBy(commmentBy);
						comment.setCommentTime(new Date());
						if(post.getComments() != null  && post.getComments().size()>0) {
							post.getComments().add(comment);
						}else {
							List<Comments> comments = new ArrayList<Comments>();
							comments.add(comment);
							post.setComments(comments);
						}
					}
				}
			}
		}
		
		userDao.createUser(user, false);
	}


	
}
