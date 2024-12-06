package com.moda.ToNaModa.navControles;

import com.moda.ToNaModa.navRepositorios.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/identidades")
@CrossOrigin(origins = "*")
public class IdentidadesController {
    @Autowired
    private FemininoRepositorio femininoRepositorio;

    @Autowired
    private InfantilRepositorio infantilRepositorio;

    @Autowired
    private JeansRepositorio jeansRepositorio;

    @Autowired
    private LingerieRepositorio lingerieRepositorio;

    @Autowired
    private MasculinoRepositorio masculinoRepositorio;

    @Autowired
    private OfertasRepositorio ofertasRepositorio;

    @Autowired
    private PlusSizeRepositorio plusSizeRepositorio;


    @GetMapping("/pesquisa")
    public ResponseEntity<?> pesquisaPorNome(@RequestParam String query) {
        query = query.toLowerCase();

        List<Object> results = new ArrayList<>();

        results.addAll(femininoRepositorio.findByNomeContainingIgnoreCase(query));
        results.addAll(infantilRepositorio.findByNomeContainingIgnoreCase(query));
        results.addAll(masculinoRepositorio.findByNomeContainingIgnoreCase(query));
        results.addAll(plusSizeRepositorio.findByNomeContainingIgnoreCase(query));
        results.addAll(ofertasRepositorio.findByNomeContainingIgnoreCase(query));
        results.addAll(lingerieRepositorio.findByNomeContainingIgnoreCase(query));
        results.addAll(jeansRepositorio.findByNomeContainingIgnoreCase(query));

        return ResponseEntity.ok(results);

    }

}
