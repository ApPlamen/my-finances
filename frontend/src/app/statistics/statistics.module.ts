import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
import { StatisticsRoutingModule } from './statistics-routing.module';
import { StatisticsComponent } from './statistics.component';
import { ChangeByDateComponent } from './components/statistics/change-by-date/change-by-date.component';
import { StatisticsNavbarComponent } from './components/statistics-navbar/statistics-navbar.component';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { ChangeByDateFilterComponent } from './components/filters/payments-board-filter/change-by-date-filter.component';
import { SpentByVendorComponent } from './components/statistics/spent-by-vendor/spent-by-vendor.component';
import { SpentByVendorFilterComponent } from './components/filters/spent-by-vendor-filter/spent-by-vendor-filter.component';
import { SpentByVendorByPaymentOptionComponent } from './components/statistics/spent-by-vendor-by-payment-option/spent-by-vendor-by-payment-option.component';
import { SpentByVendorByPaymentOptionFilterComponent } from './components/filters/spent-by-vendor-by-payment-option-filter/spent-by-vendor-by-payment-option-filter.component';
import { SpentByPaymentOptionComponent } from './components/statistics/spent-by-payment-option/spent-by-payment-option.component';
import { SpentByPaymentOptionFilterComponent } from './components/filters/spent-by-payment-option-filter/spent-by-payment-option-filter.component';
import { EarnedByMonthComponent } from './components/statistics/earned-by-month/earned-by-month.component';
import { SpentByMonthComponent } from './components/statistics/spent-by-month/spent-by-month.component';

@NgModule({
  declarations: [
    StatisticsComponent,
    StatisticsNavbarComponent,
    ChangeByDateComponent,
    ChangeByDateFilterComponent,
    SpentByVendorComponent,
    SpentByVendorFilterComponent,
    SpentByVendorByPaymentOptionComponent,
    SpentByVendorByPaymentOptionFilterComponent,
    SpentByPaymentOptionComponent,
    SpentByPaymentOptionFilterComponent,
    EarnedByMonthComponent,
    SpentByMonthComponent
  ],
  imports: [
    CommonModule,
    StatisticsRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    NgxChartsModule,
  ],
  exports: [
  ],
  providers: [
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class StatisticsModule {}
