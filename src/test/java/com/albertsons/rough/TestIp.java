package com.albertsons.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestIp {

	public static void main(String[] args) {
		try {
			System.out.println("http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/API_Testing_Framework/Extent_20Reports/");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
