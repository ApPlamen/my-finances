import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RolesEnum } from '../core/auth/enums/roles.enum';
import { BoardUsersComponent } from './components/board-users/board-users.component';
import { canActivate } from '../shared/guards/auth.guard';

const routes: Routes = [
  {
    path: '',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.admin] },
    component: BoardUsersComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule { }
