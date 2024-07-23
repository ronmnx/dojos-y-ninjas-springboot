package com.ronaldo.dojos_y_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldo.dojos_y_ninjas.models.Dojo;
import com.ronaldo.dojos_y_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> findAll() {
        return (List<Dojo>) dojoRepository.findAll();
    }

    public Dojo findById(Long id) {
        Optional<Dojo> opDojo = dojoRepository.findById(id);
        Dojo dojo = opDojo == null ? null : opDojo.get();
        return dojo;
    }

    public Dojo save(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    public void delete(Long id) {
        dojoRepository.deleteById(id);
    }

}
