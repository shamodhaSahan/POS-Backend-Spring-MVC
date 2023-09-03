package lk.ijse.pos.api;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/2/2023
 * Time : 11:35 PM
 */

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(params = "id")
    public ResponseEntity<CustomerDTO> searchCustomerById(String id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteCustomer(String id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(id+" Customer Deleted..!", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.deleteCustomerById(customerDTO.getId());
        return new ResponseEntity<>(customerDTO.getId()+" Customer Deleted..!", HttpStatus.OK);
    }
}
