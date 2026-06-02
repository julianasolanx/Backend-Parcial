package com.jules.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jules.parcial.entity.Empresa;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long> {

}
