package org.layo.todolist.dao.impl;

import org.layo.todolist.dao.TodoItemDAO;

/**
 * Created by Layo on 23.12.2014.
 */
public class Factory {

    private static TodoItemDAO todoItemDAO = null;
    private static Factory instance = null;

    public static Factory getInstance()
    {
        if (instance == null)
        {
            instance = new Factory();
        }
        return instance;
    }
    // Avoiding instantiating more DAO's than necessary
    public TodoItemDAO getTodoItemDAO()
    {
        if (todoItemDAO == null)
        {
            todoItemDAO = new TodoItemDAOImpl();
        }
        return todoItemDAO;
    }
}
