package ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.repository;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.Entity.movimientosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface movimientosRepository extends JpaRepository<movimientosEntity, Long> {
}
