package com.merenda.escolar.Controlador;

import com.merenda.escolar.Entidade.Merenda;
import com.merenda.escolar.Repositorio.MerendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/merenda")
public class MerendaControlador {

    @Autowired
    private MerendaRepositorio merendaRepository;

    @PostMapping
    public Merenda criarMerenda(@RequestBody Merenda merenda) {
        return merendaRepository.save(merenda);
    }

    @GetMapping
    public List<Merenda> listarMerendas() {
        return merendaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Merenda> buscarMerendaPorId(@PathVariable Long id) {
        return merendaRepository.findById(id)
                .map(merenda -> ResponseEntity.ok().body(merenda))
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Merenda> atualizarMerenda(@PathVariable Long id, @RequestBody Merenda merendaAtualizada) {
        return merendaRepository.findById(id)
                .map(merenda -> {
                    // Atualiza os campos da merenda existente
                    merenda.setNome(merendaAtualizada.getNome());
                    merenda.setDescricao(merendaAtualizada.getDescricao());
                    merenda.setDiaSemana(merendaAtualizada.getDiaSemana());
                    Merenda merendaSalva = merendaRepository.save(merenda);
                    return ResponseEntity.ok().body(merendaSalva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarMerenda(@PathVariable Long id) {
        return merendaRepository.findById(id)
                .map(merenda -> {
                    merendaRepository.delete(merenda);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
