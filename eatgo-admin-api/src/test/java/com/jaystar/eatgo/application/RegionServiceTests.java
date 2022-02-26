package com.jaystar.eatgo.application;

import com.jaystar.eatgo.domain.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class RegionServiceTests {

    @InjectMocks
    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getRegions() {
        List<Region> mockRegions = new ArrayList<>();
        mockRegions.add(Region.builder()
                .name("Seoul")
                .build());

        given(regionRepository.findAll()).willReturn(mockRegions);

        List<Region> regions = regionService.getRegions();

        Region region = regions.get(0);
        assertThat(region.getName()).isEqualTo("Seoul");
    }

    @Test
    void addRegion() {
        Region region = regionService.addRegion("Seoul");

        verify(regionRepository).save(any());

        assertThat(region.getName()).isEqualTo("Seoul");
    }
}
