import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthorListComponent } from './author/author-list/author-list.component';
import { CategoryListComponent } from './category/category-list/category-list.component';
import { GameListComponent } from './game/game-list/game-list.component';
import { ClientesListComponent } from './clientes/clientes-list/clientes-list.component';
import { PrestamosListComponent } from './prestamos/prestamos-list/prestamos-list.component';


const routes: Routes = [
    { path: '', redirectTo: '/games', pathMatch: 'full'},
    { path: 'categories', component: CategoryListComponent },
    { path: 'authors', component: AuthorListComponent },
    { path: 'games', component: GameListComponent },
    { path: 'clientes', component: ClientesListComponent },
    { path: 'prestamos', component: PrestamosListComponent } 
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }