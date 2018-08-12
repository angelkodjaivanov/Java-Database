package demo;

import model.Customer;
import model.Product;
import model.Sale;
import model.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class MainAppSales {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        List<Product> products = em.createQuery("SELECT p FROM Product AS p").getResultList();
        List<Customer> customers = em.createQuery("select c from Customer AS c").getResultList();
        List<StoreLocation> storeLocations = em.createQuery("select s from StoreLocation as s").getResultList();

        Sale sale = new Sale(products.get(0), customers.get(0), storeLocations.get(0), "01-01-2001");
        em.persist(sale);

        em.getTransaction().commit();
        em.close();
    }
}
