package dao;

import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

import static util.HibernateUtil.getSessionFactory;

public class CategoryDao {
    SessionFactory sessionFactory;
    public CategoryDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void createCategory(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        }
    }

    public List<Category> displayCategories() {
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("FROM category_table", Category.class).list();
        }
    }
}
