package ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.service;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.entity.cuentasEntity;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model.cuentasRequestDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model.cuentasResponseDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.repository.cuentasRepository;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.usuarios.repository.usuarioRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class cuentasService {

    private final usuarioRepository usuarioRepository;
    private final cuentasRepository repo;

    public cuentasService(cuentasRepository repo, usuarioRepository usuarioRepository) {
        this.repo = repo;
        this.usuarioRepository = usuarioRepository;
    }

    public cuentasResponseDTO nuevaCuenta (cuentasRequestDTO dto) {
        cuentasEntity datosConvertidos = convertirAEntity(dto);
        if (datosConvertidos.getUsuarios() == null) {
            return null;
        }
        cuentasEntity respuesta = repo.save(datosConvertidos);
        return convertirADTO(respuesta);
    }

    private cuentasResponseDTO convertirADTO(cuentasEntity respuesta) {
         cuentasResponseDTO dto = new cuentasResponseDTO();
         dto.setId_cuenta(respuesta.getIdCuentas());
         dto.setId_usuario(respuesta.getIdCuentas());
         dto.setNombre(respuesta.getNombre());
         dto.setTipo(respuesta.getTipo());
         dto.setSaldo_inicial(respuesta.getTipo());
         dto.setActiva(respuesta.getActiva());
         if (respuesta.getUsuarios() != null) {
             dto.setId_usuario(respuesta.getUsuarios().getId_usuario());
         }
         return dto;
    }

    private cuentasEntity convertirAEntity(cuentasRequestDTO dto) {
        cuentasEntity entity = new cuentasEntity();
        entity.setIdCuentas(dto.getIdCuenta());
        entity.setNombre(dto.getNombre());
        entity.setTipo(dto.getTipo());
        entity.setSaldo_inicial(dto.getSaldoInicial());
        entity.setActiva(dto.getActiva());
        return entity;
    }

    public List<cuentasResponseDTO> obtenerTodos () {
        List<cuentasEntity> entidades = repo.findAll();
        List<cuentasResponseDTO> dtos = new ArrayList<>();
        for (cuentasEntity entity: entidades) {
            dtos.add(convertirADTO(entity));
        }
        return dtos;
    }

    public cuentasResponseDTO obtenerPorId (Long id) {
        Optional<cuentasEntity> entidadOpcional = repo.findById(id);
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

    public cuentasResponseDTO actualizar(@Valid cuentasRequestDTO dto, Long id){
        try {
            Optional<cuentasEntity> registroExistente = repo.findById(id);
            if (registroExistente.isPresent()) {
                cuentasEntity entidad = registroExistente.get();
                entidad.setNombre(dto.getNombre());
                entidad.setIdCuentas(dto.getIdCuenta());
                entidad.setTipo(dto.getTipo());
                entidad.setSaldo_inicial(dto.getSaldoInicial());
                entidad.setActiva(dto.getActiva());
                cuentasEntity datosGuardados = repo.save(entidad);
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
