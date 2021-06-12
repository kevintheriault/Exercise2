package sheridan.theriake.exercise2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import sheridan.theriake.exercise2.database.CustomerDataService;
import sheridan.theriake.exercise2.domain.Customer;

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
                customerDataService.getAllCustomers()
        );
    }

    @GetMapping("/CustomerDetails/{customerId}")
    public String customerDetails(@PathVariable String customerId, Model model){
        try {
            Customer details = customerDataService.getCustomer(Integer.parseInt(customerId));
            if (details != null) {
                model.addAttribute("customer", details);
                return "CustomerDetails";
            } else {
                return "DataNotFound";
            }
        } catch (NumberFormatException e) {
            return "DataNotFound";
        }
    }
}
