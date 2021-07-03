package ru.godsonpeya.springbatchdemo.rest;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.godsonpeya.springbatchdemo.entity.BankTransaction;
import ru.godsonpeya.springbatchdemo.repository.BankTransactionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BankRestController {
    private final JobLauncher jobLauncher;
    private final Job job;

    private final BankTransactionRepository repository;

    @RequestMapping("/loadData")
    public BatchStatus load() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        Map<String, JobParameter> parameters = new HashMap<>();
        parameters.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(parameters);
        JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
        while (jobExecution.isRunning()){
            System.out.println("...something is happening........");
        }
        return jobExecution.getStatus();
    }

    @RequestMapping("/all")
    public ResponseEntity<Double> getAll(){
        long start = System.currentTimeMillis();
        List<BankTransaction> all = repository.findAll();
        return ResponseEntity.ok((double)(System.currentTimeMillis()-start)/1000);
    }
}
