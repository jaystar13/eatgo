package com.jaystar.eatgo.application;

import com.jaystar.eatgo.domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAll();
}
