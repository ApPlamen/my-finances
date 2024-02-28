import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../../services/statistics.service';
import { ChangeByDateFilterModel } from '../../models/change-by-date-filter.model';
import { multi } from './data';

@Component({
  templateUrl: './spent-by-vendor.component.html',
})
export class SpentByVendorComponent implements OnInit {
  multi: any[];

  // options
  gradient: boolean = true;
  showLegend: boolean = true;
  showLabels: boolean = true;
  isDoughnut: boolean = false;

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit(): void {
    this.fillData();
  }

  filter(value: ChangeByDateFilterModel) {
    // this.fillData(value);
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

  private fillData(value: ChangeByDateFilterModel = new ChangeByDateFilterModel()): void {
    // this.statisticsService.getChangeByDate(value)
    //   .subscribe(multi => this.multi = multi);
    Object.assign(this, { multi });
  }
}
