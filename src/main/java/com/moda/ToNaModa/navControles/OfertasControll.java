package com.moda.ToNaModa.navControles;

import com.moda.ToNaModa.navIdentidades.*;
import com.moda.ToNaModa.navRepositorios.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ofertas")
@CrossOrigin(origins = "*")
public class OfertasControll {

    @Autowired OfertasRepositorio ofertasRepositorio;


    @GetMapping("/getOfertas")
    public ResponseEntity<?> getOfertas() {
        return ResponseEntity.ok(ofertasRepositorio.findAll());
    }

    @PostMapping("/postOfertas")
    public ResponseEntity<?> postOfertas(@RequestBody Ofertas ofertas) {
        return ResponseEntity.ok(ofertasRepositorio.save(ofertas));
    }

    @PutMapping("/putOfertas/{id}")
    public ResponseEntity<?> putOfertas(@PathVariable Long id , @RequestBody Ofertas ofertas) {
        if (ofertasRepositorio.existsById(id)) {
            ofertas.setId(id);
            return ResponseEntity.ok(ofertasRepositorio.save(ofertas));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Não encontrado!");
    }

    @DeleteMapping("/deleteOfertas/{id}")
    public ResponseEntity<?> deleteOfertas(@PathVariable Long id) {
        if (ofertasRepositorio.existsById(id)) {
            ofertasRepositorio.deleteById(id);
        }

        return ResponseEntity.badRequest().body(id + " Não existe!");
    }
}



