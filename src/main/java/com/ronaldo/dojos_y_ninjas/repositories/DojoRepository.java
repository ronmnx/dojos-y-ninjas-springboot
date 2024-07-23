package com.ronaldo.dojos_y_ninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ronaldo.dojos_y_ninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

}
