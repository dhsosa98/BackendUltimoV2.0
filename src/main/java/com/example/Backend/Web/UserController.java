package com.example.Backend.Web;

import com.example.Backend.Dao.UserDao;
import com.example.Backend.Dominio.User;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Backend.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public ResponseEntity<String> getUUserById(@RequestBody User user){
        User usuario = userDao.findByEmail(user.getEmail());
        String token = getJWTToken(user.getEmail());
                if ((user != null)&&(user.getPassword().equals(usuario.getPassword()))){
                    return ResponseEntity.ok(token);
                }
        throw new ResourceNotFoundException("El usuario no existe");
    }

    @PostMapping("/registro")
    public User crearUsuario(@RequestBody User user){
        return userDao.save(user);
    }

    private String getJWTToken(String username) {
		String secretKey = "adrenocorticotropina";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
