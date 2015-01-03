package org.layo.todolist.controller;

import org.layo.todolist.entity.TodoItem;
import org.layo.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Layo on 21.12.2014.
 */

@RestController
public class TodoListController {

    @Autowired
    TodoListService todoListService;

    public TodoListController() {}

    @RequestMapping(value = "/todos", method = RequestMethod.GET, headers="Accept=application/json")
    @SuppressWarnings("unchecked")
    public List<TodoItem> getAllTasks()
    {
        List<TodoItem> tasks;
        tasks = todoListService.getAllTodoItems();
        return tasks;
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST, headers="Accept=application/json")
    public  TodoItem addTask(@RequestBody TodoItem todoItem)
    {
        todoListService.addTodoItem(todoItem);
        return todoItem;
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
     public  void deleteTask(@PathVariable int id) {
        todoListService.deleteTodoItem(id);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.PUT, headers="Accept=application/json")
    public  void updateTask(@RequestBody TodoItem todoItem) {
        todoListService.updateTodoItem(todoItem);
    }
}
