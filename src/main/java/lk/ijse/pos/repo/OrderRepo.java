package lk.ijse.pos.repo;

import lk.ijse.pos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/3/2023
 * Time : 11:38 PM
 */

public interface OrderRepo extends JpaRepository<Order, String> {
    Order  findTopByOrderByOrderIdDesc();
    void deleteByCustomerId(String customerId);
}
