package com.ronaldo.dojos_y_ninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ronaldo.dojos_y_ninjas.models.Ninja;

@Repository
public interface NinjaRepository extends
        CrudRepository<Ninja, Long>, PagingAndSortingRepository<Ninja, Long> {

}
