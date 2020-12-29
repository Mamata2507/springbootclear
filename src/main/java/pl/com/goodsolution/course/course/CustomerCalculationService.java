package pl.com.goodsolution.course.course;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CustomerCalculationService {
    private CustomerService customerService;

    public CustomerCalculationService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public BigDecimal calculatePriceForAllCustomers() {
        Long count = customerService.getCustomerCount();
        return BigDecimal.valueOf(count).multiply(BigDecimal.valueOf(5));
    }
}
