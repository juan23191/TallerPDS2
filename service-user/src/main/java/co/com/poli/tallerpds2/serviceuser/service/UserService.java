package co.com.poli.tallerpds2.serviceuser.service;

import co.com.poli.tallerpds2.serviceuser.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);
    void delete(User user);
    List<User> findAll();
    User findById(Long id);

}
