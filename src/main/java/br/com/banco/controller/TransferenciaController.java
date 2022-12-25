package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaServiceImpl;
import br.com.banco.service.TransferenciaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RestController
@RequestMapping("/transferencia")
@CrossOrigin(value = "*") // Coringar a porta de aceitação
public class TransferenciaController {

    /**
     * Classe de controle e serviços implementadas seguindo um padrão de DI e IoC.
     * */
    @Autowired // Adicionando disponibilidade para alterações de implementação sem afetar as requisições
    private TransferenciaControllerImpl impl = new TransferenciaControllerImpl(new TransferenciaServiceImpl()); // Pegando interface de serviço

    // lista de todos os usuarios
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Transferencia>> listar() {
        return ResponseEntity.ok().body(impl.listar());
    }

    // filtragem de lista atraves de paramentros
    @GetMapping("/search==")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Transferencia>> buscar(
            @RequestParam(name = "init", required = false) LocalDateTime init,
            @RequestParam(name = "end", required = false) LocalDateTime end,
            @RequestParam(name = "nomeOperador", required = false) String nomeOperador
            ) {
//        List<Transferencia> list = impl.filtered(init,end,nomeOperador);
        return ResponseEntity.ok().body(impl.filtered(init,end,nomeOperador));
    }

}
