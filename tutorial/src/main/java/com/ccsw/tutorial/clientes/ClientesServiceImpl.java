package com.ccsw.tutorial.clientes;

import com.ccsw.tutorial.clientes.model.Clientes;
import com.ccsw.tutorial.clientes.model.ClientesDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ccsw
 *
 */
@Service
@Transactional
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    ClientesRepository clientesRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Clientes get(Long id) {

        return this.clientesRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Clientes> findAll() {

        return (List<Clientes>) this.clientesRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, ClientesDto dto) throws Exception {

        Clientes clientes;

        if (id == null) {
            clientes = new Clientes();
        } else {
            clientes = this.get(id);
        }

        // Verificar si el nombre ya existe en la base de datos
        if (this.clientesRepository.existsByName(dto.getName())) {
            throw new Exception("El cliente con el nombre " + dto.getName() + " ya existe.");
        }

        clientes.setName(dto.getName());

        this.clientesRepository.save(clientes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) throws Exception {

        if (this.get(id) == null) {
            throw new Exception("Not exists");
        }

        this.clientesRepository.deleteById(id);
    }

}
