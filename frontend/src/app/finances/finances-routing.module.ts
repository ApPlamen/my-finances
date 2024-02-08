import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RolesEnum } from '../core/auth/enums/roles.enum';
import { canActivate } from '../shared/guards/auth.guard';
import { BoardPaymentsComponent } from './components/board-payments/board-payments.component';

const routes: Routes = [
  {
    path: '',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: BoardPaymentsComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FinancesRoutingModule { }
