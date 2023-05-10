package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImp implements CarService {
    private final List<Car> cars;
    {
        cars = new ArrayList<>();

        cars.add(new Car(1L, "Model1", 1));
        cars.add(new Car(2L, "Model2", 2));
        cars.add(new Car(3L, "Model3", 3));
        cars.add(new Car(4L, "Model4", 4));
        cars.add(new Car(5L, "Model5", 5));
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> listCars(int count) {
        return cars.subList(0, count);
    }
}
