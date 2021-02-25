package pl.com.goodsolution.course.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import pl.com.goodsolution.course.course.movies.MovieService;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
public class CustomerApi {
    private static final Logger log = LoggerFactory.getLogger(CustomerApi.class);

    private final CustomerService customerService;


    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;

    }


    @GetMapping(path = "/api/customers/{id}", produces = "application/json; charset=UTF-8")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "/api/customers", produces = "application/json; charset=UTF-8")
    public List<Customer> findCustomers(@RequestParam(value = "height", required = false) Integer height,
                                        @RequestParam(value = "name", required = false) String name) {
        return customerService.findCustomers(height, name);
    }

    @PostMapping(path = "/api/customers", consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.create(customer);
    }

    @PutMapping(path = "/api/customers/{id}", consumes = "application/json; charset=UTF-8")
    public void modifyCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customerService.update(customer, id);
    }

    @DeleteMapping(path = "/api/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }

//    PD
// dopytać o distincty i czy to wogole jest dobrze i czy ścieżki tak można modyfikować i nazywać
    @GetMapping(path = "/api/distinctions", produces = "application/json; charset=UTF-8")
    public List<Customer> findDistinctCustomers(@RequestParam(value = "height", required = false) Integer height,
                                                @RequestParam(value = "name", required = false) String name){
        return customerService.findDistinctCustomers(name, height);
    }

    @GetMapping(path = "/api/customersbynameorheight", produces = "application/json; charset=UTF-8")
    public List<Customer> findCustomerByNameOrHeight(@RequestParam(value = "height") Integer height,
                                                @RequestParam(value = "name") String name){
        return customerService.findCustomersByHeightOrName(height, name);
    }

    @GetMapping(path = "/api/customersheightlessthan", produces = "application/json; charset=UTF-8")
    public List<Customer> findCustomerByHeightLessThan(@RequestParam(value = "height") Integer height) {
        return customerService.findCustomerByHeightLessThan(height);
    }

    @GetMapping(path = "/api/customersheightlessthanequal", produces = "application/json; charset=UTF-8")
    public List<Customer> findCustomerByHeightLessThanEqual(@RequestParam(value = "height") Integer height) {
        return customerService.findCustomerByHeightLessThanEqual(height);
    }

    @GetMapping(path = "/api/customersheightgreaterthan", produces = "application/json; charset=UTF-8")
    public List<Customer> findCustomerByHeightGreaterThan(@RequestParam(value = "height") Integer height) {
        return customerService.findCustomerByHeightGreaterTHan(height);
    }

    @GetMapping(path = "/api/customerbynamelike", produces = "application/json; charset=UTF-8")
    public List<Customer> findCustomersByNameLike(@RequestParam(value = "name") String name) {
        return customerService.findCustomersByName(name);
    }

    @GetMapping(path = "/api/customerbynamestartingwith", produces = "application/json; charset=UTF-8")
    public List<Customer> findCustomersByNameStartingWith(@RequestParam(value = "name") String name) {
        return customerService.findCustomerByNameStartingWith(name);
    }

    @GetMapping(path = "/api/customerbynamenotlike", produces = "application/json; charset=UTF-8")
    public List<Customer> findCustomersByNameNotLike(@RequestParam(value = "name") String name) {
        return customerService.findCustomersExcludedName(name);
    }

    @GetMapping(path =  "/api/customersbysetofheights", produces = "application/json; charset=UTF-8")
    public List<Customer> findCustomersBySetOfHeights(@RequestParam(value = "heights") Integer[] heights) {
        Set<Integer> setOfHeights = new HashSet<>();
        Collections.addAll(setOfHeights,heights);
        return customerService.findCustomerBySetOfHeights(setOfHeights);
    }


}
