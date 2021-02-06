import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateResenjeComponent } from './resenje/create-resenje/create-resenje.component';
import { DashboardComponent } from './core/dashboard/dashboard.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'create-resenje', component: CreateResenjeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
