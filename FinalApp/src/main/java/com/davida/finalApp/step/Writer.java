package com.davida.finalApp.step;


import com.davida.finalApp.model.SignRequest;
import com.davida.finalApp.repository.SignRequestDao;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

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
