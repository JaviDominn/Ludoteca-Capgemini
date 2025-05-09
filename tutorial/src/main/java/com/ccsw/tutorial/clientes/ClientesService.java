package com.ccsw.tutorial.clientes;

import com.ccsw.tutorial.clientes.model.Clientes;
import com.ccsw.tutorial.clientes.model.ClientesDto;

import java.util.List;

/**
 * @author ccsw
 *
 */
public interface ClientesService {

    /**
     * Recupera una {@link Clientes} a partir de su ID
     *
     * @param id PK de la entidad
     * @return {@link Clientes}
     */
    Clientes get(Long id);

    /**
     * Método para recuperar todas las {@link Clientes}
     *
     * @return {@link List} de {@link Clientes}
     */
    List<Clientes> findAll();

    /**
     * Método para crear o actualizar una {@link Clientes}
     *
     * @param id PK de la entidad
     * @param dto datos de la entidad
     */
    void save(Long id, ClientesDto dto) throws Exception;

    /**
     * Método para borrar una {@link Clientes}
     *
     * @param id PK de la entidad
     */
    void delete(Long id) throws Exception;

}
