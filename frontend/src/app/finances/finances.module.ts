import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared/shared.module';
// import { StoreModule } from '@ngrx/store';
import { FinancesRoutingModule } from './finances-routing.module';
import { BoardPaymentsComponent } from './components/board-payments/board-payments.component';

@NgModule({
  declarations: [
    BoardPaymentsComponent,
  ],
  imports: [
    CommonModule,
    FinancesRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    SharedModule,
    // StoreModule.forFeature('finances', financesRecuder),
  ],
  exports: [
  ],
  providers: [
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class FinancesModule {}
