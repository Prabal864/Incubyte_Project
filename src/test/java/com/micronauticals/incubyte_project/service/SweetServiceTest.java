package com.micronauticals.incubyte_project.service;


import com.micronauticals.incubyte_project.model.Sweet;
import com.micronauticals.incubyte_project.repository.SweetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SweetServiceTest {

    @Mock
    private SweetRepository sweetRepository;

    @InjectMocks
    private SweetService sweetService;

    private Sweet testSweet;

    @BeforeEach
    void setUp() {
        testSweet = new Sweet();
        testSweet.setId(1L);
        testSweet.setName("Chocolate Bar");
        testSweet.setCategory("Chocolate");
        testSweet.setPrice(2.50);
        testSweet.setQuantity(100);
    }

    @Test
    void testCreateSweet() {
        when(sweetRepository.save(any(Sweet.class))).thenReturn(testSweet);

        Sweet created = sweetService.createSweet(testSweet);

        assertNotNull(created);
        assertEquals("Chocolate Bar", created.getName());
        verify(sweetRepository, times(1)).save(testSweet);
    }

    @Test
    void testSweetWithId() {
        Sweet sweet = new Sweet();
        sweet.setId(1L);
        sweet.setName("Gummy Bears");

        assertEquals(1L, sweet.getId());
        assertEquals("Gummy Bears", sweet.getName());
    }


}
