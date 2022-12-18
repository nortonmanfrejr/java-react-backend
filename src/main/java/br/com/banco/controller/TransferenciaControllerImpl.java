package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaControllerImpl implements TransferenciaControllerInterface {

    @Autowired
    private TransferenciaRepository repository;

    /**
     * Busca todas as transferencias realizadas pela API que estejam listadas na base de dados
     * @return lista com todas as transferencias
     * */
    @GetMapping
    @Override
    public List<Transferencia> listar() {
        return repository.findAll();
    }


    /**
     * Busca todas as transferencias realizados por uma conta.
     * @param conta numero
     * @return lista de transações a partir do numero da conta
     * */
    @GetMapping(value = "/search=cc{conta}")
    @Override
    public List<Transferencia> buscar(@PathVariable Integer conta) {
        return repository.findByConta(conta);
    }

    @GetMapping(value = "/search==oc{operador}")
    @Override
    public List<Transferencia> buscar(@PathVariable String operador) {
        if (operador.equals("null")) operador = null; // caso seja digitado null como operador de busca


        return repository.findByOperador(operador);
    }

    @GetMapping(value = "search==odc1f{startOperation}==odc2f{endOperation}")
    @Override
    public List<Transferencia> buscar(@PathVariable LocalDateTime startOperation, @PathVariable LocalDateTime endOperation) {
        return repository.findByOperationDate(startOperation,endOperation );
    }
}
