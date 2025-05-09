package com.ccsw.tutorial.clientes;

import com.ccsw.tutorial.clientes.model.Clientes;
import com.ccsw.tutorial.clientes.model.ClientesDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ccsw
 *
 */
@Tag(name = "Clientes", description = "API of Clientes")
@RequestMapping(value = "/clientes")
@RestController
@CrossOrigin(origins = "*")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    @Autowired
    ModelMapper mapper;

    /**
     * Método para recuperar todas las {@link Clientes}
     *
     * @return {@link List} de {@link ClientesDto}
     */
    @Operation(summary = "Find", description = "Method that return a list of Clientes")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<ClientesDto> findAll() {

        List<Clientes> categories = this.clientesService.findAll();

        return categories.stream().map(e -> mapper.map(e, ClientesDto.class)).collect(Collectors.toList());
    }

    /**
     * Método para crear o actualizar una {@link Clientes}
     *
     * @param id PK de la entidad
     * @param dto datos de la entidad
     */
    @Operation(summary = "Save or Update", description = "Method that saves or updates a Clientes")
    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody ClientesDto dto) throws Exception {
        try {
            this.clientesService.save(id, dto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nombre repetido");
        }
    }

    /**
     * Método para borrar una {@link Clientes}
     *
     * @param id PK de la entidad
     */
    @Operation(summary = "Delete", description = "Method that deletes a Clientes")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws Exception {

        this.clientesService.delete(id);
    }

}