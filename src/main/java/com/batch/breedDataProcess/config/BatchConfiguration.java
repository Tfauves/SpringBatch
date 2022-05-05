package com.batch.breedDataProcess.config;


import com.batch.breedDataProcess.domain.BreedData;
import com.batch.breedDataProcess.processor.BreedDataProcessor;
import com.batch.breedDataProcess.repositories.BreedDataRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration // Informs Spring that this class contains configurations
@EnableBatchProcessing // Enables batch processing for the application
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    @Lazy
    public BreedDataRepository breedDataRepository;

    @Autowired
    DataSource dataSource;

    // Reads the data.csv file and creates instances of entity for each from the .csv file.
    @Bean
    public FlatFileItemReader<BreedData> reader() {
        return new FlatFileItemReaderBuilder<BreedData>()
                .name("btcDataFileReader")
                .resource(new ClassPathResource("/data/breedData.csv"))
                .delimited()
                .names(new String[]{"breed_name", "description_link", "dog_size", "breed_group", "height", "avg_height_cm", "weight", "avg_weight_kg", "life_span",
                        "avg_life_span_years", "adaptability", "adapts_well_to_apartment_living", "good_for_novice_owners", "sensitivity_lvl", "tolerates_alone",
                        "tolerates_cold", "tolerates_heat", "friendliness", "affection_with_family", "kid_friendly", "dog_friendly", "friendly_to_strangers",
                        "health_grooming_needs", "shedding", "drooling_potential", "ease_of_grooming", "general_health", "potential_for_weight_gain", "size", "trainability",
                        "ease_of_training", "intelligence", "use_of_mouth", "prey_drive", "barkiness", "wanderlust", "physical_needs", "energy_lvl", "intensity", "exercise_needs", "playfulness"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(BreedData.class);
                }})
                .build();
    }


    // Creates the Writer, configuring the repository and the method that will be used to save the data into the database
    @Bean
    public RepositoryItemWriter<BreedData> writer() {
        RepositoryItemWriter<BreedData> iwriter = new RepositoryItemWriter<>();
        JdbcBatchItemWriter<BreedData> itemWriter = new JdbcBatchItemWriter<>();
        iwriter.setRepository(breedDataRepository);
        itemWriter.setSql("INSERT INTO breed_data  VALUES (:id :breed_name, :description_link :dog_size, :breed_group, :height, :avg_height_cm, :weight, :avg_weight_kg, :life_span, :avg_life_span_years, :adaptability, :adapts_well_to_apartment_living, :good_for_novice_owners, :sensitivity_lvl, :tolerates_alone, :tolerates_cold, :tolerates_heat, :friendliness, :affection_with_family, :kid_friendly, :dog_friendly, :friendly_to_strangers, :health_grooming_needs, :shedding, :drooling_potential, :ease_of_grooming, :general_health, :potential_for_weight_gain, :size, :trainability, :ease_of_training, :intelligence, :use_of_mouth, :prey_drive, :barkiness, :wanderlust, :physical_needs, :energy_lvl, :intensity, :exercise_needs, :playfulness )");

        iwriter.setMethodName("save");
        return iwriter;
    }


    // Creates an instance of DataProcessor that converts one data form to another. In our case the data form is maintained.
    @Bean
    public BreedDataProcessor processor() {
        return new BreedDataProcessor();
    }

    // Batch jobs are built from steps. A step contains the reader, processor and the writer.
    @Bean
    public Step step1(ItemReader<BreedData> itemReader, ItemWriter<BreedData> itemWriter)
            throws Exception {

        return this.stepBuilderFactory.get("step1")
                .<BreedData, BreedData>chunk(5)
                .reader(itemReader)
                .processor(processor())
                .writer(itemWriter)
                .build();
    }

    // Executes the job, saving the data from .csv file into the database.
    @Bean
    public Job BreedDataJob(JobCompletionListener listener, Step step1)
            throws Exception {

        return this.jobBuilderFactory.get("process job").incrementer(new RunIdIncrementer())
                .listener(listener).start(step1).build();
    }
}
