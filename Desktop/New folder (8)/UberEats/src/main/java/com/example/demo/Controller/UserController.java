package com.example.demo.Controller;

import com.example.demo.Model.Response;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    
    private String email;
    private String password;
    
    @Autowired
    UserService userService;
    
    public UserController() {
        
    }
    
    public UserController(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @RequestMapping(value = "/postuser", method = RequestMethod.POST)
    public void postUser(@RequestBody User user) {
        
        userService.postUser(user);
    }
    
    @RequestMapping("/findbyemailandpassword")
    public Response findByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        
        Response response = userService.findByEmailAndPassword(email, password);
        
        return response;
    }
    
    @RequestMapping("/findbystatus")
    public Response findByStatus() {
        
        Response response = userService.findByStatus();
        
        return response;
        
    }
    
    public User updateById(Long id) {
        
        User user = userService.updateById(id);
        
        return user;
    }
    
    @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.POST)
    public void updateUser(@PathVariable Long id) {
        
        userService.updateUser(id);
    }
    
}
