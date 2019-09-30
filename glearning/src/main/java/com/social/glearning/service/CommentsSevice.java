package com.social.glearning.service;

import com.social.glearning.model.Comments;

public interface CommentsSevice {
	
	public void postComment(String userId,Long postId,String commmentBy, Comments comment);

}
