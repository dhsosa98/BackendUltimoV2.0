package com.example.Backend.Web;

import com.example.Backend.Dao.PropiedadDao;
import com.example.Backend.Dao.PropietarioDao;
import com.example.Backend.Dao.UbicacionDao;
import com.example.Backend.Dao.UserDao;
import com.example.Backend.Dominio.Propiedad;
import com.example.Backend.Dominio.Propietario;
import com.example.Backend.Dominio.Ubicacion;
import com.example.Backend.Dominio.User;
import com.example.Backend.Exception.ResourceNotFoundException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:8081")
public class ClientController {

    @Autowired
    private PropietarioDao propietarioDao;
    
    @GetMapping("/propietarios")
    public List<Propietario> getPropietarios(){
        return propietarioDao.findAll();
    }

    @GetMapping("/propietarios/{id}")
    public ResponseEntity<Propietario> getPropietarioById(@PathVariable long id){
        Propietario propietario = propietarioDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("El id del propietario no existe"));
        return ResponseEntity.ok(propietario);
    }
}
