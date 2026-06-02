package com.jules.parcial.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jules.parcial.entity.Empleado;

public interface EmpleadoRepository  extends JpaRepository<Empleado, Long> {

}
