package br.com.banco.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conta;
    private String nome_responsavel;

}
