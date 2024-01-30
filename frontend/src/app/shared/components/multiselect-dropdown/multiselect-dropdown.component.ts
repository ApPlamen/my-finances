import { Component, Input } from '@angular/core';
import { MultiselectDropdown } from '../../models/multiselect-dropdown.model';
import { CustomControlDirective } from '../../services/base/custom-control.directive';

@Component({
    selector: 'tmc-multiselect-dropdown',
    templateUrl: './multiselect-dropdown.component.html',
    styleUrl: './multiselect-dropdown.component.css',
  })
  export class MultiselectDropdownComponent extends CustomControlDirective {
    @Input() items: MultiselectDropdown[];
    @Input() menuHidden: boolean = true;
    @Input() label = '';

    checkboxStatusChange(newValue: any): void {
        if(this.value.includes(newValue)) {
            this.value = this.value.filter((i: any) => i != newValue)
        }
        else {
            this.value.push(newValue);
        }
    }

    toggleCheckboxArea(): void {
        this.menuHidden = !this.menuHidden;
    }

    get isMenuHidden() {
        return this.menuHidden ? 'none' : 'block'
    }

    get getSelectedItems() {
        return this.items.filter(item => this.value.includes(item.value));
    }

    get getSelectedItemsDisplayValue() {
        var selectedItems = this.getSelectedItems.flatMap(i => i.displayValue).join(", ");
        return selectedItems ? selectedItems : "No option has been selected";
    }

    isItemChecked(value: any) {
        return this.value.includes(value);
    }
  }
  