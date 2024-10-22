package com.merenda.escolar.Controlador;


import com.merenda.escolar.Entidade.Aluno;
import com.merenda.escolar.Entidade.Merenda;
import com.merenda.escolar.Entidade.RegistroMerenda;
import com.merenda.escolar.Repositorio.AlunoRepositorio;
import com.merenda.escolar.Repositorio.MerendaRepositorio;
import com.merenda.escolar.Repositorio.RegistroMerendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/registroMerenda")
public class ResgistroMerendaControlador {

    @Autowired
    private RegistroMerendaRepositorio registroMerendaRepository;

    @Autowired
    private AlunoRepositorio alunoRepository;

    @Autowired
    private MerendaRepositorio merendaRepository;

    @PostMapping
    public RegistroMerenda registrarMerenda(@RequestBody RegistroMerenda reservaMerenda) {
        Aluno aluno = alunoRepository.findById(reservaMerenda.getAluno().getId()).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Merenda merenda = merendaRepository.findById(reservaMerenda.getMerenda().getId()).orElseThrow(() -> new RuntimeException("Merenda não encontrada"));

        RegistroMerenda registro = new RegistroMerenda();
        registro.setAluno(aluno);
        registro.setMerenda(merenda);
        registro.setDataRegistro(LocalDateTime.now());

        return registroMerendaRepository.save(registro);
    }

    @GetMapping
    public List<RegistroMerenda> listarRegistros() {
        return registroMerendaRepository.findAll();
    }
}
