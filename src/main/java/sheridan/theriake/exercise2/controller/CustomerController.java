package sheridan.theriake.exercise2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sheridan.theriake.exercise2.database.CustomerDataService;

@Controller
public class CustomerController {

    private final CustomerDataService customerDataService;

    public CustomerController(CustomerDataService customerDataService){
        this.customerDataService = customerDataService;
    }

    @GetMapping(value = {"/","/CustomerList"})
    public ModelAndView customerList(){
        return new ModelAndView(
                "CustomerList",
                "customers",
                customerDataService.getAllCustomers());
    }
}
