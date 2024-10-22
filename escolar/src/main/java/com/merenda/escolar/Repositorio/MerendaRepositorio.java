package com.merenda.escolar.Repositorio;

import com.merenda.escolar.Entidade.Merenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerendaRepositorio extends JpaRepository<Merenda, Long> {
}
