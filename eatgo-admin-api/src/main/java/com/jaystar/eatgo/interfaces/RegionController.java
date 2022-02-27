package com.jaystar.eatgo.interfaces;

import com.jaystar.eatgo.application.RegionService;
import com.jaystar.eatgo.domain.Region;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class RegionController {

    private RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/regions")
    public List<Region> list() throws URISyntaxException {
        return regionService.getRegions();
    }

    @PostMapping("/regions")
    public ResponseEntity<?> create(@RequestBody Region resource) throws URISyntaxException {
        Region region = regionService.addRegion(resource.getName());

        String url = "/regions/" + region.getId();

        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
