package com.example.demo.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Data")
@Data // tự động thêm getter,setter
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idData")
    Long idData;
    @Column(name = "filePath")
    String filePath;
    @ManyToOne
    @JoinColumn(name = "idLink")
    private LinkEntity linkEntity;


}
