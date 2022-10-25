package repository;

import entity.Department;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

public class DepartmentRepository {
    public List<Department> findAll() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Department", Department.class)
                    .getResultList();
        }
    }

    public Department findById(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session.get(Department.class, id);
        }
    }

    public Department findByName(String name) {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Department WHERE name = :name", Department.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    public void create(Department department) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(department);
            session.getTransaction().commit();
        }
    }

    public void update(Department department) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.merge(department);
            session.getTransaction().commit();
        }
    }

    public void deleteById(int id){
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            Department old = session.get(Department.class, id);
            session.remove(old);
            session.getTransaction().commit();
        }
    }

    public boolean existById(int id){
        return findById(id) != null;
    }

    public boolean existByName(String name){
        return findByName(name) != null;
    }
}
