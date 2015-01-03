package org.layo.todolist.service.impl;

import org.layo.todolist.dao.TodoListDAO;
import org.layo.todolist.entity.TodoItem;
import org.layo.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Layo on 31.12.2014.
 */
@Service
@Transactional(readOnly = false)
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    TodoListDAO todoItemDAO;

    @Override
    public void addTodoItem(TodoItem todoItem) {
        todoItemDAO.addTodoItem(todoItem);
    }

    @Override
    public void updateTodoItem(TodoItem todoItem) {
        todoItemDAO.updateTodoItem(todoItem);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<TodoItem> getAllTodoItems() {
        return todoItemDAO.getAllTodoItems();
    }

    @Override
    public void deleteTodoItem(int id) {
        todoItemDAO.deleteTodoItem(id);
    }
}
