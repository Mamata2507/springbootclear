package pl.com.goodsolution.course.course;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void create(Customer customer) {
        customerRepository.save(customer);
      }

//    filtrowanie na bazie
    @Transactional
    public void update(Customer customer, Long id) {
//        Customer customerFromDb = customerRepository.findById(id).get();
//        customerFromDb.setName(customer.getName());
//        customerFromDb.setHeight(customer.getHeight());
//        customerRepository.save(customerFromDb);
        customerRepository.updateCustomer(id, customer.getName(), customer.getHeight());
    }

//    filtrowanie za pomoca streama

    public void updateViaStream(Customer customer, Long id) {
        List<Customer> customers = StreamSupport.stream(customerRepository.findAll().spliterator(),false).collect(Collectors.toList());
        Customer customerFromDb = customers.stream()
                .filter(customer1 -> id.equals(customer1.getId()))
                .findAny()
                .orElse(null);
        customerFromDb.setName(customer.getName());
        customerFromDb.setHeight(customer.getHeight());
        customerRepository.save(customerFromDb);
    }

    @Transactional
    public void delete(Long id) {
//        customerRepository.deleteById(id);
        customerRepository.deleteCustomerById(id);
    }

    public Customer getCustomer(Long id) {
//        return customerRepository.findById(id).get();
        return customerRepository.getCustomerById(id);
    }

    public List<Customer> findCustomers(Integer height, String name) {
        if (height == null && name == null) {
            return StreamSupport.stream(customerRepository.findAll().spliterator(), false).collect(Collectors.toList());
        } else if (height == null && name != null) {
            return customerRepository.findByName(name);
        } else if (height != null && name == null) {
            return customerRepository.findByHeight(height);
        } else {
            return customerRepository.findByHeightAndName(height, name);
        }
    }
//to nie wiem czy jest dobrze zrobione: wyrzuca 404
    public List<Customer> findDistinctCustomers(String name, Integer height){
        if(name != null && height == null) {
            return customerRepository.findDistinctByName(name);
        }
        else if (height != null && name == null) {
            return customerRepository.findDistinctByHeight(height);
        }
        else {
            return customerRepository.findDistinctByNameAndHeight(name,height);
        }
    }
//tu powinienem robić ify jak w szukaniu po imieniu i wzroscie? wyrzuca 404
    public List<Customer> findCustomersByHeightOrName(Integer height, String name) {
        return customerRepository.findByHeightOrName(height,name);
    }

    public List<Customer> findCustomerByHeightLessThan(Integer height) {
        return customerRepository.findByHeightLessThan(height);
    }

    public List<Customer> findCustomerByHeightLessThanEqual(Integer height) {
        return customerRepository.findByHeightLessThanEqual(height);
    }

    public List<Customer> findCustomerByHeightGreaterTHan(Integer height) {
        return customerRepository.findByHeightGreaterThan(height);
    }

    public List<Customer> findCustomersByName(String name) {
        return customerRepository.findByNameLike(name);
    }

    public List<Customer> findCustomersExcludedName(String name) {
        return customerRepository.findByNameNotLike(name);
    }

    public List<Customer> findCustomerByNameStartingWith(String name) {
        return customerRepository.findByNameStartingWith(name);
    }

    public List<Customer> findCustomerBySetOfHeights(Set<Integer> heights) {
        return customerRepository.findByHeightIn(heights);
    }


//    1. filtrowanie za pomoca streama - nie zalecany - zrobic w domu
//    2. filtrowanie na bazie - w repozytorium - zrobione

//    1. get po id z repozytorium zwraca encje - stworzyc
//    2. zwróconą encję zmieniamy pola ktore mamy zmienic
//    3. zmodyfikowana -> save na repo


    @Override
    public Long getCustomerCount() {
        return 1000L;
    }


}
