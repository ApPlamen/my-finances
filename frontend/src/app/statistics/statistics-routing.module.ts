import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RolesEnum } from '../core/auth/enums/roles.enum';
import { canActivate } from '../shared/guards/auth.guard';
import { ChangeByDateComponent } from './components/change-by-date/change-by-date.component';
import { SpentByVendorComponent } from './components/spent-by-vendor/spent-by-vendor.component';
import { SpentByVendorByPaymentOptionComponent } from './components/spent-by-vendor-by-payment-option/spent-by-vendor-by-payment-option.component';

const routes: Routes = [
  {
    path: 'change-by-date',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: ChangeByDateComponent,
  },
  {
    path: 'spent-by-vendor',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: SpentByVendorComponent,
  },
  {
    path: 'spent-by-vendor-by-payment-option',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: SpentByVendorByPaymentOptionComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StatisticsRoutingModule { }
