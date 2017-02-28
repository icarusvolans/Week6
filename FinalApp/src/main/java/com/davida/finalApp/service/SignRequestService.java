package com.davida.finalApp.service;


import com.davida.finalApp.model.SignRequest;


public interface SignRequestService {
    void save(SignRequest signRequest);

    SignRequest findById(long id);
}