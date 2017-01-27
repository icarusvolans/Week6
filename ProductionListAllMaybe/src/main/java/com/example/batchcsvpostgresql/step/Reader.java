package com.example.batchcsvpostgresql.step;

import com.example.batchcsvpostgresql.model.SignRequest;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

public class Reader {
	public static FlatFileItemReader<SignRequest> reader(String path) {
		FlatFileItemReader<SignRequest> reader = new FlatFileItemReader<SignRequest>();

		reader.setResource(new ClassPathResource(path));
		reader.setLineMapper(new DefaultLineMapper<SignRequest>() {
			{
				System.out.println(reader.toString());
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] {"localDate", "program", "department", "deliverable", "copy" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<SignRequest>() {
					{
						setTargetType(SignRequest.class);
					}
				});
			}
		});
		return reader;
	}
}
