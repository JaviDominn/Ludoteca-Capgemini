import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PrestamosService } from '../prestamos.service';
import { Prestamos } from '../model/Prestamos';
import { ClientesService } from 'src/app/clientes/clientes.service';
import { GameService } from 'src/app/game/game.service';

@Component({
  selector: 'app-prestamos-edit',
  templateUrl: './prestamos-edit.component.html',
  styleUrls: ['./prestamos-edit.component.scss']
})
export class PrestamosEditComponent implements OnInit {

  prestamo: Prestamos;
  clientes: any[] = [];
  juegos: any[] = [];

  constructor(
    public dialogRef: MatDialogRef<PrestamosEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private prestamosService: PrestamosService,
    private clientesService: ClientesService,
    private gameService: GameService
  ) { }

  ngOnInit(): void {
    this.prestamo = this.data.prestamo ? { ...this.data.prestamo } : new Prestamos();

    this.loadClientes();
    this.loadJuegos();
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

  onSave() {

    
    // Validaciones
    if (this.prestamo.fechaDevolucion < this.prestamo.fechaPrestamo) {
      alert("La fecha de devolución no puede ser anterior a la fecha de préstamo.");
      return;
    }

    if (this.prestamo.fechaPrestamo && this.prestamo.fechaDevolucion) {
      const diffDays = Math.ceil((this.prestamo.fechaDevolucion.getTime() - this.prestamo.fechaPrestamo.getTime()) / (1000 * 3600 * 24));
      if (diffDays > 14) {
        alert("La duración del préstamo no puede superar los 14 días.");
        return;
      }
    }


    console.log('Préstamo guardado exitosamente:', this.prestamo);
    this.prestamosService.savePrestamo(this.prestamo).subscribe({
      next: () => {
        
        this.dialogRef.close();
      }
    });

  }

  onClose() {
    this.dialogRef.close();
  }
}
