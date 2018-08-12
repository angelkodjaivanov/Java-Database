package demo;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesWithSalariesOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("select e from Employee as e where e.salary > 50000").getResultList();

        em.getTransaction().commit();
        em.close();


        for (Employee employee:employees
             ) {
            System.out.println(employee.getFirstName());
        }
    }
}
