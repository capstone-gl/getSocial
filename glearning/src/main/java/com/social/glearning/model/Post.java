package com.social.glearning.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Post {
	
	private Long postId;
	private String postText;
	private List<Comments> comments;
	
	
	public Long getPostId() {
		return postId;
	}
	@DynamoDBAttribute(attributeName = "postId")
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getPostText() {
		return postText;
	}
	@DynamoDBAttribute(attributeName = "postText")
	public void setPostText(String postText) {
		this.postText = postText;
	}
	
	@DynamoDBAttribute(attributeName = "comments")
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

}
