package pl.com.goodsolution.course.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Api {
    private static final Logger log = LoggerFactory.getLogger(Api.class);
    private ICustomerService customerService;

    public Api(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/api/cars/{id}", produces = "application/json; charset=UTF-8")
    public Car getCar(@PathVariable Long id) {
        return new Car(customerService.getCustomerCount().intValue(), "SD2132423_" + id);
    }

    @GetMapping(path = "/api/cars", produces = "application/json; charset=UTF-8")
    public List<Car> findCars(@RequestParam(value = "power") int power) {

        List<Car> cars = Arrays.asList(
                new Car(500, "HGW 12345"),
                new Car(1500, "GHW 54321"));
        return cars.stream().filter(car -> power == car.getPower()).collect(Collectors.toList());
    }

    @PostMapping(path = "/api/cars", consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public void createCar(@RequestBody Car car) {
        log.info("Car created correctly.");
    }

    @PutMapping(path = "/api/cars/{id}", consumes = "application/json; charset=UTF-8")
    public void modifyCar(@PathVariable Long id, @RequestBody Car car) {
        log.info(id + " car updated.");
    }

    @DeleteMapping(path = "/api/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        log.info("Car " + id + " deleted successfully.");
    }

//CRUD
//    Create
//    Retrieve
//    Update
//    Delete
}
