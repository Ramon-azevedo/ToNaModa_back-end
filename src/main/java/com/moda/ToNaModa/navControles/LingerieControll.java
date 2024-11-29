package com.moda.ToNaModa.navControles;

import com.moda.ToNaModa.navIdentidades.*;
import com.moda.ToNaModa.navRepositorios.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lingerie")
@CrossOrigin(origins = "*")
public class LingerieControll {

    @Autowired LingerieRepositorio lingerieRepositorio;


    @GetMapping("/getLingerie")
    public ResponseEntity<?> getLingerie() {
        return ResponseEntity.ok(lingerieRepositorio.findAll());
    }

    @PostMapping("/postLingerie")
    public ResponseEntity<?> postLingerie(@RequestBody Lingerie lingerie) {
        return ResponseEntity.ok(lingerieRepositorio.save(lingerie));
    }

    @PutMapping("/putLingerie/{id}")
    public ResponseEntity<?> putLingerie(@PathVariable Long id , @RequestBody Lingerie lingerie) {
        if (lingerieRepositorio.existsById(id)) {
            lingerie.setId(id);
            return ResponseEntity.ok(lingerieRepositorio.save(lingerie));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Não encontrado!");
    }

    @DeleteMapping("/deleteLingerie/{id}")
    public ResponseEntity<?> deleteLingerie(@PathVariable Long id) {
        if (lingerieRepositorio.existsById(id)) {
            lingerieRepositorio.deleteById(id);
        }

        return ResponseEntity.badRequest().body(id + " Não existe!");
    }
}


