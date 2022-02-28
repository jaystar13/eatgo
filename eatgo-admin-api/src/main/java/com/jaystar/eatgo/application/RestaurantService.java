package com.jaystar.eatgo.application;

import com.jaystar.eatgo.domain.Restaurant;
import com.jaystar.eatgo.domain.RestaurantNotFoundException;
import com.jaystar.eatgo.domain.RestaurantRepository;

import javax.transaction.Transactional;
import java.util.List;

public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }

    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, Long categoryId, String name, String address) {
        Restaurant restaurant = getRestaurant(id);

        restaurant.updateInformation(categoryId, name, address);

        return restaurant;
    }
}
