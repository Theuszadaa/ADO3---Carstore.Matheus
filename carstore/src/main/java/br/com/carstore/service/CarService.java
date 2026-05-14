package br.com.carstore.service;

import br.com.carstore.dto.CarDTO;

import java.util.List;

public interface CarService {

    List<CarDTO> findAll();

    void save(CarDTO carDTO);

    void deleteById(Long id);

    void update(Long id, CarDTO carDTO);

    CarDTO findById(Long id);
}