package de.telran.onlineshop.service;

import de.telran.onlineshop.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class UsersService {
    private List<User> userList;

    @PostConstruct
    void initUsers() {
        userList = new ArrayList<>();

        userList.add(new User(1, "Peter", "peter@gmail/com", "+4915121748923", "peter45", User.Role.ADMINISTRATOR));
        userList.add(new User(2, "Olga", "olga@gmail/com", "+4915121748977", "olga24", User.Role.CLIENT));
        userList.add(new User(3, "Peter", "peter@gmail/com", "+4915121748923", "peter45", User.Role.CLIENT));
        userList.add(new User(4, "Max", "max@gmail/com", "+4915735748923", "max27", User.Role.CLIENT));
        userList.add(new User(5, "Irina", "irina@gmail/com", "+4912115856727", "irina31", User.Role.CLIENT));

        System.out.println("Выполняем логику при создании объекта "+this.getClass().getName());
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserByID(@PathVariable Long id) {
        return userList.stream()
                .filter(user -> user.getUserID()==id)
                .findFirst()
                .orElse(null);
    }

    public User getUserByName(@RequestParam String name) { ///users/get?name=Peter
        return userList.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean createUsers(@RequestBody User newUser) { //insert
        return userList.add(newUser);
    }

    public User updateUsers(@RequestBody User updUser) { //update
        User result = userList.stream()
                .filter(user -> user.getUserID() == updUser.getUserID())
                .findFirst()
                .orElse(null);
        if(result!=null) {
            result.setName(updUser.getName());
            result.setEmail(updUser.getEmail());
            result.setPhoneNumber(updUser.getPhoneNumber());
            result.setPasswordHash(updUser.getPasswordHash());
            result.setRole(updUser.getRole());
        }
        return result;
    }

    public void deleteUsers(@PathVariable Long id) { //delete
        Iterator<User> it = userList.iterator();
        while (it.hasNext()) {
            User current = it.next();
            if(current.getUserID()==id) {
                it.remove();
            }
        }
    }

    public void destroyUser() {
        userList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом "+this.getClass().getName());
    }


}
