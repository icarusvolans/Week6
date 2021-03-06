package com.davida.finalApp.step;


import com.davida.finalApp.model.SignRequest;
import com.davida.finalApp.repository.SignRequestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import java.util.List;

public class Listener extends JobExecutionListenerSupport {
	private static final Logger log = LoggerFactory.getLogger(Listener.class);

	private final SignRequestDao signRequestDao;

	public Listener(SignRequestDao signRequestDao) {
		this.signRequestDao = signRequestDao;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("Finish Job! Check the results");

			List<SignRequest> signRequests = signRequestDao.loadAllSignRequests();

			for (SignRequest signRequest : signRequests) {
				log.info("Found <" + signRequest + "> in the database.");
			}
		}
	}
}
