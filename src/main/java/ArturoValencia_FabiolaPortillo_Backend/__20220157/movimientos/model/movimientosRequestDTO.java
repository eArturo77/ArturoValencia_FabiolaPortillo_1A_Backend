package ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.model;


import jakarta.validation.constraints.NotBlank;

public class movimientosRequestDTO {

    private Long id_movimiento;
    private Long id_cuenta;
    @NotBlank
    private String fecha;
    @NotBlank
    private  String tipo;
    @NotBlank
    private String categoria;
    @NotBlank
    private String descripcion;
    @NotBlank
    private int monto;
}
