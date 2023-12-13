package com.example.login_register.service;

import com.example.login_register.entities.User;
import com.example.login_register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.login_register.entities.User.SEQUENCE_NAME;

@Service
public class UserServices {

    private final UserRepository userRepository;
    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private SequenceGeneratorService service;

    /*public User saveUser(User user) {
        User lastEntity = userRepository.findTopByOrderByIdDesc();
        long nextId = lastEntity != null ? lastEntity.getId() + 1 : 1;
        user.setId(nextId);
        return userRepository.save(user);
    }*/
    public User saveUser(User user){
        user.setId((long) service.getSequenceNumber(SEQUENCE_NAME));
        return userRepository.save(user);
    }

    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User user = new User();
        return userRepository.findByEmailAndPassword(email, password).orElse(user);
    }


}
