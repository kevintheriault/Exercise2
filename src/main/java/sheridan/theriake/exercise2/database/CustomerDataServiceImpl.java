package sheridan.theriake.exercise2.database;

import org.springframework.stereotype.Service;
import sheridan.theriake.exercise2.domain.Customer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDataServiceImpl implements CustomerDataService{

    private final CustomerRepository customerRepository;

    public CustomerDataServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers(){

        List<CustomerEntity> entities = customerRepository.findAll();
        List<Customer> customers = new ArrayList<Customer>();
        for(CustomerEntity entity: entities){
            customers.add(
                    new Customer(
                            entity.toString(),
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
    }
