import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements OnInit {
  public zalbe = Array(3).fill({});
  public resenja = Array(3).fill({});
  public izvestaji = Array(3).fill({});

  constructor() {}

  ngOnInit(): void {}
}
