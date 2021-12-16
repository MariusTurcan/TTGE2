package TTGE.controller;

import TTGE.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import TTGE.repository.CarRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars/")
public class CarController {

  private final CarRepository carRepository;

  @Autowired
  public CarController(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @GetMapping("signup")
  public String showSignUpForm(Car car) {
    return "add-car";
  }

  @GetMapping("list")
  public String showUpdateForm(Model model) {
    model.addAttribute("cars", carRepository.findAll());
    return "index";
  }

  @PostMapping("add")
  public String addCar(@Valid Car car, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "add-car";
    }

    carRepository.save(car);
    return "redirect:list";
  }

  @GetMapping("edit/{id}")
  public String showUpdateForm(@PathVariable("id") long id, Model model) {
    Car car = carRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
    model.addAttribute("car", car);
    return "update-car";
  }

  @PostMapping("update/{id}")
  public String updateCar(@PathVariable("id") long id, @Valid Car car, BindingResult result,
                          Model model) {
    if (result.hasErrors()) {
      car.setId(id);
      return "update-car";
    }

    carRepository.save(car);
    model.addAttribute("cars", carRepository.findAll());
    return "index";
  }

  @GetMapping("delete/{id}")
  public String deleteCar(@PathVariable("id") long id, Model model) {
    Car car = carRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
    carRepository.delete(car);
    model.addAttribute("cars", carRepository.findAll());
    return "index";
  }
}
