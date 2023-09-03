package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.repo.CustomerRepo;
import lk.ijse.pos.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/7/2023
 * Time : 11:10 PM
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO getCustomerById(String id) {
        Optional<Customer> byId = customerRepo.findById(id);
        if (byId.isEmpty())
            throw new RuntimeException("Id : "+id+" Customer not found..!");
        return modelMapper.map(byId.get(), CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAllCustomer(){
        return modelMapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public void addCustomer(CustomerDTO customerDTO){
        if (customerRepo.existsById(customerDTO.getId()) || customerRepo.existsCustomerByNic(customerDTO.getNic()))
            throw new RuntimeException("Id : "+customerDTO.getId()+" or Nic : "+customerDTO.getNic()+" Customer Already exists..!");
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO){
        if (!customerRepo.existsById(customerDTO.getId()))
            throw new RuntimeException("Id : "+customerDTO.getId()+" Customer not found..!");
        if (customerRepo.existsCustomerByNic(customerDTO.getNic()) &&
                !customerRepo.findCustomerByNic(customerDTO.getNic()).getId().equals(customerDTO.getId()))
            throw new RuntimeException("Nic : "+customerDTO.getNic()+" Already exists..!");
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public void deleteCustomerById(String id){
        if (!customerRepo.existsById(id))
            throw new RuntimeException("Id : "+id+" Customer not found..!");
        customerRepo.deleteById(id);
    }
}
