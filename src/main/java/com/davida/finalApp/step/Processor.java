package com.davida.finalApp.step;

import com.davida.finalApp.model.SignRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;
import java.util.Random;

public class Processor implements ItemProcessor<SignRequest, SignRequest> {

	private static final Logger log = LoggerFactory.getLogger(Processor.class);

	@Override
	public SignRequest process(SignRequest signRequest) throws Exception {
		Random r = new Random();
		
		final String launchDate = signRequest.getLaunchDate();//.toUpperCase();
		final String program = signRequest.getProgram();//.toUpperCase();
		final String department = signRequest.getDepartment();//.toUpperCase();
		final String deliverable = signRequest.getDeliverable();//.toUpperCase();
		final String copy = signRequest.getCopy();//.toUpperCase();
		final String editDeliverable = signRequest.getEditDeliverable();//.toUpperCase();
		final String editCopy = signRequest.getEditCopy();
		final boolean flaggedDeleted = signRequest.isFlaggedDeleted();
		final String username = signRequest.getUsername();
		final LocalDateTime editDateTime = signRequest.getEditDateTime();//.toUpperCase();

		final SignRequest fixedSignRequest = new SignRequest(r.nextLong(), launchDate, program, department, deliverable, copy, editDeliverable, editCopy, flaggedDeleted, username, editDateTime);

		log.info("Converting (" + signRequest + ") into (" + fixedSignRequest + ")");

		return fixedSignRequest;
	}
}
