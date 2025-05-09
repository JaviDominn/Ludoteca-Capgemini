import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { DialogConfirmationComponent } from 'src/app/core/dialog-confirmation/dialog-confirmation.component';
import { Pageable } from 'src/app/core/model/page/Pageable';
import { PrestamosEditComponent } from '../prestamos-edit/prestamos-edit.component';
import { PrestamosService } from '../prestamos.service';
import { Prestamos } from '../model/Prestamos';
import { ClientesService } from 'src/app/clientes/clientes.service';
import { GameService } from 'src/app/game/game.service';

@Component({
  selector: 'app-prestamos-list',
  templateUrl: './prestamos-list.component.html',
  styleUrls: ['./prestamos-list.component.scss']
})
export class PrestamosListComponent implements OnInit {

  pageNumber: number = 0;
  pageSize: number = 5;
  totalElements: number = 0;

  dataSource = new MatTableDataSource<Prestamos>();
  displayedColumns: string[] = ['id', 'gameTitle', 'clientesName', 'fechaPrestamo', 'fechaDevolucion', 'action'];

  // Filtros
  gameId: number | null = null;
  clienteId: number | null = null;
  fecha: Date | null = null;

  clientes: any[] = [];
  juegos: any[] = [];

  constructor(
    private prestamosService: PrestamosService,
    private clientesService: ClientesService,
    private gameService: GameService,
    public dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.loadPage();
    this.loadClientes();
    this.loadJuegos();
  }

  loadPage(event?: PageEvent) {
    let pageable: Pageable = {
      pageNumber: this.pageNumber,
      pageSize: this.pageSize,
      sort: [{
        property: 'id',
        direction: 'ASC'
      }]
    };

    if (event != null) {
      pageable.pageSize = event.pageSize;
      pageable.pageNumber = event.pageIndex;
    }

    this.prestamosService.getPrestamos(pageable, this.gameId, this.clienteId, this.fecha).subscribe(data => {
      this.dataSource.data = data.content;
      this.pageNumber = data.pageable.pageNumber;
      this.pageSize = data.pageable.pageSize;
      this.totalElements = data.totalElements;
    });
  }

  createPrestamo() {
    const dialogRef = this.dialog.open(PrestamosEditComponent, {
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

  deletePrestamo(prestamo: Prestamos) {
    const dialogRef = this.dialog.open(DialogConfirmationComponent, {
      data: {
        title: "Eliminar préstamo",
        description: "¿Está seguro de que desea eliminar este préstamo?"
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.prestamosService.deletePrestamo(prestamo.id).subscribe(() => {
          this.ngOnInit();
        });
      }
    });
  }

  // Métodos para aplicar filtros
  applyFilters() {
    this.loadPage();
  }

  clearFilters() {
    this.gameId = null;
    this.clienteId = null;
    this.fecha = null;
    this.loadPage();
  }

  loadClientes() {
    this.clientesService.getClientes().subscribe(data => {
      this.clientes = data;
    });
  }

  loadJuegos() {
    this.gameService.getGames().subscribe(data => {
      this.juegos = data;
    });
  }
}
