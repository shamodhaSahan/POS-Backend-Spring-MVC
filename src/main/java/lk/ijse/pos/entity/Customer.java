package lk.ijse.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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
@ToString
@Entity
public class Customer {
    @Id
    private String id;
    @Column(nullable = false)
    private String nic;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal salary;
    @Column(nullable = false)
    private String address;
}
