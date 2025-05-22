package com.ccsw.tutorial.prestamos;

import com.ccsw.tutorial.clientes.ClientesRepository;
import com.ccsw.tutorial.clientes.model.Clientes;
import com.ccsw.tutorial.game.GameRepository;
import com.ccsw.tutorial.game.model.Game;
import com.ccsw.tutorial.prestamos.model.Prestamos;
import com.ccsw.tutorial.prestamos.model.PrestamosDto;
import com.ccsw.tutorial.prestamos.model.PrestamosSearchDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PrestamosServiceImpl implements PrestamosService {

    @Autowired
    PrestamosRepository prestamosRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ClientesRepository clientesRepository;

    @Override
    public Prestamos get(Long id) {
        return this.prestamosRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Prestamos> findPage(PrestamosSearchDto dto) {

        Sort.Direction direction = Sort.Direction.ASC;
        String property = "id";

        if (dto.getPageable().getSort() != null && !dto.getPageable().getSort().isEmpty()) {
            var sortOrder = dto.getPageable().getSort().get(0);
            if (sortOrder.getDirection() != null) {
                direction = sortOrder.getDirection();
            }
            if (sortOrder.getProperty() != null && !sortOrder.getProperty().isEmpty()) {
                property = sortOrder.getProperty();
            }
        }

        Pageable pageable = PageRequest.of(dto.getPageable().getPageNumber(), dto.getPageable().getPageSize(), Sort.by(direction, property));

        Specification<Prestamos> spec = (Root<Prestamos> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getGameId() != null) {
                predicates.add(cb.equal(root.get("game").get("id"), dto.getGameId()));
            }

            if (dto.getClienteId() != null) {
                predicates.add(cb.equal(root.get("clientes").get("id"), dto.getClienteId()));
            }

            if (dto.getFecha() != null) {
                Predicate fechaInicio = cb.lessThanOrEqualTo(root.get("fechaPrestamo"), dto.getFecha());
                Predicate fechaFin = cb.greaterThanOrEqualTo(root.get("fechaDevolucion"), dto.getFecha());
                predicates.add(cb.and(fechaInicio, fechaFin));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        return prestamosRepository.findAll(spec, pageable);
    }

    @Override
    public void save(Long id, PrestamosDto data) {

        // Guardar o actualizar el préstamo
        Prestamos prestamos = (id == null) ? new Prestamos() : this.get(id);

        Game game = gameRepository.findById(data.getGameId()).orElse(null);
        Clientes clientes = clientesRepository.findById(data.getClientesId()).orElse(null);

        prestamos.setGame(game);
        prestamos.setCliente(clientes);
        prestamos.setFechaPrestamo(data.getFechaPrestamo());
        prestamos.setFechaDevolucion(data.getFechaDevolucion());

        this.prestamosRepository.save(prestamos);
    }

    @Override
    public void delete(Long id) throws Exception {
        if (this.get(id) == null) {
            throw new Exception("No existe el préstamo con ID: " + id);
        }

        this.prestamosRepository.deleteById(id);
    }
}
