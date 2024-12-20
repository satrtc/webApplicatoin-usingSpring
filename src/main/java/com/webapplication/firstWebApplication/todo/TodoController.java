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
	
	@Autowired
	private TodoRepositary todoRepositary;
	
	@RequestMapping("todo-list")
	public String listAllTodos(ModelMap map)
	{
		List<Todo> allTodos=todoservice.findByUsername("rtc");
		List<Todo> h2todo=todoRepositary.findAll();
		System.out.println(h2todo.size());
		map.addAttribute("todos", h2todo);
		return "todoList";
	}
	
	//opens add todo page to enter details
	@RequestMapping(value = "add-todo", method=RequestMethod.GET)
	public String addTododetails(ModelMap map)
	{
		Todo todo=new Todo(0,(String)map.get("name"),"",LocalDate.now().plusYears(0),false);
		map.put("todo",todo);
		return "addtodo";
	}
	
	//submits the form and adds a new todo
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addTodo( ModelMap map,@Valid Todo todo, BindingResult bindingResult)
	{
		System.out.println("submit btn clicked");
		if(bindingResult.hasErrors())
		{
			return "addtodo";
		}
		todoservice.addTodo((String)map.get("name"),todo.getDescription(),LocalDate.now().plusYears(0),false);
		map.addAttribute(todo.getDescription());
		return "redirect:todo-list";
	}
	
	@RequestMapping("deletetodo")
	public String deleteTodo(@RequestParam int id) {
			todoservice.deleteTodo(id);
		return "redirect:todo-list";
	}

	@RequestMapping(value="updatetodo", method=RequestMethod.GET)
	public String upDateTodopage(ModelMap model,@RequestParam int id)
	{
		Todo todo=(Todo)todoRepositary.getById(id);
		System.out.println(todo);
		model.put("todo",todo);
		model.put("tododate", todo.getTargeDate());
		return "addtodo";
	}

	@RequestMapping(value="updatetodo", method=RequestMethod.POST)
	public String upDateTodo(ModelMap model,Todo todo)
	{
		todo.setUsername((String)model.get("name"));
		todoservice.updateTodo(todo);
		return "redirect:todo-list";
	}
}
