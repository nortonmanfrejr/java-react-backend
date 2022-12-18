package br.com.banco.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_transferencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationDate;
    private Double valor;
    private String tipo;
    @Column(name = "nome_operador_transacao")
    private String operador;
    @Column(name = "conta_id")
    private Integer conta;


}
