package com.example.prompt.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.prompt.entity.SystemUser;
import com.example.prompt.exception.ResourceNotFoundException;
import com.example.prompt.repository.SystemUserRepository;

@Service
public class SystemUserService {
    @Autowired
    private SystemUserRepository repository;
      public SystemUser saveUser(SystemUser user) 
    {
        return repository.save(user);
    }
      public List<SystemUser> getAllUsers() 
      {
        return repository.findAll();
      }
      public SystemUser getUserById(Long id) 
    {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));
    }
       public SystemUser updateUser(Long id, SystemUser user) 
    {

        SystemUser existing = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));
        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setPasswordHash(user.getPasswordHash());
        existing.setRole(user.getRole());
        return repository.save(existing);
    }
    public String deleteUser(Long id)
     {

        SystemUser user = repository.findById(id).orElseThrow(() ->    new ResourceNotFoundException("User not found with id : " + id));
        repository.delete(user);
        return "User deleted successfully";
    }
}
