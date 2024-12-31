package com.webapplication.firstWebApplication.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello()
	{
		return "Hello what are you learning today";
	}
	
	@RequestMapping("say-helloweb")
	public String sayHelloJsp(@RequestParam String name, ModelMap map)
	{
 logger.debug("hye log"	);
 map.put("name", name);
		return "sayhello";
	}
	
	//implementing API versioning

}
