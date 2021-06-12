package sheridan.theriake.exercise2.database;

import sheridan.theriake.exercise2.domain.Customer;

import java.util.List;

public interface CustomerDataService {
    List<Customer> getAllCustomers();

    Customer getCustomer(Integer customerId);
}
