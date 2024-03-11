import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../../../services/statistics.service';
import { ListOfKeyValuePairs } from '../../../viewmodels/list-of-key-value-pairs.viewmodel';

@Component({
  templateUrl: './spent-by-month-by-category.component.html',
})
export class SpentByMonthByCategoryComponent implements OnInit {
  multi: ListOfKeyValuePairs[];

  // options
  showXAxis: boolean = true;
  showYAxis: boolean = true;
  gradient: boolean = false;
  showLegend: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Month';
  showYAxisLabel: boolean = true;
  animations: boolean = true;
  legendTitle: string = 'Payment category';

  yAxisLabelAmount: string = 'Amount';
  yAxisLabelPercentage: string = 'Percentage';

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit(): void {
    this.fillData();
  }

  openTab(tab: string, tabContent: string) {
    let tabs = document.getElementsByClassName("nav-link");
    for (let i = 0; i < tabs.length; i++) {
      tabs.item(i).classList.remove("active");
    }
    document.getElementById(tab).classList.add("active");

    let tabcontent = document.getElementsByClassName("tab-pane");
    for (let i = 0; i < tabcontent.length; i++) {
      tabcontent.item(i).classList.remove("show", "active");
    }
    document.getElementById(tabContent).classList.add("show", "active");
  }

  private fillData(): void {
    this.statisticsService.getSpentByMonthByCategory()
      .subscribe(multi => this.multi = multi);
  }
}
