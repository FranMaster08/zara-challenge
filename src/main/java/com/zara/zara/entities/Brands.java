package com.zara.zara.entities;
import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;



@Data
@Entity
@Table(name = "brands")
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
