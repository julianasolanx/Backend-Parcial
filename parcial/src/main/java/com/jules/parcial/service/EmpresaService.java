package com.jules.parcial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jules.parcial.entity.Empresa;
import com.jules.parcial.repository.EmpresaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }


    @Transactional
    public Empresa crearEmpresa(Empresa empresa) {
        Empresa guardada = empresaRepository.save(empresa);

        return guardada;
    }

    public List<Empresa> obtenerEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa obtenerEmpresaPorId(Long id) {
        Empresa empresa = empresaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Empresa no encontrada"));
        return empresa;
    }

     @Transactional
    public Empresa actualizarEmpresa(Long id, Empresa dto) {
        Empresa existente = empresaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Empresa no encontrada"));
        
        Empresa guardada = empresaRepository.save(existente);
        return guardada;
    }

    @Transactional
    public void eliminarEmpresa(Long id) {
        if (!empresaRepository.existsById(id)) {
            throw new EntityNotFoundException("Empresa no existe");
        }
        empresaRepository.deleteById(id);
    }

    

}
