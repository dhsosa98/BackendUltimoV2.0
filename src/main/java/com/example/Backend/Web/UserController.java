package com.example.Backend.Web;

import com.example.Backend.Dao.UserDao;
import com.example.Backend.Dominio.User;
import com.example.Backend.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public ResponseEntity<User> getUUserById(@RequestBody User user){
        User usuario = userDao.findByEmail(user.getEmail());
                if ((user != null)&&(user.getPassword().equals(usuario.getPassword()))){
                    return ResponseEntity.ok(usuario);
                }
        throw new ResourceNotFoundException("El usuario no existe");
    }

    @PostMapping("/registro")
    public User crearUsuario(@RequestBody User user){
        return userDao.save(user);
    }
    
}
