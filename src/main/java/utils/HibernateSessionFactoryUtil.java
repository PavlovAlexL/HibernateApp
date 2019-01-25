package utils;

import models.Auto;
import models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){

    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try{
                //Configuration configuration = new Configuration();
                //configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db_pchat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
                //configuration.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
                //configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                //configuration.setProperty("hibernate.connection.username", "root");
                //configuration.setProperty("hibernate.connection.password", "mysql");
                //configuration.setProperty("hibernate.show_sql", "true");
                //configuration.configure();
                Configuration configuration = new Configuration().configure();  //создаем новый объект конфигураций Configuration, и передаем ему те классы, которые он должен воспринимать как сущности — UserDao и Auto.

                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Auto.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e){
                System.out.println("Исключение!" + e);
            }

        }
        return sessionFactory;
    }

}
