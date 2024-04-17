package dao;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

import static util.HibernateUtil.getSessionFactory;

public class ProductDao {
    private final SessionFactory sessionFactory;
    public ProductDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    Session session;
    public void createProductEntity(Product product){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }
    }

    public List<Product> displayProducts(){
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("FROM product_table", Product.class).list();
        }
    }
    public List<Product> notifyLowStocks(){
        try (Session session = getSessionFactory().openSession()) {
            System.out.println("This list contains products that have only 3 or less quantity");
            return  session.createQuery("FROM product_table where quantity <= 3", Product.class).list();
        }
    }
}