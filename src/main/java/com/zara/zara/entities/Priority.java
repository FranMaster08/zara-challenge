package com.zara.zara.entities;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PRIORITY")
public class Priority {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
}
