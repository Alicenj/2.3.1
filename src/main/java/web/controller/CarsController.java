package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.CarsService;

@Controller
public class CarsController {

    private CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        model.addAttribute("carsList", carsService.getCarsByCount(count));
        return "cars";
    }
}