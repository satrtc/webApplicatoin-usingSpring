package com.webapplication.firstWebApplication.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	
	@RequestMapping(value = "add-todo", method=RequestMethod.GET)
	public String addTododetails(ModelMap map)
	{
		Todo todo=new Todo(0,(String)map.get("name"),"",LocalDate.now().plusYears(1),false);
		map.put("todo",todo);
		return "addtodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addTodo( ModelMap map, @Valid Todo todo, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "addtodo";
		}
		todoservice.addTodo((String)map.get("name"),todo.getDescription(),LocalDate.now().plusYears(1),false);
		map.addAttribute(todo.getDescription());
		return "todo-list";
	}
	
	@RequestMapping("deletetodo")
	public String deleteTodo(@RequestParam int id) {
		todoservice.deleteTodo(id);
		return "redirect:todo-list";
	}
}
