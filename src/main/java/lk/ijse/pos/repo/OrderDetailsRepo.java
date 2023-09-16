package lk.ijse.pos.repo;

import lk.ijse.pos.entity.OrderDetails;
import lk.ijse.pos.entity.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/3/2023
 * Time : 11:38 PM
 */

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, OrderItemPK> {
    List<OrderDetails> findAllByItemCode(String itemCode);
}
