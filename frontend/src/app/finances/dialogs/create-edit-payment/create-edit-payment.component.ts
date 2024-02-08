import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { PaymentsService } from '../../services/payments.service';
import { FinancesStoreService } from '../../store/finances.store.service';
import { PaymentForm } from '../../forms/payment.form';

@Component({
  templateUrl: './create-edit-payment.component.html',
})
export class CreateEditPaymentComponent implements OnInit {
  _isNew = true;
  paymentForm: PaymentForm = new PaymentForm();

  constructor(private paymentsService: PaymentsService,
              private financesStoreService: FinancesStoreService,
              private activeModalService: NgbActiveModal,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.financesStoreService.getPaymentId$.subscribe(
      paymentId => {
        if ( paymentId ) {
          this.isNew = false;
          this.paymentsService.getEditPayment(paymentId)
            .subscribe( payment => this.paymentForm.setModel(payment) );
        } else {
          this.isNew = true;
        }
      }
    );
  }

  onSubmit(): void {
    if (this.paymentForm.formGroup.valid) {
      this.paymentsService.savePayment(this.paymentForm.formGroup.value)
        .subscribe(() => {
          this.toastr.success('Success!');
          this.activeModalService.close();
        });
    }
  }

  get isNew(): boolean {
    return this._isNew;
  }
  set isNew(value) {
    this._isNew = value;
  }
}
