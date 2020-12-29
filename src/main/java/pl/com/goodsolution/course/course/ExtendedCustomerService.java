package pl.com.goodsolution.course.course;

import org.springframework.stereotype.Service;

@Service
public class ExtendedCustomerService implements ICustomerService {

    @Override
    public Long getCustomerCount() {
        return 2000L;
    }
}
