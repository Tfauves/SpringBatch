package com.batch.breedDataProcess.config;


import com.batch.breedDataProcess.repositories.BreedDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionListener extends JobExecutionListenerSupport {
    // Creates an instance of the logger
    private static final Logger log = LoggerFactory.getLogger(JobCompletionListener.class);
    private final BreedDataRepository breedDataRepository;

    @Autowired
    public JobCompletionListener(BreedDataRepository breedDataRepository) {
        this.breedDataRepository = breedDataRepository;
    }

    // The callback method from the Spring Batch JobExecutionListenerSupport class that is executed when the batch process is completed
    @Override
    public void afterJob(JobExecution jobExecution) {
        // When the batch process is completed the data in the database is retrieved and logged on the application logs
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB COMPLETED! verify the results");
           breedDataRepository.findAll()
                    .forEach(btcData -> log.info("Found (" + btcData + ">) in the database.") );
        }
    }
}
