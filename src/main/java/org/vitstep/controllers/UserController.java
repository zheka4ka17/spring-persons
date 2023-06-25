package org.vitstep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vitstep.models.User;
import org.vitstep.services.UserService;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users(Model model) {
        return userService.findAll();
    }
    @GetMapping("/users/page")
    public Page<User> findAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return (Page<User>) userService.findAll(pageable);
    }
    @GetMapping(value="/users", params={"page", "size"})
    public Page<User> paginationUsers(@RequestParam("page") int page,
                                      @RequestParam("size") int size) throws IOException {
        Pageable pageable = PageRequest.of(page, size);
        return userService.findAll(pageable);
    }
    @GetMapping("/users/sort")
    public List<User> sort() {
        return userService.sort();
    }
}
