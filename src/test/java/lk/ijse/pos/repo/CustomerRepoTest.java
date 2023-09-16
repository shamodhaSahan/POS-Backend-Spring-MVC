package lk.ijse.pos.repo;

import lk.ijse.pos.config.WebRootConfig;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.entity.OrderDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerRepoTest {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ItemRepo itemRepo;

    @Test
    public void test(){
//        Customer customer = new Customer("C005","","",new BigDecimal(50000),"",null);
//        customerRepo.save(customer);
//        List<Customer> all = (List<Customer>) customerRepo.findAll();
//        System.out.println(all.get(0));
        Customer customer = customerRepo.findById("C002").get();
        System.out.println(customer);
//        System.out.println(customer);
//        Order order = new Order("O001", LocalDate.now(),customer,null);
//        orderRepo.save(order);
//        List<Order> orderList = customer.getOrderList();
//        Order order = orderList.get(0);
////        System.out.println(order);
//
//        List<OrderDetails> orderDetails = order.getOrderDetails();
//        OrderDetails orderDetail = orderDetails.get(0);
////        System.out.println(orderDetails1);
//
//        System.out.println(orderDetail.getItem());
//        List<Order> orderList = customer.getOrderList();
//        for (Order order:orderList){
//            List<OrderDetails> orderDetails = order.getOrderDetails();
//            orderDetails.forEach(orderDetails::remove);
//        }
//        System.out.println(customer);

        customerRepo.delete(customer);
    }
}