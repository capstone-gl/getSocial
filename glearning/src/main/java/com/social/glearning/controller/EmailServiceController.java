package com.social.glearning.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.glearning.service.SimpleEmailService;

// GET http://localhost:8080/ses/sendmail?mailfrom=mca5319rakesh@gmail.com&mailto=iamrajitkumar@gmail.com
// GET http://localhost:8080/ses/verifymail/iamrajitkumar@gmail.com	

@RestController
@RequestMapping("/ses")
public class EmailServiceController {
	
	@Autowired
	private SimpleEmailService simpleEmailService;
	
	@GetMapping("/verifymail/{email}")
	public String verifyMail(@PathVariable("email") String email ) {
		this.simpleEmailService.verifyEmail(email);
		return "Verification Mail Sent";

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sendmail")
	public String sendMail(@RequestParam Map<String, String> mailQuery) {
		System.out.println("mailQuery = mailfrom " + mailQuery.get("mailfrom"));
        System.out.println("mailQuery = mailto " + mailQuery.get("mailto"));
		this.simpleEmailService.sendEmail(mailQuery.get("mailfrom"), mailQuery.get("mailto"));
		return "Mail Sent";
	}
	

}
