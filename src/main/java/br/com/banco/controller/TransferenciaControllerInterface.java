package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaControllerInterface {

    List<Transferencia> listar();

    List<Transferencia> buscar(Integer conta);
    List<Transferencia> buscar(String operador);
    List<Transferencia> buscar(String initial, String end);
    List<Transferencia> busca(String operador,String initial,String end);
    List<Transferencia> buscar(@PathVariable(value = "operador") String operador,
                               @PathVariable(value = "initial") String initial,
                               @PathVariable(value = "end") String end);
}
