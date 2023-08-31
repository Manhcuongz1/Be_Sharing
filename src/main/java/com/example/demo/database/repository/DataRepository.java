package com.example.demo.database.repository;

import com.example.demo.database.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<DataEntity,Long> { // Long là kiểu dữ liệu của khoá chính

}
