package id.my.hendisantika.gcpdatastore.controller;

import com.google.api.client.util.Lists;
import id.my.hendisantika.gcpdatastore.entity.User;
import id.my.hendisantika.gcpdatastore.exception.ResourceNotFoundException;
import id.my.hendisantika.gcpdatastore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-gcp-datastore
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 10/03/25
 * Time: 07.27
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    // get all users rest API
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    // get all users by name rest API
    @GetMapping("/users/name/{name}")
    public List<User> getAllUsersByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    // get all users by country rest API
    @GetMapping("/users/country/{name}")
    public List<User> getAllUsersByCountry(@PathVariable String name) {
        return userRepository.findByCountry(name);
    }

    // create user rest API
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // get user by id rest api
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User not exist with id :" + id));
        return ResponseEntity.ok(user);
    }

    // update user rest api
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User not exist with id :" + id));
        user.setCountry(userDetails.getCountry());
        user.setEmail(userDetails.getEmail());
        user.setName(userDetails.getName());
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // delete user rest api
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User not exist with id :" + id));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
