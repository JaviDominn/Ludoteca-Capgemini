package com.ccsw.tutorial.clientes;

import com.ccsw.tutorial.clientes.model.Clientes;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ccsw
 *
 */
public interface ClientesRepository extends CrudRepository<Clientes, Long> {

    boolean existsByName(String name);
}
