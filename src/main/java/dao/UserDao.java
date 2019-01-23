package dao;


/**
 * Нам понадобится класс UserDAO.
 * По-хорошему, программировать нужно через интерфейсы — создать интерфейс UserDAO и отдельно его реализацию UserDAOImpl,
 * но для сокращения объема кода я опущу это. Не делайте так в реальных проектах!).
 * DAO (data access object) — один из наиболее распространенных паттернов проектирования, "Доступ к данным".
 * Его смысл прост — создать в приложении слой, который отвечает только за доступ к данным, и больше ни за что.
 * Достать данные из БД, обновить данные, удалить данные — и все.
 * Data Access Object (DAO) — широко распространенный паттерн для сохранения объектов бизнес-области в базе данных.
 * В самом широком смысле, DAO — это класс, содержащий CRUD методы для конкретной сущности.
 *
 * В большинстве из них мы получаем объект Session (сессия соединения с нашей БД) с помощью нашей Фабрики Сессий,
 * создаем в рамках этой сессии одиночную транзакцию, выполняем необходимые преобразования данных,
 * сохраняем результат транзакции в БД и закрываем сессию. Сами методы тоже, как видите, довольно просты.
 *
 * Именно DAO — "сердце" нашего приложения. Однако, мы не будем создавать DAO напрямую и вызывать его методы в нашем методе main().
 */
import models.Auto;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class UserDao {

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
