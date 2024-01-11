package com.example.demo.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "DataEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "url")
    private String url;
    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime date;
    @Column(name = "id_phone")
    private String idPhone;
    @ElementCollection
    @CollectionTable(name = "File", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "file_name")
    private List<String> fileName;
}
