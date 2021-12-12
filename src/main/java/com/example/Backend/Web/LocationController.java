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
public class LocationController {

    @Autowired
    private UbicacionDao ubicacionDao;

    @PostMapping("/registrarUbicacion")
    public Ubicacion crearUbicacion(@RequestBody Ubicacion ubicacion){
        List<Ubicacion> AllUbications = ubicacionDao.findAll();
        for (Ubicacion ubicacionInList : AllUbications) {
            if ((ubicacionInList.getPais().equals(ubicacion.getPais()))&&
            (ubicacionInList.getCiudad().equals(ubicacion.getCiudad()))&&
            (ubicacionInList.getProvincia().equals(ubicacion.getProvincia()))&&
            (ubicacionInList.getDireccion().equals(ubicacion.getDireccion()))&&
            (ubicacionInList.getNumero().equals(ubicacion.getNumero()))
            ){
                throw new ResourceNotFoundException("La ubicacion ya existe");
            }
        }
        return ubicacionDao.save(ubicacion);
    }

    @GetMapping("/ubicaciones")
    public List<Ubicacion> getUbicaciones(){
        return ubicacionDao.findAll();
    }

    @GetMapping("/ubicacion/{id}")
    public ResponseEntity<Ubicacion> getUbicacionById(@PathVariable long id){
        Ubicacion ubicacion = ubicacionDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("El id de la ubicacion no existe"));
        return ResponseEntity.ok(ubicacion);
    }

    @PutMapping("/ubicacion/{id}")
    public ResponseEntity<Ubicacion> updateUbicacion(@PathVariable long id,@RequestBody Ubicacion ubicacionDetails) {
        Ubicacion updateUbicacion = ubicacionDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El id de la ubicacion no existe con: " + id));

        updateUbicacion.setPais(ubicacionDetails.getPais());
        updateUbicacion.setProvincia(ubicacionDetails.getProvincia());
        updateUbicacion.setCiudad(ubicacionDetails.getCiudad());
        updateUbicacion.setBarrio(ubicacionDetails.getBarrio());
        updateUbicacion.setDireccion(ubicacionDetails.getDireccion());
        updateUbicacion.setNumero(ubicacionDetails.getNumero());
        updateUbicacion.setPiso(ubicacionDetails.getPiso());
        updateUbicacion.setDpto(ubicacionDetails.getDpto());

        ubicacionDao.save(updateUbicacion);

        return ResponseEntity.ok(updateUbicacion);
    }
    
}
