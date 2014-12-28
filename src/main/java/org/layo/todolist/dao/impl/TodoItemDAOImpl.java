package org.layo.todolist.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.layo.todolist.dao.TodoItemDAO;
import org.layo.todolist.entity.TodoItem;
import org.layo.todolist.utility.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Layo on 21.12.2014.
 */
public class TodoItemDAOImpl implements TodoItemDAO{

    @Override
    public void addTodoItem(TodoItem todoItem) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(todoItem);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateTodoItem(int id, TodoItem todoItem) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(todoItem);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List getAllTodoItems() {
        Session session = null;
        List<TodoItem> todoItems = new ArrayList<TodoItem>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            todoItems = session.createCriteria(TodoItem.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return todoItems;
    }

    @Override
    public void deleteTodoItem(int id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            TodoItem todoItem = new TodoItem(id);
            session.delete(todoItem);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
