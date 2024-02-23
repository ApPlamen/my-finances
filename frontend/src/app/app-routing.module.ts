import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StatisticsComponent } from './statistics/statistics.component';

const routes: Routes = [
  {
    path: 'users',
    loadChildren: () => import('./users/users.module').then(m => m.UsersModule),
  },
  {
    path: 'finances',
    loadChildren: () => import('./finances/finances.module').then(m => m.FinancesModule),
  },
  {
    path: 'statistics',
    component: StatisticsComponent,
    loadChildren: () => import('./statistics/statistics.module').then(m => m.StatisticsModule),
  },
  {
    path: '',
    loadChildren: () => import('./home/home.module').then(m => m.HomeModule),
  },
  {
    path: '',
    loadChildren: () => import('./core/core.module').then(m => m.CoreModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
