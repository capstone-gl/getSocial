package com.social.glearning.model;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Comments {
	
	private String comment;
	private String commentBy;
	private Date commentTime;
	
	
	public String getComment() {
		return comment;
	}
	
	@DynamoDBAttribute(attributeName = "comment")
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentBy() {
		return commentBy;
	}
	@DynamoDBAttribute(attributeName = "commentBy")
	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	@DynamoDBAttribute(attributeName = "commentTime")
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

}
