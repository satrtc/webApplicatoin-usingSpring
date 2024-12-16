package com.webapplication.firstWebApplication.login;

import org.springframework.stereotype.Service;

@Service
public class AuntheticService {
	
	public boolean authenticateData(String name, String pass)
	{
		boolean isValidName=name.equalsIgnoreCase("wukong");
		boolean isValidPassword=pass.equalsIgnoreCase("demons");
		return isValidName&&isValidPassword;
	}

}
