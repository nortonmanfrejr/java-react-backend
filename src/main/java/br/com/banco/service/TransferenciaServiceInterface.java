package br.com.banco.service;

import br.com.banco.model.Transferencia;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaServiceInterface {

    List<Transferencia> listar();
    List<Transferencia> idConta(Long conta);
    List<Transferencia> nomeOperador(String operador);
    List<Transferencia> periodo(LocalDateTime initial, LocalDateTime end);
    List<Transferencia> nomeOperadorAndPeriodo(String operador, LocalDateTime initial, LocalDateTime end);
}
