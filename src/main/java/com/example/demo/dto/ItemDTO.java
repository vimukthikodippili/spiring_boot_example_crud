package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private String ItemCode;
    private String  Description;
    private String PackSize;
    private Integer  QtyOnHand;
    private Double  UnitPrice;
}
