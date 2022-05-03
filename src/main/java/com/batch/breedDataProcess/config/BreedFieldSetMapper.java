package com.batch.breedDataProcess.config;

import com.batch.breedDataProcess.domain.BreedData;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class BreedFieldSetMapper implements FieldSetMapper<BreedData> {

    @Override
    public BreedData mapFieldSet(FieldSet fieldSet) throws BindException {
        return new BreedData(fieldSet.readString("breed_name"),
                fieldSet.readString("dog_size"),
                fieldSet.readString("breed_group"),
                fieldSet.readString("avg_height_cm"),
                fieldSet.readString("avg_weight_kg"),
                fieldSet.readString("avg_life_span_years"),
                fieldSet.readString("shedding"),
                fieldSet.readString("intelligence"),
                fieldSet.readString("prey_drive"),
                fieldSet.readString("energy_lvl"),
                fieldSet.readString("exercise_needs")

                );
    }
}
