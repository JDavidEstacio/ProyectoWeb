package com.proyecto.proyectoweb.interfaceService;

import java.util.List;
import java.util.Optional;

import com.proyecto.proyectoweb.modelo.Salon;

public interface ISalonService {
    public List<Salon> listar();
    public Optional<Salon> listarId(int id);
    public int save(Salon s);
    public void delete(int id);
}
