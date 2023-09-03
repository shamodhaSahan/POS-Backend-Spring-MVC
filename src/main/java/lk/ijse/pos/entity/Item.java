package lk.ijse.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/3/2023
 * Time : 12:06 AM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"orderDetailsList"})
@Entity
public class Item {
    @Id
    private String itemCode;
    private String description;
    private int qtyOnHand;
    private BigDecimal unitPrice;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetailsList;
}
