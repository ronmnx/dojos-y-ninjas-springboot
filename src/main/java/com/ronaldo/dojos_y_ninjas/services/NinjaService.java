package com.ronaldo.dojos_y_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ronaldo.dojos_y_ninjas.models.Ninja;
import com.ronaldo.dojos_y_ninjas.repositories.NinjaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class NinjaService {

    private static final int PAGE_SIZE = 5;

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> findAll() {
        return (List<Ninja>) ninjaRepository.findAll();
    }

    public Ninja findById(Long id) {
        Optional<Ninja> opNinja = ninjaRepository.findById(id);
        return opNinja == null ? null : opNinja.get();
    }

    public Ninja saveNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public void delete(Long id) {
        ninjaRepository.deleteById(id);
    }

    public Page<Ninja> ninjasPerPage(int pageNumber) {
        // Obtener todas las páginas de ninjas y clasificarlas en orden ascendente por
        // apellido.
        // PageRequest pageRequest = new PageReq;
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "createdAt");
        // Sort.Direction.ASC, "lastName");
        // new PageRequest(pageNumber, PAGE_SIZE, SortDirection.ASCENDING, "lastName");

        Page<Ninja> ninjas = ninjaRepository.findAll(pageRequest);
        return ninjas;
    }
}
