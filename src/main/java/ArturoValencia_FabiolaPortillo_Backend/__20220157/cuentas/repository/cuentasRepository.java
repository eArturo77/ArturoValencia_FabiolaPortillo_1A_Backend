package ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.repository;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.entity.cuentasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cuentasRepository extends JpaRepository<cuentasEntity, Long> {

}
