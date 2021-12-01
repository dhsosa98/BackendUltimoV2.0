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
public class PropiedadController {

    @Autowired
    private PropiedadDao propiedadDao;

    @Autowired
    private PropietarioDao propietarioDao;

    @Autowired
    private UbicacionDao ubicacionDao;

    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public ResponseEntity<User> getUUserById(@RequestBody User user){
        User usuario = userDao.findByEmail(user.getEmail());
        User usuario2 = userDao.findByPassword(user.getPassword());
                if (usuario == usuario2){
                    return ResponseEntity.ok(usuario);
                }
        throw new ResourceNotFoundException("El usuario no existe");
    }

    @PostMapping("/registro")
    public User crearUsuario(@RequestBody User user){
        return userDao.save(user);
    }

    @GetMapping("/propiedades")
    public List<Propiedad> getPropiedades(){
        return propiedadDao.findAll();
    }

    // build create propiedad REST API
    @PostMapping("/registrarPropiedad")
    public Propiedad crearPropiedad(@RequestBody Propiedad propiedad){
        return propiedadDao.save(propiedad);
    }

    @PostMapping("/registrarUbicacion")
    public Ubicacion crearUbicacion(@RequestBody Ubicacion ubicacion){
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

    // build get propiedad by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Propiedad> getPropiedadById(@PathVariable long id){
        Propiedad propiedad = propiedadDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("El id de la propiedad no existe"));
        return ResponseEntity.ok(propiedad);
    }

    // build update propiedad REST API
    @PutMapping("{id}")
    public ResponseEntity<Propiedad> updatePropiedad(@PathVariable long id,@RequestBody Propiedad propiedadDetails) {
        Propiedad updatePropiedad = propiedadDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updatePropiedad.setMedidas(propiedadDetails.getMedidas());
        updatePropiedad.setAntiguedad(propiedadDetails.getAntiguedad());
        updatePropiedad.setAmueblado(propiedadDetails.getAmueblado());
        updatePropiedad.setArtefactos(propiedadDetails.getArtefactos());
        updatePropiedad.setServicios(propiedadDetails.getServicios());
        updatePropiedad.setEstado(propiedadDetails.getEstado());
        updatePropiedad.setTipo(propiedadDetails.getTipo());

        propiedadDao.save(updatePropiedad);

        return ResponseEntity.ok(updatePropiedad);
    }

    // build delete propiedad REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Propiedad propiedad = propiedadDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        propiedadDao.delete(propiedad);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

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
