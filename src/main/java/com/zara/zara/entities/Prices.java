package com.zara.zara.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_list_id")
    private Long priceListId;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brands brand;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @Column(name = "price")
    private Double price;

    @Column(name = "curr")
    private String curr;


}
