package org.layo.todolist.service;

import org.layo.todolist.entity.TodoItem;
import java.util.List;

/**
 * Created by Layo on 31.12.2014.
 */

public interface TodoListService {
    public void addTodoItem(TodoItem todoItem);
    public void updateTodoItem(TodoItem todoItem);
    public List getAllTodoItems();
    public void deleteTodoItem(int id);
}
