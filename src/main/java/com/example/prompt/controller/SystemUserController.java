package com.example.prompt.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.prompt.entity.SystemUser;
import com.example.prompt.service.SystemUserService;
@RestController
@RequestMapping("/api/users")
public class SystemUserController 
{
    @Autowired
    private SystemUserService service;
 
    @PostMapping
    public SystemUser saveUser(@RequestBody SystemUser user) 
    {
        return service.saveUser(user);
    }

   @GetMapping
    public List<SystemUser> getAllUsers() 
    {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public SystemUser getUserById(@PathVariable Long id) 
    {
        return service.getUserById(id);
    }

   @PutMapping("/{id}")
    public SystemUser updateUser(@PathVariable Long id, @RequestBody SystemUser user)
 {
    return service.updateUser(id, user);
    }
   @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)
  {
  return service.deleteUser(id);
    }
    
}