package org.layo.todolist.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.layo.todolist.dao.TodoListDAO;
import org.layo.todolist.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Layo on 21.12.2014.
 */
@Service
public class TodoListDAOImpl implements TodoListDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTodoItem(TodoItem todoItem) {
        sessionFactory.getCurrentSession().save(todoItem);
    }

    @Override
    public void updateTodoItem(TodoItem todoItem) {
        sessionFactory.getCurrentSession().update(todoItem);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TodoItem> getAllTodoItems() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TodoItem.class);
        return criteria.list();
    }

    @Override
    public void deleteTodoItem(int id) {
        TodoItem todoItem = new TodoItem(id);
        sessionFactory.getCurrentSession().delete(todoItem);
    }
}
