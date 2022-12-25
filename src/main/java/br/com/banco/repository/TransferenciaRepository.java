package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import com.fasterxml.jackson.annotation.JsonKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findByConta(Long conta);
    List<Transferencia> findByOperador(String operador);

    @Query(value = "SELECT * FROM transferencia " +
            "WHERE data_transferencia BETWEEN :initial AND :end",
            nativeQuery = true)
    List<Transferencia> findByDateTime(LocalDateTime initial, LocalDateTime end);

    @Query(value = "SELECT * FROM transferencia " +
            "WHERE nome_operador_transacao = :operador AND data_transferencia BETWEEN :initial AND :end",
            nativeQuery = true)
    List<Transferencia> findByOperadorDateTime(String operador,LocalDateTime initial,LocalDateTime end);
}
