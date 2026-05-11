import { Routes } from '@angular/router';
import { Voitures } from './voitures/voitures';

export const routes: Routes = [
  { path: 'voitures', component: Voitures },
  { path: '', redirectTo: '/voitures', pathMatch: 'full' }
];
