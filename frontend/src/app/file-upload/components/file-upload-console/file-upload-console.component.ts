import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Component({
  templateUrl: './file-upload-console.component.html',
})
export class FileUploadConsoleComponent {
  buttonLabel: string = "upload";
  isDisabled : boolean = false;

  constructor(private toastr: ToastrService) { }


  upload(): void {
    this.buttonLabel = "uploading";
    this.isDisabled = true;
    setTimeout(() => this.uploadSuccess(), 2 * 1000);
  }

  uploadSuccess() {
    this.toastr.success('Success!');
    this.buttonLabel = "upload";
    this.isDisabled = false;
  }
}
