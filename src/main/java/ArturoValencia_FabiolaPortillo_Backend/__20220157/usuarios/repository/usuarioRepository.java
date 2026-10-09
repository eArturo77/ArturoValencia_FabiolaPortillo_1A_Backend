package ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.repository;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.entity.usuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository <usuarioEntity, Long> {

}
