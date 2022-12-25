package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferenciaServiceImpl implements TransferenciaServiceInterface{

    @Autowired
    private TransferenciaRepository repository;

    /**
     * Busca todas as transferencias realizadas pela API que estejam listadas na base de dados
     * @return lista com todas as transferencias
     * */
    @Override
    public List<Transferencia> listar() {
        return repository.findAll();
    }

    /**
     * Busca todas as transferencias realizados por uma conta.
     * @param conta a ser buscada
     * @return lista de transações a partir do numero da conta
     * */
    @Override
    public List<Transferencia> idConta(Long conta) {
        return repository.findByConta(conta);
    }

    /**
     * Busca todas as transferencias realizados por um operador, caso seja passado o valor null
     * recebera todos os operadores null
     * @param operador a ser buscado
     * @return lista de transações a partir do nome do operador
     * */
    @Override
    public List<Transferencia> nomeOperador(String operador) {
        if (operador.equals("null")) operador = null; // caso seja digitado null como operador de busca
        return repository.findByOperador(operador);
    }

    /**
     * Busca todas as transferencias realizados dentro de um periodo de tempo.
     * @param initial data inicial
     * @param end data final
     * @return lista de transações que foram realizadas entre de initial e end
     * */
    @Override
    public List<Transferencia> periodo(LocalDateTime initial, LocalDateTime end) {
        return repository.findByDateTime(initial,end);
    }

    /**
     * Busca todas as transferencias que um usuario realizou dentro de um periodo de tempo.
     * @param operador nome
     * @param initial data inicial
     * @param end data final
     * @return lista de transações que foram realizadas entre de initial e end
     * */
    @Override
    public List<Transferencia> nomeOperadorAndPeriodo(String operador,
                                                      LocalDateTime initial,
                                                      LocalDateTime end) {
        return repository.findByOperadorDateTime(operador,initial,end);
    }


}
