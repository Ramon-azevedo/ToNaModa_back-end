package com.moda.ToNaModa.navControles;

import com.moda.ToNaModa.navIdentidades.*;
import com.moda.ToNaModa.navRepositorios.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jeans")
@CrossOrigin(origins = "*")
public class JeansControll {

    @Autowired
    private JeansRepositorio jeansRepositorio;


    @GetMapping("/getJeans")
    public ResponseEntity<?> getJeans() {
        return ResponseEntity.ok(jeansRepositorio.findAll());
    }

    @PostMapping("/postJeans")
    public ResponseEntity<?> postJeans(@RequestBody Jeans jeans) {
        return ResponseEntity.ok(jeansRepositorio.save(jeans));
    }

    @PutMapping("/putJeans/{id}")
    public ResponseEntity<?> putJeans(@PathVariable Long id , @RequestBody Jeans jeans) {
        if (jeansRepositorio.existsById(id)) {
            jeans.setId(id);
            return ResponseEntity.ok(jeansRepositorio.save(jeans));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Não encontrado!");
    }

    @DeleteMapping("/deleteJeans/{id}")
    public ResponseEntity<?> deleteJeans(@PathVariable Long id) {
        if (jeansRepositorio.existsById(id)) {
            jeansRepositorio.deleteById(id);
        }

        return ResponseEntity.badRequest().body(id + " Não existe!");
    }
}

