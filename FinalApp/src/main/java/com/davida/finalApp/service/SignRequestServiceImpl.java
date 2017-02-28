package com.davida.finalApp.service;

import com.davida.finalApp.model.SignRequest;
import com.davida.finalApp.model.User;
import com.davida.finalApp.repository.DepartmentRepository;
import com.davida.finalApp.repository.RoleRepository;
import com.davida.finalApp.repository.SignRequestDao;
import com.davida.finalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;


@Service
public class SignRequestServiceImpl implements SignRequestService {
    @Autowired
    private SignRequestDao signRequestDao;


    @Override
    public void save(SignRequest signRequest) {
        signRequestDao.save(signRequest);
    }

    @Override
    public SignRequest findById(long id) {
        return null;
    }
/*
    @Override
    public SignRequest findById(long id) {
        return signRequestDao.findById(Id);
    }*/
}
