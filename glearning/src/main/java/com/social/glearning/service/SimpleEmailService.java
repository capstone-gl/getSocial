package com.social.glearning.service;

public interface SimpleEmailService {

	void verifyEmail(String email);

	void sendEmail(String mailfrom, String mailto);

}
