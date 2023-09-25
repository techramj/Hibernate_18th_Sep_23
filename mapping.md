public class Mapping {
    
}

@Entity
class Employee{
    @Id
    private Long id;
    private String name;
    private Double salary;
    @OneToOne
    private Address address;

}


@Entity
class Address{
    @Id
    private Long addressId;
    private String city;
    private String pincode;
}
