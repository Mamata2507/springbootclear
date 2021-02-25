package pl.com.goodsolution.course.course;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Set;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByHeightAndName(Integer height, String name);

    List<Customer> findByHeight(Integer height);

    List<Customer> findByName(String name);

    List<Customer> findDistinctByName(String name);

    List<Customer> findDistinctByHeight(Integer height);

    List<Customer> findDistinctByNameAndHeight(String name, Integer height);

    List<Customer> findByHeightOrName(Integer height, String name);

    List<Customer> findByHeightLessThan(Integer height);

    List<Customer> findByHeightLessThanEqual(Integer height);

    List<Customer> findByHeightGreaterThan(Integer height);

    List<Customer> findByNameLike(String name);

    List<Customer> findByNameNotLike(String name);

    List<Customer> findByNameStartingWith(String name);

    List<Customer> findByHeightIn(Set<Integer> heights);

    @Query("SELECT c FROM Customer c WHERE c.id = :id")
    Customer getCustomerById(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM Customer c WHERE c.id = :id")
    void deleteCustomerById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Customer c SET c.name = :name, c.height = :height WHERE c.id = :id")
    void updateCustomer(@Param("id") Long id, @Param("name") String name, @Param("height") Integer height);

}
