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
        final String breed_name = item.getBreed_name().toUpperCase();
        final String description_link = item.getDescription_link();
        final String dog_size = item.getDog_size();
        final String breed_group = item.getBreed_group().toUpperCase();
        final String height = item.getHeight();
        final String avg_height_cm = item.getAvg_height_cm();
        final String weight = item.getWeight();
        final String avg_weight_kg = item.getAvg_weight_kg();
        final String life_span = item.getLife_span();
        final String avg_life_span_years = item.getAvg_life_span_years();
        final String adaptability = item.getAdaptability();
        final String adapts_well_to_apartment_living = item.getAdapts_well_to_apartment_living();
        final String good_for_novice_owners = item.getGood_for_novice_owners();
        final String sensitivity_lvl = item.getSensitivity_lvl();
        final String tolerates_alone = item.getTolerates_alone();
        final String tolerates_cold = item.getTolerates_cold();
        final String tolerates_heat = item.getTolerates_heat();
        final String friendliness = item.getFriendliness();
        final String affection_with_family = item.getAffection_with_fam();
        final String kid_friendly = item.getKid_friendly();
        final String dog_friendly = item.getDog_friendly();
        final String friendly_to_strangers = item.getFriendly_to_strangers();
        final String health_grooming_needs = item.getHealth_grooming_needs();
        final String shedding = item.getShedding();
        final String drooling_potential = item.getDrooling_potential();
        final String ease_of_grooming = item.getEase_of_grooming();
        final String general_health = item.getGeneral_health();
        final String potential_for_weight_gain = item.getPotential_for_weight_gain();
        final String size = item.getSize();
        final String trainability = item.getTrainability();
        final String ease_of_training = item.getEase_of_training();
        final String intelligence = item.getIntelligence();
        final String use_of_mouth = item.getUse_of_mouth();
        final String prey_drive = item.getPrey_drive();
        final String barkiness = item.getBarkiness();
        final String wanderlust = item.getWanderlust();
        final String physical_needs = item.getPhysical_needs();
        final String energy_lvl = item.getEnergy_lvl();
        final String intensity = item.getIntensity();
        final String exercise_needs = item.getExercise_needs();
        final String playfulness = item.getPlayfulness();

        final BreedData transformedData = new BreedData(id, breed_name, description_link, dog_size, breed_group, height, avg_height_cm,
                weight, avg_weight_kg, life_span, avg_life_span_years, adaptability, adapts_well_to_apartment_living, good_for_novice_owners,
                sensitivity_lvl, tolerates_alone, tolerates_cold, tolerates_heat, friendliness, affection_with_family, kid_friendly, dog_friendly,
                friendly_to_strangers, health_grooming_needs, shedding, drooling_potential, ease_of_grooming, general_health, potential_for_weight_gain,
                size, trainability, ease_of_training, intelligence, use_of_mouth, prey_drive, barkiness, wanderlust, physical_needs, energy_lvl, intensity, exercise_needs, playfulness
        );
        logger.info("Converting (" + item + ") into (" + transformedData + ")");

        return transformedData;
    }
}
