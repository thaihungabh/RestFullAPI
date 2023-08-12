package edu.iviettech.asgrestfulapi.repository;

import edu.iviettech.asgrestfulapi.entity.TransactionLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionLogRepository extends JpaRepository<TransactionLogEntity,Long> {
}
