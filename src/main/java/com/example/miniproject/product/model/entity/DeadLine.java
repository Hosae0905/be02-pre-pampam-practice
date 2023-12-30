package com.example.miniproject.product.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class DeadLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deadLineId;

    private Date deadLine;
}
