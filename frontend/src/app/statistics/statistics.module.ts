import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
import { StatisticsRoutingModule } from './statistics-routing.module';
import { StatisticsComponent } from './statistics.component';
import { TestComponent } from './components/test/test.component';
import { StatisticsNavbarComponent } from './components/statistics-navbar/statistics-navbar.component';
import { NgxChartsModule } from '@swimlane/ngx-charts';

@NgModule({
  declarations: [
    StatisticsComponent,
    StatisticsNavbarComponent,
    TestComponent
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
