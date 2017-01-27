package com.example.batchcsvpostgresql.step;

import java.util.List;

import com.example.batchcsvpostgresql.model.SignRequest;
import org.springframework.batch.item.ItemWriter;

import com.example.batchcsvpostgresql.dao.SignRequestDao;

public class Writer implements ItemWriter<SignRequest> {

	private final SignRequestDao signRequestDao;

	public Writer(SignRequestDao signRequestDao) {
		this.signRequestDao = signRequestDao;
	}

	@Override
	public void write(List<? extends SignRequest> signRequests) throws Exception {
		signRequestDao.insert(signRequests);
	}

}
