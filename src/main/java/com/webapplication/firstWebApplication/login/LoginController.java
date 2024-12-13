package com.webapplication.firstWebApplication.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String saylogin()
	{
		return "login";
	}
}
