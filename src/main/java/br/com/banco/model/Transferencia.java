package br.com.banco.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_transferencia")
    private LocalDateTime operationDate;
    private Double valor;
    private String tipo;
    @Column(name = "nome_operador_transacao")
    private String operador;
    @Column(name = "conta_id")
    private Integer conta;


}
