package ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.entity;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.entity.usuarioEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cuentas")
public class cuentasEntity {

    @Column(name = "id_cuenta")
    private Long idCuentas;
    @Column(name = "nombre")
    private  String nombre;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "saldo_inicial")
    private int saldo_inicial;
    @Column(name = "activa")
    private String activa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private usuarioEntity usuarios;

}
