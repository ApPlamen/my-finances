import {
    Component,
    Input,
    ChangeDetectorRef,
    Optional
} from "@angular/core";
import {
    NgbDateStruct,
    NgbPopoverConfig,
} from "@ng-bootstrap/ng-bootstrap";
import {
    NgControl
} from "@angular/forms";
import { DateTimeModel } from "../../models/date-time.model";
import { CustomControlDirective } from "../../services/base/custom-control.directive";
  
@Component({
    selector: "app-date-picker",
    templateUrl: "./date-picker.component.html",
  })
  export class DatePickerComponent extends CustomControlDirective {
    @Input() dateString: string;
    @Input() inputDatetimeFormat = "dd.MM.yyyy";
    @Input() type = 'text';
    @Input() label = '';
    @Input() placeholder = '';

    datetime: DateTimeModel = new DateTimeModel();

    constructor(@Optional() ngControl: NgControl, cd: ChangeDetectorRef, private config: NgbPopoverConfig) {
        super(ngControl, cd);
        config.autoClose = "outside";
        config.placement = "auto";
    }

    override writeValue(newModel: string) {
        if (newModel) {
            this.datetime = Object.assign(
                this.datetime,
                DateTimeModel.fromLocalString(newModel)
            );
            this.dateString = newModel;
            this.setDateStringModel();
        } else {
            this.datetime = new DateTimeModel();
        }
    }

    onDateChange($event: string | NgbDateStruct) {
        const date = new DateTimeModel($event);

        if (!date) {
            return;
        }

        if (!this.datetime) {
            this.datetime = date;
        }

        this.datetime.year = date.year;
        this.datetime.month = date.month;
        this.datetime.day = date.day;
        this.datetime.hour = 0;
        this.datetime.minute = 0;
        this.datetime.second = 0;

        const adjustedDate = new Date(this.datetime.toString());
        if (this.datetime.timeZoneOffset !== adjustedDate.getTimezoneOffset()) {
            this.datetime.timeZoneOffset = adjustedDate.getTimezoneOffset();
        }

        this.setDateStringModel();
    }

    setDateStringModel() {
        this.dateString = this.datetime.toString();

        if (this.dateString !== null) {
            this.onChange(this.dateString);
        }
    }

    public onBlur(event: Event): void {
        this.onTouch(event);
    }
}
