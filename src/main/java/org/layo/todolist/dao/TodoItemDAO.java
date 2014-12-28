package org.layo.todolist.dao;

import org.layo.todolist.entity.TodoItem;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Layo on 21.12.2014.
 */
public interface TodoItemDAO {
    public void addTodoItem(TodoItem todoItem) throws SQLException;
    public void updateTodoItem(int id, TodoItem todoItem) throws SQLException;
    public List getAllTodoItems() throws SQLException;
    public void deleteTodoItem(int id) throws SQLException;
}
