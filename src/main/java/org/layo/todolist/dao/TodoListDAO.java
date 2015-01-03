package org.layo.todolist.dao;

import org.layo.todolist.entity.TodoItem;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Layo on 21.12.2014.
 */
public interface TodoListDAO {
    public void addTodoItem(TodoItem todoItem);
    public void updateTodoItem(TodoItem todoItem);
    public List getAllTodoItems();
    public void deleteTodoItem(int id);
}
