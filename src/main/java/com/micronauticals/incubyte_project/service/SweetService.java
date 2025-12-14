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


}
