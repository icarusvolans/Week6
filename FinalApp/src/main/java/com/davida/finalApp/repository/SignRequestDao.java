package com.davida.finalApp.repository;


import com.davida.finalApp.model.SignRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SignRequestDao extends CrudRepository<SignRequest, Long>{
	public void insert(List<? extends SignRequest> signRequests);
	public void deleteRequest(List<? extends SignRequest> SignRequests);
	List<SignRequest> loadAllSignRequests();
}
