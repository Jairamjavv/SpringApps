package jbr.mvc.dao;

import jbr.mvc.model.Login;
import jbr.mvc.model.User;
public interface UserDao {
  void register(User user);
  User validateUser(Login login);
}

