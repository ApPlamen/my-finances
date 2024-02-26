import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RolesEnum } from '../core/auth/enums/roles.enum';
import { canActivate } from '../shared/guards/auth.guard';
import { ChangeByDateComponent } from './components/change-by-date/change-by-date.component';

const routes: Routes = [
  {
    path: 'change-by-date',
    // canActivate: [canActivate],
    // data: { accessRoles: [RolesEnum.user] },
    component: ChangeByDateComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StatisticsRoutingModule { }
