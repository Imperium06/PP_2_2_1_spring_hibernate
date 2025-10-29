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
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User("User5", "Lastname4", "user4@mail.ru",
              new Car("Tesla", 10)));
      userService.add(new User("User6", "Lastname5", "user5@mail.ru",
              new Car("VAZ", 2106)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      User u = userService.getUserByCarByModel("Tesla");

      System.out.println("Id = "+u.getId());
      System.out.println("First Name = "+u.getFirstName());
      System.out.println("Last Name = "+u.getLastName());
      System.out.println("Email = "+u.getEmail());
      System.out.println("Car = "+u.getCar());
      System.out.println();

      User u2 = userService.getUserByCarBySeries(2106);

      System.out.println("Id = "+u2.getId());
      System.out.println("First Name = "+u2.getFirstName());
      System.out.println("Last Name = "+u2.getLastName());
      System.out.println("Email = "+u2.getEmail());
      System.out.println("Car = "+u2.getCar());
      System.out.println();


      context.close();
   }
}
