package com.example.batchcsvpostgresql.dao;

import java.util.List;

import com.example.batchcsvpostgresql.model.SignRequest;

public interface SignRequestDao {
	public void insert(List<? extends SignRequest> signRequests);
	List<SignRequest> loadAllSignRequests();
}
