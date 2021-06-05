package nicomed.backend.service;

import nicomed.backend.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
    void save(User user);
    void delete (User user);
}
