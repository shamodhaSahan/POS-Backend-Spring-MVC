package lk.ijse.pos.service;

import lk.ijse.pos.dto.OrderDTO;

import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/7/2023
 * Time : 11:10 PM
 */

public interface PlaceOrderService {
    List<OrderDTO> getAllOrder();

    void addOrder(OrderDTO orderDTO);

    void updateOrder(OrderDTO orderDTO);

    void deleteOrderByOrderId(String orderId);

    String getNewOrderId();
}
