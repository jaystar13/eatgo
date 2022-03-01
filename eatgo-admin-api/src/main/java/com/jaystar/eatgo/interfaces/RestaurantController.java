package com.jaystar.eatgo.interfaces;

import com.jaystar.eatgo.application.RestaurantService;
import com.jaystar.eatgo.domain.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        return restaurantService.getRestaurants();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        return restaurantService.getRestaurant(id);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@Valid @RequestBody Restaurant resource) throws URISyntaxException {
        Restaurant restaurant = restaurantService.addRestaurant(
                Restaurant.builder()
                        .categoryId(resource.getCategoryId())
                        .name(resource.getName())
                        .address(resource.getAddress())
                        .build()
        );

        String url = "/restaurants/" + restaurant.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id") Long id, @Valid @RequestBody Restaurant resource) {
        Long categoryId = resource.getCategoryId();
        String name = resource.getName();
        String address = resource.getAddress();

        restaurantService.updateRestaurant(id, categoryId, name, address);

        return "{}";
    }
}
