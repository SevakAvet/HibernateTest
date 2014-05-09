package com.sevak_avet;

import com.sevak_avet.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user1 = new User("sevak", "pass");
        User user2 = new User("tatevik", "pass");

        session.save(user1);
        session.save(user2);

        List<User> users = (List<User>) session.createQuery("from User").list();
        for (User user : users) {
            System.out.println(user.getEmail() + " " + user.getPassword());
        }

        session.getTransaction().commit();
        session.close();
    }
}
