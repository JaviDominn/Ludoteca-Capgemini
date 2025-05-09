package com.ccsw.tutorial.prestamos.model;

import com.ccsw.tutorial.common.pagination.PageableRequest;

import java.time.LocalDate;

public class PrestamosSearchDto {

    private PageableRequest pageable;
    private Long gameId;
    private Long clienteId;
    private LocalDate fecha;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
