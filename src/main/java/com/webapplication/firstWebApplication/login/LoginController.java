package com.webapplication.firstWebApplication.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	
	private AuntheticService auntheticService;
	
	public LoginController(AuntheticService auntheticService) {
		super();
		this.auntheticService = auntheticService;
	}

	@RequestMapping(value="loginpage", method=RequestMethod.GET )
	public String saylogin()
	{
		return "login";
	}
	
	@RequestMapping(value="loginpage", method=RequestMethod.POST)
	public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model)
	{
		System.out.println(name+"-> "+password);
		
		if(auntheticService.authenticateData(name, password))
		{
		model.put("name",name);
		model.put("password", password);
		return "welcome";
		}
		return "login";
	}
}
