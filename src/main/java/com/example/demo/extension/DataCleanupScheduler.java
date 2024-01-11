package com.example.demo.extension;

import com.example.demo.data.entity.DataEntity;
import com.example.demo.data.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataCleanupScheduler {
    private static final int CLEAN = 120000;
    @Autowired
    DataRepository dataRepository;

    @Scheduled(fixedRate = CLEAN)
    public void cleanupOldData() {
        LocalDateTime cutoffTime = LocalDateTime.now().minusHours(2);
        List<DataEntity> dataEntityList = dataRepository.findOlderThan(cutoffTime);
        dataRepository.deleteAll(dataEntityList);
    }
}
