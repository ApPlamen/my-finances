import {
    Component,
    Input,
    ChangeDetectorRef,
    Optional
} from "@angular/core";
import {
    NgbTimeStruct,
    NgbDateStruct,
    NgbPopoverConfig,
} from "@ng-bootstrap/ng-bootstrap";
import {
    NgControl
} from "@angular/forms";
import { DateTimeModel } from "../../models/date-time.model";
import { CustomControlDirective } from "../../services/base/custom-control.directive";
  
@Component({
    selector: "app-date-time-picker",
    templateUrl: "./date-time-picker.component.html",
  })
  export class DateTimePickerComponent extends CustomControlDirective {
    @Input() dateString: string;
    @Input() inputDatetimeFormat = "dd.MM.yyyy HH:mm:ss";
    @Input() hourStep = 1;
    @Input() minuteStep = 15;
    @Input() secondStep = 30;
    @Input() seconds = true;
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
            this.dateString = this.dateString;
            return;
        }

        if (!this.datetime) {
            this.datetime = date;
        }

        this.datetime.year = date.year;
        this.datetime.month = date.month;
        this.datetime.day = date.day;

        const adjustedDate = new Date(this.datetime.toString());
        if (this.datetime.timeZoneOffset !== adjustedDate.getTimezoneOffset()) {
            this.datetime.timeZoneOffset = adjustedDate.getTimezoneOffset();
        }

        this.setDateStringModel();
    }

    onTimeChange(event: NgbTimeStruct) {
        this.datetime.hour = event.hour;
        this.datetime.minute = event.minute;
        this.datetime.second = event.second;

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
