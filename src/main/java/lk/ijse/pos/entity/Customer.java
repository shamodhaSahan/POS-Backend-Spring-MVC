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
 * Date : 8/2/2023
 * Time : 11:54 PM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"orderList"})
@Entity
public class Customer {
    @Id
    private String id;
    private String nic;
    private String name;
    private BigDecimal salary;
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderList;
}
