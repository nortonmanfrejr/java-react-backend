package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {
    List<Transferencia> findByConta(Integer conta);
    List<Transferencia> findByOperador(String operador);

//    @Query(value = "SELECT * FROM transferencia WHERE data_transferencia BETWEEN startTime AND endTime", nativeQuery = true);
    List<Transferencia> findByOperationDate(LocalDateTime startOperation, LocalDateTime endOperation);
}
