package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",
              new Car("BMW", 6)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User("User5", "Lastname4", "user4@mail.ru",
              new Car("Tesla", 10)));
      userService.add(new User("User6", "Lastname5", "user5@mail.ru",
              new Car("VAZ", 2106)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      User u = userService.getUserByCar("Tesla", 10);
      System.out.println(u);

      User u2 = userService.getUserByCar("VAZ", 2106);
      System.out.println(u2);

      User u3 = userService.getUserByCar("BMW", 6);
      System.out.println(u3);


      context.close();
   }
}
