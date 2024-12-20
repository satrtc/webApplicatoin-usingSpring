package com.webapplication.firstWebApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos=new ArrayList<Todo>();
	
	@Autowired
	private  TodoRepositary todoRepositary;
	private  int todoCount=0;

	public List<Todo> findByUsername(String username)
	{
		return todos;
	}
	
	public void addTodo(String username, String description,LocalDate targetDate, boolean todostaus)
	{
		
		if(todoRepositary.count()==0)
			todoCount=0;
		Todo todo=new Todo(++todoCount,username,description,targetDate,todostaus);
		todos.add(todo);
		todoRepositary.save(todo);
	}

	public void deleteTodo(int id) {
		// TODO Auto-generated method stub
		todoRepositary.deleteById(id);
	}

	public void updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		todoRepositary.save(todo);
	}
}
