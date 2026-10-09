package ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class usuariosRequestDTO {

    private Long idUsuarios;
    @NotBlank
    @Size(max = 100, min = 5, message = "El maximo de caracteres es 100 y el minimo 5")
    private String nombre;
    @NotBlank
    @Size(max = 150,min = 10,message = "El maximo de caracteres es 150 y el minimo es 10")
    private String correo;
    @NotBlank
    private String fecha;
}
