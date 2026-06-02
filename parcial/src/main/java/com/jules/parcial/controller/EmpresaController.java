package com.jules.parcial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jules.parcial.entity.Empresa;
import com.jules.parcial.service.EmpresaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;


@GetMapping
    public ResponseEntity<List<Empresa>> tomarTodas() {
        return ResponseEntity.ok(empresaService.obtenerEmpresas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> tomarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.obtenerEmpresaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Empresa> crear(@RequestBody Empresa dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.crearEmpresa(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizar(@PathVariable Long id, @RequestBody Empresa dto) {
        return ResponseEntity.ok(empresaService.actualizarEmpresa(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        empresaService.eliminarEmpresa(id);
        return ResponseEntity.noContent().build();
    }

}
