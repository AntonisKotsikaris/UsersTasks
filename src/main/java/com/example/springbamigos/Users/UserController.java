package com.example.springbamigos.Users;

import com.example.springbamigos.Task.RandomStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping (path = "/User")

public class UserController {

    @Autowired
    private RepositUsr UsrRepository;

    @GetMapping("/{id}")
    public @ResponseBody User getUser(@PathVariable Long id) {
        return UsrRepository.getById(id);
    }

    @PostMapping ( path  = "/addUser")
    public @ResponseBody String addNewUser (@RequestBody User user) {
        UsrRepository.save(user);

        return "saved Users";
    }


    @DeleteMapping (path  = "/delete")
    public @ResponseBody String deleteUser ( @RequestBody User user ) {
        UsrRepository.delete(user);
        return "deleted";
    }

    @GetMapping (path = "/allusers")
    public @ResponseBody Page<User> getAllUsers(){
        Pageable page = PageRequest.of(0, 6);
        Page<User> allProducts = UsrRepository.findAll(page);

        return allProducts;
                //UsrRepository.findAll(page);

    }

}
