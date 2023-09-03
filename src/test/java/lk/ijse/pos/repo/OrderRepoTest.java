package lk.ijse.pos.repo;

import lk.ijse.pos.config.WebRootConfig;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.entity.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class OrderRepoTest {
    @Autowired
    OrderRepo orderRepo;
    @Test
    public void testing() {
        Order o = orderRepo.findTopByOrderByOrderIdDesc();
        System.out.println(orderRepo.findTopByOrderByOrderIdDesc());
    }
}