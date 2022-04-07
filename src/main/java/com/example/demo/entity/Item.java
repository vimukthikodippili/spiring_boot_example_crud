package com.example.demo.entity;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {
    @Id
    //@Column(name = "Item_code", length = 45)
    private String ItemCode;
   // @Column(name = "Item_description", length = 45)
    private String  Description;
    //@Column(name = "Item_packsize", length = 45)
    private String PackSize;
   // @Column(name = "Item_qtyonhand", length = 45)
    private Integer  QtyOnHand;
    //@Column(name = "Item_unitprice", length = 45)
    private Double  UnitPrice;
}
