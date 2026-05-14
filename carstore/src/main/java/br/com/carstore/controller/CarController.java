package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("cars", service.findAll());

        model.addAttribute("carDTO", new CarDTO());

        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {

        model.addAttribute("carDTO", new CarDTO());

        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute CarDTO carDTO) {

        service.save(carDTO);

        return "redirect:/";
    }
}