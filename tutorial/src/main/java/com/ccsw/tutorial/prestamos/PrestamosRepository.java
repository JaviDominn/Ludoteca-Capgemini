package com.ccsw.tutorial.prestamos;

import com.ccsw.tutorial.prestamos.model.Prestamos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio para la entidad Prestamos
 */
public interface PrestamosRepository extends CrudRepository<Prestamos, Long>, JpaSpecificationExecutor<Prestamos> {

    /**
     * Método para recuperar un listado paginado de {@link Prestamos}
     *
     * @param pageable información de paginación
     * @return {@link Page} de {@link Prestamos}
     */
    Page<Prestamos> findAll(Pageable pageable);

    /**
     * Comprueba si un juego ya está prestado en un rango de fechas
     */
    @Query("SELECT p FROM Prestamos p WHERE p.game.id = :gameId AND p.fechaDevolucion >= :inicio AND p.fechaPrestamo <= :fin")
    List<Prestamos> findByGameIdAndDateRangeOverlap(@Param("gameId") Long gameId, @Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    /**
     * Comprueba si un cliente tiene préstamos en un rango de fechas
     */
    @Query("SELECT p FROM Prestamos p WHERE p.clientes.id = :clienteId AND p.fechaDevolucion >= :inicio AND p.fechaPrestamo <= :fin")
    List<Prestamos> findByClienteIdAndDateRangeOverlap(@Param("clienteId") Long clienteId, @Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);
}
