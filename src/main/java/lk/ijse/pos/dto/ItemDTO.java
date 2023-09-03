package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class ItemDTO {
    private String itemCode;
    private String description;
    private int qtyOnHand;
    private BigDecimal unitPrice;
    private List<OrderDetailsDTO> orderDetailsList;
}
