import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RolesEnum } from '../core/auth/enums/roles.enum';
import { canActivate } from '../shared/guards/auth.guard';
import { ChangeByDateComponent } from './components/statistics/change-by-date/change-by-date.component';
import { SpentByVendorComponent } from './components/statistics/spent-by-vendor/spent-by-vendor.component';
import { SpentByVendorByPaymentOptionComponent } from './components/statistics/spent-by-vendor-by-payment-option/spent-by-vendor-by-payment-option.component';
import { SpentByPaymentOptionComponent } from './components/statistics/spent-by-payment-option/spent-by-payment-option.component';
import { EarnedByMonthComponent } from './components/statistics/earned-by-month/earned-by-month.component';
import { SpentByMonthComponent } from './components/statistics/spent-by-month/spent-by-month.component';

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
  {
    path: 'spent-by-payment-option',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: SpentByPaymentOptionComponent,
  },
  {
    path: 'earned-by-month',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: EarnedByMonthComponent,
  },
  {
    path: 'spent-by-month',
    canActivate: [canActivate],
    data: { accessRoles: [RolesEnum.user] },
    component: SpentByMonthComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StatisticsRoutingModule { }
