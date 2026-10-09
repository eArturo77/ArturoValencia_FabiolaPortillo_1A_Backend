package ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.Entity;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.entity.cuentasEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "movimientos")
public class movimientosEntity {
    @Column(name = "id_movimiento")
    private Long idMovimiento;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "monto")
    private int monto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta")
    private cuentasEntity cuentas;

}
