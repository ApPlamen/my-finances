import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../../services/statistics.service';

@Component({
  templateUrl: './test.component.html',
})
export class TestComponent implements OnInit {
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

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit(): void {
    this.statisticsService.getTest()
      .subscribe(multi => this.multi = multi);
  }
}
