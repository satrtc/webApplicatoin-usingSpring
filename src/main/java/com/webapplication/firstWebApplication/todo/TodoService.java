package com.webapplication.firstWebApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos=new ArrayList<Todo>();
	private static int todoCount=0;
	static {
		todos.add(new Todo(++todoCount,"rtc", "spring core", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount,"rtc", "spring boot", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount,"rtc", "spring mvc", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount,"rtc", "spring security", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount,"rtc", "spring data", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username)
	{
		return todos;
	}
	
	public void addTodo(String username, String description,LocalDate targetDate, boolean todostaus)
	{
		Todo todo=new Todo(++todoCount,username,description,targetDate,todostaus);
		todos.add(todo);
	}
	
}
