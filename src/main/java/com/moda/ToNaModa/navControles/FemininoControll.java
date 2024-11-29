package com.moda.ToNaModa.navControles;

import com.moda.ToNaModa.navIdentidades.*;
import com.moda.ToNaModa.navRepositorios.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/feminino")
@CrossOrigin(origins = "*")
public class FemininoControll {

    @Autowired
    private FemininoRepositorio femininoRepositorio;


    @GetMapping("/getFeminino")
    public ResponseEntity<?> getFeminino() {
        return ResponseEntity.ok(femininoRepositorio.findAll());
    }

    @PostMapping("/postFeminino")
    public ResponseEntity<?> postFeminino(@RequestBody Feminino feminino) {
        return ResponseEntity.ok(femininoRepositorio.save(feminino));
    }

    @PutMapping("/putFeminino/{id}")
    public ResponseEntity<?> putFeminino(@PathVariable Long id , @RequestBody Feminino feminino) {
        if (femininoRepositorio.existsById(id)) {
            feminino.setId(id);
            return ResponseEntity.ok(femininoRepositorio.save(feminino));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Não encontrado!");
    }

    @DeleteMapping("/deleteFeminino/{id}")
    public ResponseEntity<?> deleteFeminino(@PathVariable Long id) {
        if (femininoRepositorio.existsById(id)) {
            femininoRepositorio.deleteById(id);
        }

        return ResponseEntity.badRequest().body(id + " Não existe!");
    }
}
