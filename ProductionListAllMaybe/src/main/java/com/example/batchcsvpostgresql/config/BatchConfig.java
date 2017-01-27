package com.example.batchcsvpostgresql.config;

import com.example.batchcsvpostgresql.model.SignRequest;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.batchcsvpostgresql.dao.SignRequestDao;
import com.example.batchcsvpostgresql.step.Listener;
import com.example.batchcsvpostgresql.step.Processor;
import com.example.batchcsvpostgresql.step.Reader;
import com.example.batchcsvpostgresql.step.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public SignRequestDao signRequestDao;

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(signRequestDao))
				.flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<SignRequest, SignRequest>chunk(2)
				.reader(Reader.reader("january_2017_production_list.csv"))
				.processor(new Processor()).writer(new Writer(signRequestDao)).build();
	}
}
