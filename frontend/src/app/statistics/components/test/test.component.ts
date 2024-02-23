import { Component } from '@angular/core';
import { multi } from './data';

@Component({
  templateUrl: './test.component.html',
})
export class TestComponent {
  multi: any[];

  // options
  legend: boolean = false;
  showLabels: boolean = true;
  animations: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  showYAxisLabel: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Date';
  yAxisLabel: string = 'Amount';
  timeline: boolean = true;

  constructor() {
    Object.assign(this, { multi });
  }
}
