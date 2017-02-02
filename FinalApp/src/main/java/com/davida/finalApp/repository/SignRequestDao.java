package com.davida.finalApp.repository;


import com.davida.finalApp.model.SignRequest;

import java.util.List;

public interface SignRequestDao {
	public void insert(List<? extends SignRequest> signRequests);
	List<SignRequest> loadAllSignRequests();
}
