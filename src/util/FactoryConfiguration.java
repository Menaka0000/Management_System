package util;

import entity.Programme;
import entity.Registration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;


public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Properties properties=new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("Hibernate.property"));
        } catch (IOException e) {
            throw new RuntimeException("There is issue in hibernate util");
        }
        Configuration configuration=new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Programme.class)
                .addAnnotatedClass(Registration.class).mergeProperties(properties);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}

