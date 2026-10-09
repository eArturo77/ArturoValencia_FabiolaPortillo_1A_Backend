package ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.Service;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.entity.cuentasEntity;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model.cuentasRequestDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model.cuentasResponseDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.entity.usuarioEntity;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.model.usuariosRequestDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.model.usuariosResponseDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.repository.usuarioRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class usuarioService {


    private final usuarioRepository repo;

    public usuarioService(usuarioRepository repo) {
        this.repo = repo;
    }
    public usuariosResponseDTO nuevoUsuario (usuariosRequestDTO dto) {
        usuarioEntity datosConvertidos = convertirAEntity(dto);
        usuarioEntity respuesta = repo.save(datosConvertidos);
        return convertirADTO (respuesta);
    }

    private usuariosResponseDTO convertirADTO(usuarioEntity respuesta) {
        usuariosResponseDTO dto = new usuariosResponseDTO();
        dto.setIdUsuarios(respuesta.getId_usuario());
        dto.setNombre(respuesta.getNombre());
        dto.setCorreo(respuesta.getCorreo());
        dto.setFecha_registro(respuesta.getFecha_registro());
        return dto;
    }

    private usuarioEntity convertirAEntity(usuariosRequestDTO dto) {
        usuarioEntity entity = new usuarioEntity();
        entity.setId_usuario(dto.getIdUsuarios());
        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        entity.setFecha_registro(dto.getFecha());
        return entity;
    }

    public List<usuariosResponseDTO> obtenerTodos () {
        List<usuarioEntity> entidades = repo.findAll();
        List<usuariosResponseDTO> dtos = new ArrayList<>();
        for (usuarioEntity entity: entidades) {
            dtos.add(convertirADTO(entity));
        }
        return dtos;
    }

    public usuariosResponseDTO obtenerPorId (Long id) {
        Optional<usuarioEntity> entidadOpcional = repo.findById(id);
        if (entidadOpcional.isPresent()) {
            return convertirADTO(entidadOpcional.get());
        }
        return null;
    }

    public boolean eliminarCuentas (Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public usuariosResponseDTO actualizar(@Valid usuariosRequestDTO dto, Long id){
        try {
            Optional<usuarioEntity> registroExistente = repo.findById(id);
            if (registroExistente.isPresent()) {
                usuarioEntity entidad = registroExistente.get();
                entidad.setNombre(dto.getNombre());
                entidad.setId_usuario(dto.getIdUsuarios());
                entidad.setCorreo(dto.getCorreo());
                entidad.setFecha_registro(dto.getFecha());
                usuarioEntity datosGuardados = repo.save(entidad);
                return convertirADTO(datosGuardados);
            }
            return null;
        }
        catch (Exception e) {
            log.error("Error al actualizar los datos");
            return null;
        }
    }


}
