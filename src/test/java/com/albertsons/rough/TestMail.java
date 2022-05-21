package com.albertsons.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.albertsons.apitesting.utilities.TestConfig;
import com.albertsons.mail_api.MonitoringMail;

public class TestMail {
	static String messageBody;
	public static void main(String[] args) {
		
		MonitoringMail mail=new MonitoringMail();
		try {
			messageBody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/API_Testing_Framework/Extent_20Reports/";
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject,messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
