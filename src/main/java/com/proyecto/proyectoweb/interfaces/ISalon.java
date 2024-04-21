package com.proyecto.proyectoweb.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyectoweb.modelo.Salon;

@Repository
public interface ISalon extends CrudRepository<Salon, Integer> {

}
