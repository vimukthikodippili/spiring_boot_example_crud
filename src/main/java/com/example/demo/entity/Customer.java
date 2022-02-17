package com.example.demo.entity;

import com.mysql.cj.xdevapi.JsonString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")

public class Customer implements SuperEntity {
    @Id
    @Column(name = "Customer_id", length = 45)
    private String CustomerID;
    @Column(name = "Customer_name", length = 45)
    private String CustomerName;
}
