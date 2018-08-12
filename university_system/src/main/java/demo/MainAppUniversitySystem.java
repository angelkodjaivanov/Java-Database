package demo;

import model.Course;
import model.Student;
import model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainAppUniversitySystem {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("university_system");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student student = new Student("Ivan", "Ivanov", "0883883898",
                BigDecimal.valueOf(5.88), 10);

        Course course = new Course("Math_Course", "01-01-2018", "06-3-2018", 100.0);

        Teacher teacher = new Teacher("Angel", "Angelov", "0889253554", "angel.angelov@gmail.com",
                BigDecimal.valueOf(12.50));

        List<Course> courses = new ArrayList<>();
        courses.add(course);
        student.setCourses(courses);

        List<Student> students = new ArrayList<>();
        students.add(student);
        course.setStudents(students);
        course.setTeacher(teacher);

        teacher.setCourses(courses);

        em.persist(student);
        em.persist(teacher);
        em.persist(course);

        em.getTransaction().commit();
        em.close();
    }
}
