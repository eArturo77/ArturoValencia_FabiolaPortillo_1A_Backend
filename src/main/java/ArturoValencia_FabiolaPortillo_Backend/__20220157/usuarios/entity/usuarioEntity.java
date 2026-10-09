package ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.entity;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.entity.cuentasEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class usuarioEntity {

    @Id
    @Column(name = "id_usuario" )
    private Long id_usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column (name = "fecha_registro")
    private String fecha_registro;

    @OneToMany(mappedBy = "usuarios")
    private List<cuentasEntity> usuario = new ArrayList();
}
