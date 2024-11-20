package de.telran.onlineshop.repository;

import de.telran.onlineshop.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // начиная со Спринг 3.0 можно не ставить
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long> { // Long - это тип поля с автоинкрементом

}
