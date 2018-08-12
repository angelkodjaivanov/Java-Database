package demo;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        List<Town> towns = em.createQuery("SELECT t FROM Town AS t WHERE CHAR_LENGTH(t.name) > 5").getResultList();
        em.getTransaction().commit();

        for(int i = 0; i < towns.size(); i++){
            towns.get(i).setName(towns.get(i).getName().toLowerCase());
        }

        em.getTransaction().begin();
        for (Town town:towns
             ) {
            em.persist(town);
        }
        em.getTransaction().commit();
    }
}
