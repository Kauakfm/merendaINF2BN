package com.merenda.escolar.Repositorio;

import com.merenda.escolar.Entidade.RegistroMerenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroMerendaRepositorio extends JpaRepository<RegistroMerenda, Long> {
}
