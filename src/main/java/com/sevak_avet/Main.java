package com.sevak_avet;

import com.sevak_avet.domain.Answer;
import com.sevak_avet.old.Questionary;
import com.sevak_avet.domain.Topic;
import com.sevak_avet.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import static com.sevak_avet.TopicTestSimple.engTopic;
import static com.sevak_avet.TopicTestSimple.rusTopic;

public class Main {
    private static Session session;

    public static void main(String[] args) {
        fillDB();

        SessionFactory factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        ((List<Topic>) session.createQuery("select topic from Topic topic," +
                "Answer ans where" +
                "(ans.gender = 'ж')" +
                "and (ans.faculty = 'ИФИЖ')" +
                "and (ans.userId = topic.userId)")
                .list()).stream().forEach(i -> {
            System.out.println(i.getTopic());
            System.out.println("------------------");
        });

        session.getTransaction().commit();
        session.close();
    }

    private static void fillDB() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        session.beginTransaction();

        session.save(new User("email1", "pass1"));
        session.save(new User("email2", "pass2"));
        session.save(new User("email3", "pass3"));
        session.save(new User("email4", "pass4"));
        session.save(new User("email5", "pass5"));

        session.save(new Questionary("ФИО"));
        session.save(new Questionary("Дата рождения"));
        session.save(new Questionary("Пол"));
        session.save(new Questionary("Факультет"));

        fillQuestionary(1, "Иванов Иван Иванович", "05.03.1996", "м", "КНиИТ");
        fillQuestionary(2, "Петров Валерий Васильевич", "03.05.1995", "м", "КНиИТ");
        fillQuestionary(3, "Сидоров Алексей Святославович", "01.01.1985", "м", "Биофак");
        fillQuestionary(4, "Сидорова Александра Сергеевна", "01.06.1993", "ж", "ИФИЖ");
        fillQuestionary(5, "Большова Анна Николаевна", "05.09.1992", "ж", "ИФИЖ");

        for (int j = 1; j <= 5; j++) {
            session.save(new Topic(j, 1, rusTopic[j - 1]));
            session.save(new Topic(j, 2, engTopic[j - 1]));
        }

        session.getTransaction().commit();
        session.close();
    }

    private static void fillQuestionary(int userId, String... ans) {
        session.save(new Answer(userId, ans[0], ans[1], ans[2], ans[3]));
    }
}
