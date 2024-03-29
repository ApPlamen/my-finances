import { Component, OnInit } from '@angular/core';
import { StatisticsService } from '../../../services/statistics.service';
import { KeyValuePair } from '../../../viewmodels/key-value-pair.viewmodel';
import { SpentByCategoryFilterModel } from 'src/app/statistics/models/spent-by-category-filter.model';

@Component({
  templateUrl: './spent-by-category.component.html',
})
export class SpentByCategoryComponent implements OnInit {
  multi: KeyValuePair[];

  // options
  gradient: boolean = true;
  showLegend: boolean = true;
  showLabels: boolean = true;
  isDoughnut: boolean = false;

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit(): void {
    this.fillData();
  }

  filter(value: SpentByCategoryFilterModel) {
    this.fillData(value);
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

  private fillData(value: SpentByCategoryFilterModel = new SpentByCategoryFilterModel()): void {
    this.statisticsService.getSpentByCategory(value)
      .subscribe(multi => this.multi = multi);
  }
}
