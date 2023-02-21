package com.example.shoppinglist.service;

import com.example.shoppinglist.dto.RegisterDTO;
import com.example.shoppinglist.dto.UserDTO;
import com.example.shoppinglist.model.User;
import com.example.shoppinglist.repository.UserRepository;
import com.example.shoppinglist.util.LoggedUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    private final HttpSession session;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser, HttpSession session) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
        this.session = session;
    }

    // login logic
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }

    public boolean checkCredentials(String username, String password) {
        User user = getUserByUsername(username);

        if (user == null) {
            return false;
        }

        return passwordEncoder.matches(password, user.getPassword());
    }

    public void login(String username) {
        User user = getUserByUsername(username);
        this.loggedUser.setId(user.getId());
        this.loggedUser.setUsername(user.getUsername());
    }
    // admin and test
    public void initAdmin() {
        User admin = new User();
        admin.setUsername("aaa");
        admin.setPassword(passwordEncoder.encode("aaa"));
        admin.setEmail("a@a");
        userRepository.save(admin);
    }

    public void initTest() {
        User test = new User();
        test.setUsername("bbb");
        test.setPassword(passwordEncoder.encode("bbb"));
        test.setEmail("b@b");
        userRepository.save(test);
    }

    //register logic

    private UserDTO mapUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(userDTO.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }

    public UserDTO findUserByUsername(String username) {
        User user = this.userRepository.findByUsername(username).orElse(null);

        if (user == null) {
            return null;
        }

        return mapUserDTO(user);
    }

    public UserDTO findUserByEmail(String email) {
        User user = this.userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return null;
        }

        return mapUserDTO(user);
    }
    public User mapUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        return user;
    }

    public void register(RegisterDTO registerDTO) {
        this.userRepository.save(this.mapUser(registerDTO));
        this.login(registerDTO.getUsername());
    }

    // logout
    public void logout() {
        this.session.invalidate();
        this.loggedUser.setId(null);
        this.loggedUser.setUsername(null);
    }
}

