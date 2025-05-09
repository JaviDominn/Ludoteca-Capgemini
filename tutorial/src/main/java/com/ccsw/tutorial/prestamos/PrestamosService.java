package com.ccsw.tutorial.prestamos;

import com.ccsw.tutorial.prestamos.model.Prestamos;
import com.ccsw.tutorial.prestamos.model.PrestamosDto;
import com.ccsw.tutorial.prestamos.model.PrestamosSearchDto;
import org.springframework.data.domain.Page;

public interface PrestamosService {

    /**
     * Recupera un {@link Prestamos} a través de su ID
     *
     * @param id PK de la entidad
     * @return {@link Prestamos}
     */
    Prestamos get(Long id);

    /**
     * Método para recuperar un listado paginado de {@link Prestamos}
     *
     * @param dto dto de búsqueda
     * @return {@link Page} de {@link Prestamos}
     */
    Page<Prestamos> findPage(PrestamosSearchDto dto);

    /**
     * Método para crear o actualizar un {@link Prestamos}
     *
     * @param id  PK de la entidad
     * @param dto datos de la entidad
     */
    void save(Long id, PrestamosDto dto);

    /**
     * Método para eliminar un {@link Prestamos}
     *
     * @param id PK de la entidad
     */
    void delete(Long id) throws Exception;
}
