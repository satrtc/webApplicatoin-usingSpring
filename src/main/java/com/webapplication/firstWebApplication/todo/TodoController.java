package com.webapplication.firstWebApplication.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
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
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addTododetails()
	{
		return "addtodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addTodo()
	{
		return "redirect:todo-list";
	}
}
