package com.quick.rest;

import com.quick.entity.Account;
import com.quick.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json",
                 produces = "application/json")
    public Account create(@RequestBody Account account) {
        return userService.create(account);
    }

    @GetMapping(produces = "application/json")
    public List<Account> findAll() {
        return userService.findAll();
    }

    @PostMapping("/{userId}/tariff/{tariffId}")
    public Account create(@PathVariable("userId") int userId,
                          @PathVariable("tariffId") int tariffId) {
        return userService.addTariffToUser(userId, tariffId);
    }
}
