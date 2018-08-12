package demo;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        String[] inputName = scanner.nextLine().split(" ");
        String firstName = inputName[0];
        String secondName = inputName[1];

        em.getTransaction().begin();
        List<Employee> employees = em.createQuery("select e from Employee as e " +
                "WHERE e.firstName = ? and e.lastName = ?").setParameter(0, firstName)
                .setParameter(1, secondName).getResultList();

        em.getTransaction().commit();
        em.close();

        if(employees.size() == 0){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }

    }
}
