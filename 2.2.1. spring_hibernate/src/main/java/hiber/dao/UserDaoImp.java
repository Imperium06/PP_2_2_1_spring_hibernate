package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public User getUserByCar(String modelCar, int seriesCar) {
      String hql = "select u from User u join u.car c where c.model LIKE :model and c.series =:series";

      Query<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class)
              .setParameter("model", modelCar)
              .setParameter("series", seriesCar);

      return query.getSingleResult(); //МЕТОД ОБЪЕДЕНЕН
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
