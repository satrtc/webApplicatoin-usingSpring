package com.webapplication.firstWebApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos=new ArrayList<Todo>();
	
	static {
		todos.add(new Todo(1,"rtc", "spring core", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(2,"rtc", "spring boot", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(3,"rtc", "spring mvc", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(4,"rtc", "spring security", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(5,"rtc", "spring data", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username)
	{
		return todos;
	}
}
