package com.proyecto.proyectoweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyectoweb.interfaceService.ISalonService;
import com.proyecto.proyectoweb.interfaces.ISalon;
import com.proyecto.proyectoweb.modelo.Salon;

@Service 
public class SalonService implements ISalonService{

    @Autowired
    private ISalon data;

    @Override
    public List<Salon> listar() {
        return (List<Salon>)data.findAll();
    }

    @Override
    public Optional<Salon> listarId(int id) {
       return data.findById(id);
    }

    @Override
    public int save(Salon s) {
        int res=0;
        Salon salon = data.save(s);
        if (salon != null){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
