package ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class cuentasRequestDTO {

    private Long idCuenta;
    @NotBlank
    @Size(max = 100, min = 5, message = "El maximo de caracteres es 100 y el minimo 5")
    private String nombre;
    @NotBlank
    @Size(max = 20, min = 5, message = "El maximo de caracteres es 20 y el minimo 5")
    private String tipo;
    @NotBlank
    @Size(max = 12, min = 2, message = "El maximo de caracteres es 12 y el minimo 2")
    private int saldoInicial;
    @NotBlank
    private String activa;
}
