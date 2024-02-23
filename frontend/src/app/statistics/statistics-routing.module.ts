import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RolesEnum } from '../core/auth/enums/roles.enum';
import { canActivate } from '../shared/guards/auth.guard';
import { TestComponent } from './components/test/test.component';

const routes: Routes = [
  {
    path: '',
    // canActivate: [canActivate],
    // data: { accessRoles: [RolesEnum.user] },
    component: TestComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StatisticsRoutingModule { }
