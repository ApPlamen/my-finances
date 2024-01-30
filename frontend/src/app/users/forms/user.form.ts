import { Injectable } from '@angular/core';
import { Validators } from '@angular/forms';
import { BaseFormModel } from 'src/app/shared/models/base-form.model';
import { CreateEditUserModel } from '../models/create-edit-user.model';

@Injectable()
export class UserForm extends BaseFormModel<CreateEditUserModel> {
  constructor() {
    super();

    this.formGroup = this.formBuilder.group({
      id: [null],
      userName: ['', Validators.required],
      fullName: ['', Validators.required],
      newPassword: ['', Validators.minLength(6)],
    });
  }
}
