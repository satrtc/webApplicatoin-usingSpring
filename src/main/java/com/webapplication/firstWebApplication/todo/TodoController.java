package com.webapplication.firstWebApplication.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoservice;
	
	@RequestMapping("todo-list")
	public String listAllTodos(ModelMap map)
	{
		List<Todo> allTodos=todoservice.findByUsername("rtc");
		map.addAttribute("todos", allTodos);
		return "todoList";
	} 
}
