import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RolesEnum } from '../core/auth/enums/roles.enum';
import { canActivate } from '../shared/guards/auth.guard';
import { FileUploadConsoleComponent } from './components/file-upload-console/file-upload-console.component';

const routes: Routes = [
  {
    path: '',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: FileUploadConsoleComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FileUploadRoutingModule { }
