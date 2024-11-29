package com.moda.ToNaModa.navControles;

import com.moda.ToNaModa.navIdentidades.*;
import com.moda.ToNaModa.navRepositorios.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/plusSize")
@CrossOrigin(origins = "*")
public class PlusSizeControll {

    @Autowired PlusSizeRepositorio plusSizeRepositorio;


    @GetMapping("/getPlusSize")
    public ResponseEntity<?> getPlusSize() {
        return ResponseEntity.ok(plusSizeRepositorio.findAll());
    }

    @PostMapping("/postPlusSize")
    public ResponseEntity<?> postPlusSize(@RequestBody PlusSize plusSize) {
        return ResponseEntity.ok(plusSizeRepositorio.save(plusSize));
    }

    @PutMapping("/putPlusSize/{id}")
    public ResponseEntity<?> putPlusSize(@PathVariable Long id , @RequestBody PlusSize plusSize) {
        if (plusSizeRepositorio.existsById(id)) {
            plusSize.setId(id);
            return ResponseEntity.ok(plusSizeRepositorio.save(plusSize));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Não encontrado!");
    }

    @DeleteMapping("/deletePlusSize/{id}")
    public ResponseEntity<?> deletePlusSize(@PathVariable Long id) {
        if (plusSizeRepositorio.existsById(id)) {
            plusSizeRepositorio.deleteById(id);
        }

        return ResponseEntity.badRequest().body(id + " Não existe!");
    }
}


