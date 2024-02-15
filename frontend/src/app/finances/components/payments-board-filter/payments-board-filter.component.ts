import { Component } from '@angular/core';
import { PaymentsBoardFilterForm } from '../../forms/payments-board-filter.form';

@Component({
  selector: 'app-payments-board-filter',
  templateUrl: './payments-board-filter.component.html',
})
export class PaymentsBoardFilterComponent {
  paymentsBoardFilterForm: PaymentsBoardFilterForm = new PaymentsBoardFilterForm();

  constructor() { }

  onSubmit(): void {
    // if (this.paymentForm.formGroup.valid) {
    //   this.paymentsService.saveEditPayment(this.paymentForm.formGroup.value)
    //     .subscribe(() => {
    //       this.toastr.success('Success!');
    //       this.activeModalService.close();
    //     });
    // }
  }
}
