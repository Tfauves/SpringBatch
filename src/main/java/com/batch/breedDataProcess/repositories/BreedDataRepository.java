package com.batch.breedDataProcess.repositories;

import com.batch.breedDataProcess.domain.BreedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BreedDataRepository extends JpaRepository<BreedData, Long> {



//    List<BreedData> findAllBy_id(Long id);

    @Query(value = "SELECT * FROM breed_data WHERE breed_name LIKE ?%", nativeQuery = true)
    List<BreedData> findAllByBreed_name(String breedName);

}
