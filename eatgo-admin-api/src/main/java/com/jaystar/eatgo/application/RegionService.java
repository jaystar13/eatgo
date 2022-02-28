package com.jaystar.eatgo.application;

import com.jaystar.eatgo.domain.Region;
import com.jaystar.eatgo.domain.RegionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegionService {
    private RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

    public Region addRegion(String name) {
        Region region = Region.builder()
                .name(name)
                .build();

        regionRepository.save(region);

        return region;
    }
}
