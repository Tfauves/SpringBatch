package com.batch.breedDataProcess.repositories;

import com.batch.breedDataProcess.domain.BtcData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BtcDataRepository extends JpaRepository<BtcData, Long> {
}
