package com.batch.breedDataProcess.processor;

import com.batch.breedDataProcess.domain.BreedData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BreedDataProcessor implements ItemProcessor<BreedData, BreedData> {

    private static final Logger logger = LoggerFactory.getLogger(BreedDataProcessor.class);

    @Override
    public BreedData process(BreedData item) throws Exception {
        final Long id = item.getId();
        final String breedName = item.getBreed_name().toUpperCase();
        final String dog_size = item.getDog_size();
        final String breedGroup = item.getBreed_group().toUpperCase();
        final String avg_height_cm = item.getAvg_height_cm();
        final String avg_weight_kg = item.getAvg_weight_kg();
        final String avg_life_span_years = item.getAvg_life_span_years();
        final String shedding = item.getShedding();
        final String intelligence = item.getIntelligence();
        final String prey_drive = item.getPrey_drive();
        final String energy_lvl = item.getEnergy_lvl();
        final String exercise_needs = item.getExercise_needs();

        final BreedData transformedData = new BreedData(id, breedName, dog_size, breedGroup, avg_height_cm, avg_weight_kg, avg_life_span_years, shedding, intelligence, prey_drive, energy_lvl, exercise_needs );
        logger.info("Converting (" + item + ") into (" + transformedData + ")");

        return transformedData;
    }
}
