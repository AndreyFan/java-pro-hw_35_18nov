package de.telran.onlineshop.service;

import de.telran.onlineshop.model.Favorite;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FavoritesService {
    List<Favorite> favoriteList;

    @PostConstruct
    public void initFavorites() {
        favoriteList = new ArrayList<>();
        favoriteList.add(new Favorite(1, 1, 5));
        favoriteList.add(new Favorite(2, 2, 10));
        favoriteList.add(new Favorite(3, 4, 7));

        System.out.println("Выполняем логику при создании объекта " + this.getClass().getName());
    }

    @GetMapping
    public List<Favorite> getAllFavorites() {
        return favoriteList;
    }

    @GetMapping(value = "/find/{id}")
    public Favorite getFavoriteById(@PathVariable Long id) { ///categories/find/3
        return favoriteList.stream()
                .filter(favorite -> favorite.getFavoriteID() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping()
    public boolean addFavorite(@RequestBody Favorite favorite) {
        return favoriteList.add(favorite);
    }

    @PutMapping()
    public Favorite updateFavorite(@RequestBody Favorite updFavorite) {
        Favorite result = favoriteList.stream()
                .filter(favorite -> favorite.getFavoriteID() == updFavorite.getFavoriteID())
                .findFirst()
                .orElse(null);
        if (result != null) {
            result.setProductID(updFavorite.getProductID());
            result.setUserID(updFavorite.getUserID());
        }
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFavorite(@PathVariable Long id) {
        Iterator<Favorite> iterator = favoriteList.iterator();
        while (iterator.hasNext()) {
            Favorite favorite = iterator.next();
            if (favorite.getFavoriteID() == id) {
                iterator.remove();
            }
        }
    }

    @PreDestroy
    void destroyFavoritesList() {
        favoriteList.clear();
        System.out.println("Выполняем логику при окончании работы с  объектом " + this.getClass().getName());
    }

}
