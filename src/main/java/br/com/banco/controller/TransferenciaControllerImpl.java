package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaServiceInterface;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
@AllArgsConstructor
public class TransferenciaControllerImpl {

    @Autowired
    private TransferenciaServiceInterface anInterface; // Pegando interface de serviço

    public List<Transferencia> listar() {
        return anInterface.listar();
    }

    public List<Transferencia> filtered(LocalDateTime init,LocalDateTime end, String nomeOperador) {
        List<Transferencia> transferencias = anInterface.listar();

        if(!nomeOperador.isEmpty()){
            transferencias = transferencias.stream().
                    filter(transferecia -> transferecia.getOperador() != null
                            &&
                            transferecia.getOperador().equals(nomeOperador)).collect(toList());
        }

//        if(init != null && end != null){
//            transferencias = transferencias.stream().filter(
//                    transferecia -> transferecia.getOperationDate().(init)
//                            && transferecia.getOperationDate().isBefore(end)
//                            || transferecia.getOperationDate().isEqual(init)
//                            || transferecia.getOperationDate().isEqual(end) ).toList();
//        }

        return transferencias;
    }
}
