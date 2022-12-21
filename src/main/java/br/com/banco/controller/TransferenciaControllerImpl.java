package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = "http://localhost:3000") // CrossOrigin da aplicação
    @GetMapping
    @Override
    public List<Transferencia> listar() {
        return repository.findAll();
    }


    /**
     * Busca todas as transferencias realizados por uma conta.
     * @param conta a ser buscada
     * @return lista de transações a partir do numero da conta
     * */
    @CrossOrigin(origins = "http://localhost:3000") // CrossOrigin da aplicação
    @GetMapping(value = "/search==cc{conta}")
    @Override
    public List<Transferencia> buscar(@PathVariable Integer conta) {
        return repository.findByConta(conta);
    }

    /**
     * Busca todas as transferencias realizados por um operador, caso seja passado o valor null
     * recebera todos os operadores null
     * @param operador a ser buscado
     * @return lista de transações a partir do nome do operador
     * */
    @CrossOrigin(origins = "http://localhost:3000") // CrossOrigin da aplicação
    @GetMapping(value = "/search==oc{operador}")
    @Override
    public List<Transferencia> buscar(@PathVariable String operador) {
        if (operador.equals("null")) operador = null; // caso seja digitado null como operador de busca

        return repository.findByOperador(operador);
    }

    /**
     * Busca todas as transferencias realizados dentro de um periodo de tempo.
     * @param initial data inicial
     * @param end data final
     * @return lista de transações que foram realizadas entre de initial e end
     * */
    @CrossOrigin(origins = "http://localhost:3000") // CrossOrigin da aplicação
    @GetMapping(value = "/search==init{initial}&end{end}")
    @Override
    public List<Transferencia> buscar(@PathVariable(value = "initial") String initial,@PathVariable(value = "end") String end) {
        return repository.findByDateTime(assistant.dateTimeConverter(initial),assistant.dateTimeConverter(end));
    }

    /**
     * Busca todas as transferencias que um usuario realizou dentro de um periodo de tempo.
     * @param operador nome
     * @param initial data inicial
     * @param end data final
     * @return lista de transações que foram realizadas entre de initial e end
     * */
    @CrossOrigin(origins = "http://localhost:3000") // CrossOrigin da aplicação
    @GetMapping(value = "/search=={operador}&init{initial}&end{end}")
    @Override
    public List<Transferencia> buscar(@PathVariable(value = "operador") String operador,
                                      @PathVariable(value = "initial") String initial,
                                      @PathVariable(value = "end") String end) {
        return repository.findByOperadorDateTime(operador,assistant.dateTimeConverter(initial),assistant.dateTimeConverter(end));
    }
}
