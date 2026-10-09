package ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.controller;

import ArturoValencia_FabiolaPortillo_Backend.__20220157.Response.apiResponse;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model.cuentasRequestDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.model.cuentasResponseDTO;
import ArturoValencia_FabiolaPortillo_Backend.__20220157.cuentas.service.cuentasService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin
public class cuentasController {

    private final cuentasService service;
    public cuentasController(cuentasService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<apiResponse <cuentasResponseDTO>> nuevacuenta (@Valid @RequestBody cuentasRequestDTO json) {
        return null;
        //no me dio tiempo a terminarla me faltaron los controller pero creo que lo demas esta bien :(
    }

}
