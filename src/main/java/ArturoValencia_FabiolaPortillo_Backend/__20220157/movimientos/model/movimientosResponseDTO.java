package ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class movimientosResponseDTO {
    private Long id_movimiento;
    private Long id_cuenta;
    private String fecha;
    private  String tipo;
    private String categoria;
    private String descripcion;
    private int monto;
}
