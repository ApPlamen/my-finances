import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';
import { RegisterForm } from '../../forms/register.form';
import { AuthService } from '../../services/auth.service';

@Component({
  templateUrl: './register.component.html',
})
export class RegisterComponent {
  registerForm: RegisterForm = new RegisterForm();

  constructor(private authService: AuthService,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private toastr: ToastrService) { }

  onSubmit(): void {
    if (this.registerForm.formGroup.valid) {
      this.authService.register(this.registerForm.model)
        .subscribe(() => {
          this.toastr.success('Success!');

          this.router.navigate(['/login']);
        });
    }
  }

  get isLoggedIn(): boolean {
    return this.tokenStorageService.isUserLoggedIn();
  }

  get userName(): string {
    return this.tokenStorageService.getUser().userName;
  }
}
