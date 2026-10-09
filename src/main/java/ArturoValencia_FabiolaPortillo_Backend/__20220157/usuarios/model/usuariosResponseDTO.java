package ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.model;

import lombok.Data;

@Data
public class usuariosResponseDTO {
    private Long idUsuarios;
    private String nombre;
    private  String correo;
    private String fecha_registro;
}
