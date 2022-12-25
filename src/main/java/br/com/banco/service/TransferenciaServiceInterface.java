package br.com.banco.service;

import br.com.banco.model.Transferencia;

import java.util.List;

public interface TransferenciaServiceInterface {

    List<Transferencia> listar();
    List<Transferencia> idConta(Long conta);
    List<Transferencia> nomeOperador(String operador);
    List<Transferencia> periodo(String initial,String end);
    List<Transferencia> nomeOperadorAndPeriodo(String operador,String initial,String end);
}
