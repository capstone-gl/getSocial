package com.social.glearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.regions.Region;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.VerifyEmailAddressRequest;

@Service
public class SimpleEmailServiceImpl implements SimpleEmailService {

	AmazonSimpleEmailService sesClient;

	// The subject line for the email.
	static final String SUBJECT = "GetSocial Friend Request Notification";

	// The HTML body for the email.
	static final String HTMLBODY = "<h1>Friend Request notification</h1>"
			+ "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
			+ "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>" + "AWS SDK for Java</a>";

	// The email body for recipients with non-HTML email clients.
	static final String TEXTBODY = "This email was sent through Amazon SES " + "using the AWS SDK for Java.";

	@Autowired
	public SimpleEmailServiceImpl(Region awsRegion) {
		this.sesClient = AmazonSimpleEmailServiceClientBuilder.standard()
						.withRegion(awsRegion.getName()).build();
			}

	@Override
	public void verifyEmail(String email) {
		VerifyEmailAddressRequest request = new VerifyEmailAddressRequest().withEmailAddress(email);
		sesClient.verifyEmailAddress(request);
		System.out.println("Email verification sent!");

	}

	@Override
	public void sendEmail(String mailfrom, String mailto) {
		SendEmailRequest request = new SendEmailRequest().withDestination(new Destination().withToAddresses(mailto))
				.withMessage(new Message()
						.withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(HTMLBODY))
								.withText(new Content().withCharset("UTF-8").withData(TEXTBODY)))
						.withSubject(new Content().withCharset("UTF-8").withData(SUBJECT)))
				.withSource(mailfrom);
		// Comment or remove the next line if you are not using a
		// configuration set
		// .withConfigurationSetName(CONFIGSET);
		sesClient.sendEmail(request);
		System.out.println("Email sent!");
	}

}
