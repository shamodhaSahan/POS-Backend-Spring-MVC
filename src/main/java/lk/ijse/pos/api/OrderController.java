package lk.ijse.pos.api;

import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.service.PlaceOrderService;
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
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    PlaceOrderService placeOrderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        return new ResponseEntity<>(placeOrderService.getAllOrder(), HttpStatus.OK);
    }

    @GetMapping("/newOrderId")
    public String getNewOrderId(){
        return placeOrderService.getNewOrderId();
    }

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO){
        placeOrderService.addOrder(orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO){
        placeOrderService.updateOrder(orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @DeleteMapping(params = "orderId")
    public ResponseEntity<String> deleteOrder(String orderId){
        placeOrderService.deleteOrderByOrderId(orderId);
        return new ResponseEntity<>(orderId+" Customer Deleted..!", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrder(@RequestBody OrderDTO orderDTO){
        placeOrderService.deleteOrderByOrderId(orderDTO.getOrderId());
        return new ResponseEntity<>(orderDTO.getOrderId()+" Customer Deleted..!", HttpStatus.OK);
    }
}
