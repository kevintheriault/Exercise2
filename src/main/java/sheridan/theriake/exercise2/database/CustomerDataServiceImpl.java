package sheridan.theriake.exercise2.database;

import org.springframework.stereotype.Service;
import sheridan.theriake.exercise2.domain.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {

    private final CustomerRepository customerRepository;

    public CustomerDataServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private static void createCustomerObj(CustomerEntity customerEnt, Customer customer){
        customer.setCustomerId(customerEnt.getCustomerId().toString());
        customer.setFirstName(customerEnt.getFirstName());
        customer.setLastName(customerEnt.getLastName());
        customer.setEmail(customerEnt.getEmail());
        customer.setStreet(customerEnt.getStreet());
        customer.setCity(customerEnt.getCity());
        customer.setState(customerEnt.getState());
        customer.setZipCode(customerEnt.getZipCode());
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<CustomerEntity> entities = customerRepository.findAll();
        List<Customer> customers = new ArrayList<Customer>();
        for (CustomerEntity entity : entities) {
            customers.add(
                    new Customer(
                            entity.getCustomerId().toString(),
                            entity.getFirstName(),
                            entity.getLastName(),
                            entity.getEmail(),
                            entity.getStreet(),
                            entity.getCity(),
                            entity.getState(),
                            entity.getZipCode()
                    )
            );
        }
        return customers;
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        Optional<CustomerEntity> result = customerRepository.findById(customerId);
        if(result.isPresent()){
            Customer customerDetails = new Customer();
            CustomerEntity customerEntity = result.get();
            createCustomerObj(customerEntity, customerDetails);
            return customerDetails;
        }
        return null;
    }
}
