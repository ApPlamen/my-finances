import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { PaymentsService } from '../../services/payments.service';
import { FinancesStoreService } from '../../store/finances.store.service';
import { EditPaymentForm } from '../../forms/edit-payment.form';
import { Dropdown } from 'src/app/shared/models/dropdown.model';
import { PaymentOptionsService } from '../../services/payment-options.service';
import { PaymentCategoriesService } from '../../services/payment-categories.service';

@Component({
  templateUrl: './create-edit-payment.component.html',
})
export class CreateEditPaymentComponent implements OnInit {
  _isNew = true;
  paymentForm: EditPaymentForm = new EditPaymentForm();
  incomeTypes: Dropdown[];
  paymentOptions: Dropdown[];
  paymentCategories: Dropdown[];

  constructor(private paymentsService: PaymentsService,
              private paymentOptionsService: PaymentOptionsService,
              private paymentCategoriesService: PaymentCategoriesService,
              private financesStoreService: FinancesStoreService,
              private activeModalService: NgbActiveModal,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.incomeTypes = [{value: true, displayValue: "Income"}, {value: false, displayValue: "Expense"}];

    this.paymentOptionsService.getPaymentOptionsOptions()
      .subscribe(paymentOptions => this.paymentOptions = paymentOptions);

    this.paymentCategoriesService.getPaymentCategoriesOptions()
      .subscribe(paymentCategories => this.paymentCategories = paymentCategories);

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
      this.paymentsService.saveEditPayment(this.paymentForm.formGroup.value)
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
