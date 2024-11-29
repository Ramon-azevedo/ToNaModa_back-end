package com.moda.ToNaModa.navControles;

import com.moda.ToNaModa.navIdentidades.*;
import com.moda.ToNaModa.navRepositorios.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/infantil")
@CrossOrigin(origins = "*")
public class InfantilControll {

    @Autowired
    private InfantilRepositorio infantilRepositorio;


    @GetMapping("/getInfantil")
    public ResponseEntity<?> getInfantil() {
        return ResponseEntity.ok(infantilRepositorio.findAll());
    }

    @PostMapping("/postInfantil")
    public ResponseEntity<?> postInfantil(@RequestBody Infantil infantil) {
        return ResponseEntity.ok(infantilRepositorio.save(infantil));
    }

    @PutMapping("/putInfantil/{id}")
    public ResponseEntity<?> putInfantil(@PathVariable Long id , @RequestBody Infantil infantil) {
        if (infantilRepositorio.existsById(id)) {
            infantil.setId(id);
            return ResponseEntity.ok(infantilRepositorio.save(infantil));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Não encontrado!");
    }

    @DeleteMapping("/deleteInfantil/{id}")
    public ResponseEntity<?> deleteInfantil(@PathVariable Long id) {
        if (infantilRepositorio.existsById(id)) {
            infantilRepositorio.deleteById(id);
        }

        return ResponseEntity.badRequest().body(id + " Não existe!");
    }
}

