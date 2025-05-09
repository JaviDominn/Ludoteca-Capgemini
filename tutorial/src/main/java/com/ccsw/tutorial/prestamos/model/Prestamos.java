package com.ccsw.tutorial.prestamos.model;

import com.ccsw.tutorial.clientes.model.Clientes;
import com.ccsw.tutorial.game.model.Game;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entidad que representa un préstamo de un juego a un cliente.
 */
@Entity
@Table(name = "prestamos")
public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "juego_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes clientes;

    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion", nullable = false)
    private LocalDate fechaDevolucion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setCliente(Clientes clientes) {
        this.clientes = clientes;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}

