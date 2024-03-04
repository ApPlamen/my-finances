import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FileUploadConsoleComponent } from './components/file-upload-console/file-upload-console.component';
import { FileUploadRoutingModule } from './file-upload-routing.module';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    FileUploadConsoleComponent,
  ],
  imports: [
    FileUploadRoutingModule,
    SharedModule,
  ],
  exports: [
  ],
  providers: [
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class FileUploadModule {}
