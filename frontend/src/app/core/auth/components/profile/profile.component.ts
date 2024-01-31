import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ProfileForm } from '../../forms/profile.form';
import { ProfileService } from '../../services/profile.service';

@Component({
  templateUrl: './profile.component.html',
})
export class ProfileComponent implements OnInit {
  profileForm: ProfileForm = new ProfileForm();

  constructor(private profileService: ProfileService,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.fillForm();
  }

  onSubmit(): void {
    if (this.profileForm.formGroup.valid) {
      this.profileService.saveUserProfile(this.profileForm.formGroup.value)
        .subscribe(() => {
          this.fillForm();

          this.toastr.success('Success!');
        });
    }
  }

  private fillForm(): void {
    this.profileService.getUserProfile()
      .subscribe(profile => this.profileForm.setModel(profile));
  }

  get userName(): string {
    return this.profileForm.model.userName
  }
}
