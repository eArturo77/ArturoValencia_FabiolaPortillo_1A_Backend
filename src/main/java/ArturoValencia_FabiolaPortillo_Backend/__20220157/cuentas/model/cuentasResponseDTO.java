package ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model;

import lombok.Data;

@Data
public class cuentasResponseDTO {

    private Long id_cuenta;
    private Long id_usuario;
    private String nombre;
    private String tipo;
    private String saldo_inicial;
    private String activa;

}
