package com.example.demo.data.repository;

import com.example.demo.data.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<DataEntity,Long> { // Long là kiểu dữ liệu của khoá chính
    List<DataEntity> findByIdPhone(@Param("idPhone") String idPhone);

    List<DataEntity> findByUrl(String url);

    @Query("SELECT e FROM DataEntity e WHERE e.date <= :cutoffTime")
    List<DataEntity> findOlderThan(@Param("cutoffTime") LocalDateTime cutoffTime);

    DataEntity findDataEntitiesByUrl(String url);
}

