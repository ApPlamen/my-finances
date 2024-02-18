import { Component } from '@angular/core';
import { RolesFilteringBaseClass } from '../../base-classes/roles-filtering.class';
import { TokenStorageService } from '../../services/token-storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
})
export class NavbarComponent extends RolesFilteringBaseClass {
  constructor(protected override tokenStorageService: TokenStorageService) {
    super(tokenStorageService);
  }
}
