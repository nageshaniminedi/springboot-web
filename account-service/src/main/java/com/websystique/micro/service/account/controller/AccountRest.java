package com.websystique.micro.service.account.controller;

import com.websystique.micro.service.account.domain.Account;
import com.websystique.micro.service.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("accounts")
public class AccountRest {

    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/ping")
    public String ping() {
        return "Ping";
    }

    @GetMapping(path = "find/all")
    public List<Account> findAll(){
        try {
            List<Account> l = (List<Account>) accountService.findAll();
            return l;
        } catch (Throwable exc) {
            return new ArrayList<Account>();
        }
    }

    @GetMapping(path = "get/{id}")
    public Account get(@PathVariable("id") Long id) {
        return this.accountService.findOne(id);
    }

    @DeleteMapping(path = "remove/{id}")
    public void remove(@PathVariable("id") Long id) {
        this.accountService.delete(id);
    }

    @PutMapping(path = "save")
    @CrossOrigin(origins = "*")
    public void save(@RequestBody Account account) {
        this.accountService.save(account);
    }

}
