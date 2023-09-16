package lk.ijse.pos.repo;

import lk.ijse.pos.config.WebRootConfig;
import lk.ijse.pos.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class ItemRepoTest {
    @Autowired
    ItemRepo itemRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @Test
    public void test(){
        Optional<Item> byId = itemRepo.findById("I001");
        Item item = byId.get();
        orderDetailsRepo.findAllByItemCode(item.getItemCode()).forEach(orderDetails -> orderRepo.delete(orderDetails.getOrder()));

        itemRepo.delete(item);
    }
}