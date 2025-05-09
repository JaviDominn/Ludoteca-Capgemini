package com.ccsw.tutorial.prestamos.model;

import java.time.LocalDate;

public class PrestamosDto {

    private Long id;

    private Long gameId;
    private String gameTitle;

    private Long clientesId;
    private String clientesName;

    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Long getClientesId() {
        return clientesId;
    }

    public void setClientesId(Long clientesId) {
        this.clientesId = clientesId;
    }

    public String getClientesName() {
        return clientesName;
    }

    public void setClientesName(String clientesName) {
        this.clientesName = clientesName;
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
