package com.example.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{name}")
    public String username(@PathVariable String name){
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return "Hello %s!".formatted(name);
    }

    @GetMapping("/find-all")
    public String findAll(){
        List<User> all = userRepository.findAll();
        StringBuffer stringBuffer = new StringBuffer();
        for (User user : all) {
            stringBuffer.append(user + "  ");
        }
        return stringBuffer.toString();
    }
}
