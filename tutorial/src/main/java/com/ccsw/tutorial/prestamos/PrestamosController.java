package com.ccsw.tutorial.prestamos;

import com.ccsw.tutorial.prestamos.model.Prestamos;
import com.ccsw.tutorial.prestamos.model.PrestamosDto;
import com.ccsw.tutorial.prestamos.model.PrestamosSearchDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Tag(name = "Prestamos", description = "API de gestión de préstamos de juegos")
@RequestMapping(value = "/prestamos")
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class PrestamosController {

    @Autowired
    PrestamosService prestamosService;

    @Autowired
    ModelMapper mapper;

    /**
     * Método para recuperar un listado paginado y filtrado de {@link Prestamos}
     *
     * @param dto dto de búsqueda con filtros
     * @return {@link Page} de {@link PrestamosDto}
     */
    @Operation(summary = "Find Page", description = "Devuelve una página de préstamos con filtros")
    @PostMapping("")
    public Page<PrestamosDto> findPage(@RequestBody PrestamosSearchDto dto) {

        Page<Prestamos> page = this.prestamosService.findPage(dto);

        return new PageImpl<>(page.getContent().stream().map(e -> {
            PrestamosDto dtoMapped = new PrestamosDto();
            dtoMapped.setId(e.getId());
            dtoMapped.setGameId(e.getGame().getId());
            dtoMapped.setGameTitle(e.getGame().getTitle());
            dtoMapped.setClientesId(e.getClientes().getId());
            dtoMapped.setClientesName(e.getClientes().getName());
            dtoMapped.setFechaPrestamo(e.getFechaPrestamo());
            dtoMapped.setFechaDevolucion(e.getFechaDevolucion());
            return dtoMapped;
        }).collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
    }

    /**
     * Método para crear o actualizar un {@link Prestamos}
     *
     * @param id  PK del préstamo
     * @param dto datos del préstamo
     */
    @Operation(summary = "Save or Update", description = "Guarda o actualiza un préstamo")
    @PutMapping({ "", "/{id}" })
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody PrestamosDto dto) {
        this.prestamosService.save(id, dto);
    }

    /**
     * Método para eliminar un {@link Prestamos}
     *
     * @param id PK del préstamo
     */
    @Operation(summary = "Delete", description = "Elimina un préstamo")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.prestamosService.delete(id);
    }
}
