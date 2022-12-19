package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaControllerImpl implements TransferenciaControllerInterface {

    @Autowired
    private TransferenciaRepository repository;
    private final ControllerAssistant assistant = new ControllerAssistant();
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
    @GetMapping(value = "/search==cc{conta}")
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

    @GetMapping(value = "/search==init{initial}&end{end}")
    @Override
    public List<Transferencia> buscar(@PathVariable(value = "initial") String initial,@PathVariable(value = "end") String end) {
        return repository.findByDateTime(assistant.dateTimeConverter(initial),assistant.dateTimeConverter(end));
    }

    @Override
    public List<Transferencia> busca(String operador, String initial, String end) {
        return null;
    }

    @GetMapping(value = "/search==oc{operador}&init{initial}&end{end}")
    @Override
    public List<Transferencia> buscar(@PathVariable(value = "operador") String operador,
                                      @PathVariable(value = "initial") String initial,
                                      @PathVariable(value = "end") String end) {
        return repository.findByOperadorDateTime(operador,assistant.dateTimeConverter(initial),assistant.dateTimeConverter(end));
    }
}
