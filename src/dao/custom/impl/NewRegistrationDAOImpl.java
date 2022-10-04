package dao.custom.impl;

import dao.custom.NewRegistrationDAO;
import dto.NewRegistrationDTO;
import entity.Programme;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class NewRegistrationDAOImpl implements NewRegistrationDAO {

    @Override
    public List<String> getAllProgrammes() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query programme = session.createQuery("select name from programme");

        List list = programme.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean newRegistration(NewRegistrationDTO nReDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(nReDTO.getRegistration().getStudentId());
        session.save(nReDTO.getRegistration());
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean newReForExistingStu(NewRegistrationDTO nReDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(nReDTO.getRegistration());
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student getStudentDetail(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        transaction.commit();
        session.close();
        return student;
    }


    @Override
    public List<Programme> getProgramme(String name1) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM programme where name =:programme_name";
        Query programme = session.createQuery(hql);
        programme.setParameter("programme_name", name1);
        List list = programme.list();
        transaction.commit();
        session.close();
        return list;


       /* String hql = "FROM Owner WHERE oName = :owner_name";
        Query query = session.createQuery(hql);
        query.setParameter("owner_name", name);
        List<Owner> result = query.list();*/
    }

    @Override
    public List<Programme> getRegisteredPro(String id) {
        System.out.println(id);
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = " SELECT programmeId FROM registration WHERE student_id =:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List list = query.list();
        transaction.commit();
        session.close();
        System.out.println(list);
        return list;
        /* select programmeList_id from student_programme where studentList_id= 'S001'*/


    }
}
