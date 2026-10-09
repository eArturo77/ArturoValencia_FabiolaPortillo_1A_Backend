package ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.service;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.entity.cuentasEntity;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model.cuentasRequestDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model.cuentasResponseDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.repository.cuentasRepository;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.Entity.movimientosEntity;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.model.movimientosRequestDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.model.movimientosResponseDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.movimientos.repository.movimientosRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class movimientosService {

    private final movimientosRepository repo;
    private final cuentasRepository cuentaRepository;

    public movimientosService(movimientosRepository repo, cuentasRepository cuentaRepository) {
        this.repo = repo;
        this.cuentaRepository = cuentaRepository;
    }

    public movimientosResponseDTO nuevoMovimiento (movimientosResponseDTO dto) {
        movimientosEntity datosConvertidos = convertirAEntity(dto);
        if (datosConvertidos.getIdMovimiento() == null) {
            return null;
        }
        movimientosEntity respuesta = repo.save(datosConvertidos);
        return convertirADTO(respuesta);
    }

    private movimientosResponseDTO convertirADTO(movimientosEntity respuesta) {
        movimientosResponseDTO dto = new movimientosResponseDTO();
        dto.setId_movimiento(respuesta.getIdMovimiento());
        dto.setFecha(respuesta.getFecha());
        dto.setTipo(respuesta.getTipo());
        dto.setCategoria(respuesta.getCategoria());
        dto.setDescripcion(respuesta.getDescripcion());
        return dto;
    }

    private movimientosEntity convertirAEntity(movimientosResponseDTO dto) {
        movimientosEntity entity = new movimientosEntity();
        entity.setIdMovimiento(dto.getId_movimiento());
        entity.setFecha(dto.getFecha());
        entity.setTipo(dto.getTipo());
        entity.setCategoria(dto.getCategoria());
        return entity;
    }

    public List<movimientosResponseDTO> obtenerTodos () {
        List<movimientosEntity> entidades = repo.findAll();
        List<movimientosResponseDTO> dtos = new ArrayList<>();
        for (movimientosEntity entity: entidades) {
            dtos.add(convertirADTO(entity));
        }
        return dtos;
    }

    public movimientosResponseDTO obtenerPorId (Long id) {
        Optional<movimientosEntity> entidadOpcional = repo.findById(id);
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

}
