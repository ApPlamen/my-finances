import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ChangePasswordForm } from '../../forms/change-password.form';
import { ProfileService } from '../../services/profile.service';

@Component({
  templateUrl: './change-password.component.html',
})
export class ChangePasswordComponent {
  changePasswordForm: ChangePasswordForm = new ChangePasswordForm();

  constructor(private profileService: ProfileService,
              private toastr: ToastrService) { }

  onSubmit(): void {
    if (this.changePasswordForm.formGroup.valid) {
      this.profileService.changePasswordUser(this.changePasswordForm.formGroup.value)
        .subscribe(_ => {
          this.changePasswordForm.clear();

          this.toastr.success('Success!');
        });
    }
  }
}
