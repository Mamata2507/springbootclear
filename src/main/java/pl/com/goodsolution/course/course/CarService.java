package pl.com.goodsolution.course.course;

import org.springframework.stereotype.Service;

@Service
public class CarService {
    private EngineService engineService;

    public CarService(EngineService engineService) {
        this.engineService = engineService;
    }

    public void go() {
        engineService.start();
    }

}
