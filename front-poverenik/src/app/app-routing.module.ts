import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateResenjeComponent } from './resenje/create-resenje/create-resenje.component';

const routes: Routes = [
  { path: 'create-resenje', component: CreateResenjeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
