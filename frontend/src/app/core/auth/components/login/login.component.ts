import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';
import { LogInForm } from '../../forms/login.form';
import { AuthService } from '../../services/auth.service';

@Component({
  templateUrl: './login.component.html',
})
export class LogInComponent {
  logInForm: LogInForm = new LogInForm();

  constructor(private authService: AuthService,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private toastr: ToastrService) { }

  onSubmit(): void {
    if (this.logInForm.formGroup.valid) {
      this.authService.login(this.logInForm.formGroup.value).subscribe(
        data => {
          this.tokenStorageService.saveToken(data.token);
          this.tokenStorageService.saveUser(data);

          this.toastr.success('Success!');

          this.router.navigate(['/home']);
        },
      );
    }
  }

  get isLoggedIn(): boolean {
    return this.tokenStorageService.isUserLoggedIn();
  }

  get userName(): string {
    return this.tokenStorageService.getUser().userName;
  }
}
