package de.telran.onlineshop.controller;

import de.telran.onlineshop.model.Category;
import de.telran.onlineshop.model.User;
import de.telran.onlineshop.service.CategoriesService;
import de.telran.onlineshop.service.UsersService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    // GET - Получение всех пользователей
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    // GET - Получение пользователя по ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = usersService.getUserByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // GET - Получение пользователя по имени
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/get")
    public User getUserByName(@RequestParam String name) {
        return usersService.getUserByName(name);
    }

    // POST - Создание нового пользователя
    @PostMapping
    public ResponseEntity<Boolean> createUsers(@RequestBody User newUser) {
        boolean isCreated = usersService.createUsers(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(isCreated);
    }

    // PUT - Обновление пользователя
    @PutMapping
    public ResponseEntity<User> updateUsers(@RequestBody User updUser) {
        User updatedUser = usersService.updateUsers(updUser);
        return ResponseEntity.status(202).body(updatedUser);
    }

    // DELETE - Удаление пользователя
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
        return ResponseEntity.status(204).build();
    }

    // @PreDestroy - Завершение работы сервиса
    @PreDestroy
    public void destroyUser() {
        usersService.destroyUser();
    }

    // Обработка исключений
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body("Извините, что-то пошло не так. Попробуйте позже!");
    }
}

