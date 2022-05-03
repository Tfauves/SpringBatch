package com.batch.breedDataProcess.repositories;

import com.batch.breedDataProcess.domain.BreedData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedDataRepository extends JpaRepository<BreedData, Long> {
}
