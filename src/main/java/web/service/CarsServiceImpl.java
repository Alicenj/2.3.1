package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    private List<Car> carsList = getCars();

    @Override
    public List<Car> getCarsByCount(int count) {
        int carsToShow = (count > 0 ? (count < 5 ? count : 5) : 0);
        return carsList.subList(0, carsToShow);
    }

    public static List<Car> getCars() {
        List<Car> result = new ArrayList<>();
        result.add(new Car("Audi", "RS4", 1999));
        result.add(new Car("Hennessey", "Venom", 2023));
        result.add(new Car("Kia", "Rio", 2000));
        result.add(new Car("Toyota", "Camry", 1992));
        result.add(new Car("BMW", "i5", 2023));
        return result;
    }
}