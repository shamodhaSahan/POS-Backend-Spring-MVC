package lk.ijse.pos.service;

import lk.ijse.pos.dto.CustomerDTO;

import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/7/2023
 * Time : 11:10 PM
 */

public interface CustomerService {
    CustomerDTO getCustomerById(String id);

    List<CustomerDTO> getAllCustomer();

    void addCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);

    void deleteCustomerById(String id);
}
