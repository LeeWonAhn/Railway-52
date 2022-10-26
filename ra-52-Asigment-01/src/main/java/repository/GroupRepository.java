package repository;

import entity.Group;
import org.hibernate.Session;
import ultis.HibernateUtils;

import java.util.List;

public class GroupRepository {
    public List<Group> getAllGroups() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Group", Group.class)
                    .getResultList();
        }
    }


    public void createGroup(Group group) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(group);
            session.getTransaction().commit();
        }
    }

    public Group getGroupByID(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session.get(Group.class, id);
        }
    }

    public Group getGroupByName(String name) {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Group WHERE name = :name", Group.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    public void updateGroup(Group group) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.merge(group);
            session.getTransaction().commit();
        }
    }

    public void deleteGroup(int id) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            Group old = session.get(Group.class, id);
            session.remove(old);
            session.getTransaction().commit();
        }
    }

    public boolean isGroupExistsByID(int id) {
        return getGroupByID(id) != null;
    }

    public boolean isGroupExistsByName(String name) {
        return getGroupByName(name) != null;
    }
}
