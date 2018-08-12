package demo;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class EmoloyeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("select e from Employee as e " +
                "where e.department.name = 'Research and Development'").getResultList();

        em.getTransaction().commit();
        em.close();

        employees.sort(Comparator.comparing(Employee::getSalary));

        for (Employee employee:employees
             ) {
            System.out.println(employee.getFirstName() + " " + employee.getLastName() + " from Research and Development - $"
                + employee.getSalary());
        }
    }
}
