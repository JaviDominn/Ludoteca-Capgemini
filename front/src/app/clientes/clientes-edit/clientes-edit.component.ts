import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ClientesService } from '../clientes.service';
import { Clientes } from '../model/Clientes';

@Component({
  selector: 'app-clientes-edit',
  templateUrl: './clientes-edit.component.html',
  styleUrls: ['./clientes-edit.component.scss']
})
export class ClientesEditComponent implements OnInit {

  clientes : Clientes;

  constructor(
    public dialogRef: MatDialogRef<ClientesEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private clientesService: ClientesService
  ) { }

  ngOnInit(): void {
    if (this.data.clientes != null) {
      this.clientes = Object.assign({}, this.data.clientes);
    }
    else {
      this.clientes = new Clientes();
    }
  }

  onSave() {
    if (this.clientes.name == '' || !this.clientes.name) {
            alert("El nombre del cliente no puede estar vacío.");
            return;
        }
    this.clientesService.saveClientes(this.clientes).subscribe(
        result => {
            this.dialogRef.close();
        },
        error => {
            if (error.status === 409) {
                alert("El nombre es repetido"); 
            }
        }
    );
  }


  onClose() {
    this.dialogRef.close();
  }

}