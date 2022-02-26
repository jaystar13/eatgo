package com.jaystar.eatgo.application;

import com.jaystar.eatgo.domain.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Long> {
    List<Region> findAll();
}
