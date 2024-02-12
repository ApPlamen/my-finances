import { Injectable } from '@angular/core';
import { Validators } from '@angular/forms';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { CreateEditPaymentModel } from '../models/create-edit-payment.model';

@Injectable()
export class EditPaymentForm extends BaseFormModel<CreateEditPaymentModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      id: [null],
      description: ['', Validators.required],
      vendor: ['', Validators.required],
      amount: [0, [Validators.required, Validators.min(0)]],
      income: [null, Validators.required],
      paymentOption: [null, Validators.required]
    });
  }
}
