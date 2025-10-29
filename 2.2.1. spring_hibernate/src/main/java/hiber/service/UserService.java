package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getUserByCarByModel(String modelCar);
    User getUserByCarBySeries(int series);
    List<User> listUsers();
}
