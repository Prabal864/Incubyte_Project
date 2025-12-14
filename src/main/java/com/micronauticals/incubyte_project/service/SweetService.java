package com.micronauticals.incubyte_project.service;


import com.micronauticals.incubyte_project.model.Sweet;
import com.micronauticals.incubyte_project.repository.SweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SweetService {

    @Autowired
    private SweetRepository sweetRepository;

    public Sweet createSweet(Sweet sweet) {
        return sweetRepository.save(sweet);
    }

    public Sweet getSweetById(Long id) {
        return sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found with id: " + id));
    }

    public Sweet updateSweet(Long id, Sweet sweetDetails) {
        Sweet sweet = getSweetById(id);
        sweet.setName(sweetDetails.getName());
        sweet.setCategory(sweetDetails.getCategory());
        sweet.setPrice(sweetDetails.getPrice());
        sweet.setQuantity(sweetDetails.getQuantity());
        return sweetRepository.save(sweet);
    }

}
