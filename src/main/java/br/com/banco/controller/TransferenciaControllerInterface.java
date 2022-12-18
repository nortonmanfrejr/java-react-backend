package br.com.banco.controller;

import br.com.banco.model.Transferencia;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaControllerInterface {

    List<Transferencia> listar();
    List<Transferencia> buscar(Integer conta);
    List<Transferencia> buscar(String operador);
    List<Transferencia> buscar(LocalDateTime startOperation, LocalDateTime endOperation);

}
