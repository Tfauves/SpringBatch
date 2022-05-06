package com.batch.breedDataProcess.config;

import com.batch.breedDataProcess.domain.BreedData;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class BreedFieldSetMapper implements FieldSetMapper<BreedData> {

    @Override
    public BreedData mapFieldSet(FieldSet fieldSet) throws BindException {
        return new BreedData(fieldSet.readLong("id"),
                fieldSet.readString("breed_name"),
                fieldSet.readString("description_link"),
                fieldSet.readString("dog_size"),
                fieldSet.readString("breed_group"),
                fieldSet.readString("height"),
                fieldSet.readString("avg_height_cm"),
                fieldSet.readString("weight"),
                fieldSet.readString("avg_weight_kg"),
                fieldSet.readString("life_span"),
                fieldSet.readString("avg_life_span_years"),
                fieldSet.readString("adaptability"),
                fieldSet.readString("adapts_well_to_apartment_living"),
                fieldSet.readString("good_for_novice_owners"),
                fieldSet.readString("sensitivity_lvl"),
                fieldSet.readString("tolerates_alone"),
                fieldSet.readString("tolerates_cold"),
                fieldSet.readString("tolerates_heat"),
                fieldSet.readString("friendliness"),
                fieldSet.readString("affection_with_family"),
                fieldSet.readString("kid_friendly"),
                fieldSet.readString("dog_friendly"),
                fieldSet.readString("friendly_to_strangers"),
                fieldSet.readString("health_grooming_needs"),
                fieldSet.readString("shedding"),
                fieldSet.readString("drooling_potential"),
                fieldSet.readString("ease_of_grooming"),
                fieldSet.readString("general_health"),
                fieldSet.readString("potential_for_weight_gain"),
                fieldSet.readString("size"),
                fieldSet.readString("trainability"),
                fieldSet.readString("ease_of_training"),
                fieldSet.readString("intelligence"),
                fieldSet.readString("use_of_mouth"),
                fieldSet.readString("prey_drive"),
                fieldSet.readString("barkiness"),
                fieldSet.readString("wanderlust"),
                fieldSet.readString("physical_needs"),
                fieldSet.readString("energy_lvl"),
                fieldSet.readString("intensity"),
                fieldSet.readString("exercise_needs"),
                fieldSet.readString("playfulness")
                );
    }
}
