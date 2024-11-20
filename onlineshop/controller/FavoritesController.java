package de.telran.onlineshop.controller;

import de.telran.onlineshop.model.Category;
import de.telran.onlineshop.model.Favorite;
import de.telran.onlineshop.service.FavoritesService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {
    private FavoritesService favoritesService;
    @Autowired
    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }
    @GetMapping
    public List<Favorite> getAllFavorites() {
        return favoritesService.getAllFavorites();
    }


    @GetMapping(value = "/find/{id}")
    Favorite getFavoriteById(@PathVariable Long id) { ///categories/find/3
        return favoritesService.getFavoriteById(id);
    }

    @PostMapping()
    public boolean addFavorite(@RequestBody Favorite favorite) {
        return favoritesService.addFavorite(favorite);
    }

    @PutMapping()
    public Favorite updateFavorite(@RequestBody Favorite updFavorite) {
        return favoritesService.updateFavorite(updFavorite);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFavorite(@PathVariable Long id) {
     favoritesService.deleteFavorite(id);
    }
    // альтернативная обработка ошибочной ситуации Exception
    @ExceptionHandler({IllegalArgumentException.class, FileNotFoundException.class})
    public ResponseEntity handleTwoException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body("Извините, что-то пошло не так. Попробуйте позже!");
    }

}