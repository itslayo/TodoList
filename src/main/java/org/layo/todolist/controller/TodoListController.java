package org.layo.todolist.controller;

import org.layo.todolist.dao.impl.Factory;
import org.layo.todolist.entity.TodoItem;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Layo on 21.12.2014.
 */

@RestController
public class TodoListController {

    public TodoListController() {}

    @RequestMapping(value = "/todos", method = RequestMethod.GET, headers="Accept=application/json")
    @SuppressWarnings("unchecked")
    public List<TodoItem> getAllTasks()
    {
        List<TodoItem> tasks = null;
        try
        {
            tasks = Factory.getInstance().getTodoItemDAO().getAllTodoItems();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST, headers="Accept=application/json")
    public  TodoItem addTask(@RequestBody TodoItem todoItem)
    {
        try
        {
            Factory.getInstance().getTodoItemDAO().addTodoItem(todoItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItem;
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
     public  void deleteTask(@PathVariable int id) {
        try {
            Factory.getInstance().getTodoItemDAO().deleteTodoItem(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public  void updateTask(@PathVariable int id, @RequestBody TodoItem todoItem) {
        try {
            Factory.getInstance().getTodoItemDAO().updateTodoItem(id, todoItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
