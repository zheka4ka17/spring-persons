package org.vitstep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.vitstep.models.User;
import org.vitstep.repo.UserRepo;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
@Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAll(){
    return userRepo.findAll();
    }
    public Page<User> findAll(Pageable pageable) {
        return (Page<User>) userRepo.findAll(pageable);
    }
    public List<User> sort(){
     return userRepo.findAll(Sort.by("name"));
    }
}
