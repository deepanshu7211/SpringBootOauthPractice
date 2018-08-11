package com.deep;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println( encoder.encode("abc123"));
		
		String plainClientCredentails = "hendi-client:hendi-secret";
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentails.getBytes()));
        
		System.out.println(base64ClientCredentials);
	}
}
