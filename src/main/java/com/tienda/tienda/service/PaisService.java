package com.tienda.tienda.service;

import com.tienda.tienda.entity.Pais;
import com.tienda.tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//el implements implementa todos los metodos de la clase que estamos llamando

@Service
public class PaisService implements IPaisService {

    @Autowired //para unir ambos objetos/instancias. Ese autowired crea el puente entre el Repository y el Service
    private PaisRepository paisRepository;

    @Override
    public List<Pais> listCountry() {
        return (List<Pais>) paisRepository.findAll();

    }
}
