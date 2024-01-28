import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { LogInComponent } from './components/login/login.component';
import { LogOutComponent } from './components/logout/logout.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { RolesEnum } from './enums/roles.enum';
import { canActivate } from 'src/app/shared/guards/auth.guard';

const routes: Routes = [
  { path: 'login', component: LogInComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'logout',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: LogOutComponent
  },
  {
    path: 'profile',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: ProfileComponent
  },
  {
    path: 'change-password',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: ChangePasswordComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
