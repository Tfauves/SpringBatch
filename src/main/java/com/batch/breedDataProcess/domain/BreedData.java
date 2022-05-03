package com.batch.breedDataProcess.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "breed_data")
@Getter
@Setter
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BreedData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "breed_name")
    private String breed_name;

    @Column(name = "description_link")
    private String description_link;

    @Column(name = "dog_size")
    private String dog_size;

    @Column(name = "breed_group")
    private String breed_group;

    @Column(name = "height")
    private String height;

    @Column(name = "avg_height_cm")
    private String avg_height_cm;

    @Column(name = "weight")
    private String weight;

    @Column(name = "avg_weight_kg")
    private String avg_weight_kg;

    @Column(name = "life_span")
    private String life_span;

    @Column(name = "avg_life_span_years")
    private String avg_life_span_years;

    @Column(name = "adaptability")
    private String adaptability;

    @Column(name = "adapts_well_to_apartment_living")
    private String adapts_well_to_apartment_living;

    @Column(name = "good_for_novice_owners")
    private String good_for_novice_owners ;

    @Column(name = "sensitivity_lvl")
    private String sensitivity_lvl;

    @Column(name = "tolerates_alone")
    private String tolerates_alone;

    @Column(name = "tolerates_cold")
    private String tolerates_cold;

    @Column(name = "tolerates_heat")
    private String tolerates_heat;

    @Column(name = "friendliness")
    private String friendliness;

    @Column(name = "affection_with_family")
    private String affection_with_fam;

    @Column(name = "kid_friendly")
    private String kid_friendly;

    @Column(name = "dog_friendly")
    private String dog_friendly;

    @Column(name = "friendly_to_strangers")
    private String friendly_to_strangers;

    @Column(name = "health_grooming_needs")
    private String health_grooming_needs;

    @Column(name = "shedding")
    private String shedding;

    @Column(name = "drooling_potential")
    private String drooling_potential;

    @Column(name = "ease_of_grooming")
    private String ease_of_grooming;

    @Column(name = "general_health")
    private String general_health;

    @Column(name = "potential_for_weight_gain")
    private String potential_for_weight_gain;

    @Column(name = "size")
    private String size;

    @Column(name = "trainability")
    private String trainability;

    @Column(name = "ease_of_training")
    private String ease_of_training;

    @Column(name = "intelligence")
    private String intelligence;

    @Column(name = "use_of_mouth")
    private String use_of_mouth;

    @Column(name = "prey_drive")
    private String prey_drive;

    @Column(name = "barkiness")
    private String barkiness;

    @Column(name = "wanderlust")
    private String wanderlust;

    @Column(name = "physical_needs")
    private String physical_needs;

    @Column(name = "energy_lvl")
    private String energy_lvl;

    @Column(name = "intensity")
    private String intensity;

    @Column(name = "exercise_needs")
    private String exercise_needs;

    @Column(name = "playfulness")
    private String playfulness;

    public BreedData() {};

    public BreedData(String breed_name, String dog_size, String breed_group, String avg_height_cm, String avg_weight_kg, String avg_life_span_years, String shedding, String intelligence, String prey_drive, String energy_lvl, String exercise_needs) {
    }

    public BreedData(Long id, String breedName, String dog_size, String breedGroup, String avg_height_cm, String avg_weight_kg, String avg_life_span_years, String shedding, String intelligence, String prey_drive, String energy_lvl, String exercise_needs) {
    }
}
