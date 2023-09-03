package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailsDTO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.repo.ItemRepo;
import lk.ijse.pos.repo.OrderDetailsRepo;
import lk.ijse.pos.repo.OrderRepo;
import lk.ijse.pos.service.PlaceOrderService;
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
public class PlaceOrderServiceImpl implements PlaceOrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrderDTO> getAllOrder() {
        return modelMapper.map(orderRepo.findAll(), new TypeToken<List<OrderDTO>>(){}.getType());
    }

    @Override
    public void addOrder(OrderDTO orderDTO) {
        if (orderRepo.existsById(orderDTO.getOrderId()))
            throw new RuntimeException("Order Id : "+orderDTO.getOrderId()+" Already exists..!");
        orderRepo.save(modelMapper.map(orderDTO, Order.class));
        for (OrderDetailsDTO orderDetailsDTO: orderDTO.getOrderDetailsList()){
            Optional<Item> optionalItem = itemRepo.findById(orderDetailsDTO.getItemCode());
            if (optionalItem.isPresent()){
                Item item = optionalItem.get();
                item.setQtyOnHand(item.getQtyOnHand()-orderDetailsDTO.getQty());
                itemRepo.save(item);
            }
        }
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
        if (!orderRepo.existsById(orderDTO.getOrderId()))
            throw new RuntimeException("Order Id : "+orderDTO.getOrderId()+" Order not found..!");
        orderRepo.save(modelMapper.map(orderDTO, Order.class));
    }

    @Override
    public void deleteOrderByOrderId(String orderId) {
        if (!orderRepo.existsById(orderId))
            throw new RuntimeException("Order Id : "+orderId+" Order not found..!");
        orderRepo.deleteById(orderId);
    }

    @Override
    public String getNewOrderId() {
        Order order = orderRepo.findTopByOrderByOrderIdDesc();
        if (order != null) {
            String orderId = order.getOrderId();
            return String.format("O%03d", (Integer.parseInt(orderId.substring(1)) + 1));
        }
        return "O001";
    }
}
