
package com.moda.ToNaModa.navControles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moda.ToNaModa.navIdentidades.Casa;
import com.moda.ToNaModa.navRepositorios.CasaRepositorio;


@RestController
@RequestMapping("/casa")
@CrossOrigin(origins = "*")
public class CasaControll {

    @Autowired CasaRepositorio casaRepositorio;


    @GetMapping("/getCasa")
    public ResponseEntity<?> getCasa() {
        return ResponseEntity.ok(casaRepositorio.findAll());
    }

    @PostMapping("/postCasa")
    public ResponseEntity<?> postCasa(@RequestBody Casa casa) {
        return ResponseEntity.ok(casaRepositorio.save(casa));
    }

    @PutMapping("/putCasa/{id}")
    public ResponseEntity<?> putCasa(@PathVariable Long id , @RequestBody Casa casa) {
        if (casaRepositorio.existsById(id)) {
            casa.setId(id);
            return ResponseEntity.ok(casaRepositorio.save(casa));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Não encontrado!");
    }

    @DeleteMapping("/deleteCasa/{id}")
    public ResponseEntity<?> deleteCasa(@PathVariable Long id) {
        if (casaRepositorio.existsById(id)) {
            casaRepositorio.deleteById(id);
        }

        return ResponseEntity.badRequest().body(id + " Não existe!");
    }
}


