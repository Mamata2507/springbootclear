package pl.com.goodsolution.course.course;


import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "height")
    private Integer height;

    public Customer(Long id, String name, Integer height) {
        this.id = id;
        this.name = name;
        this.height = height;
    }

    public Customer(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
