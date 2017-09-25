import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  sideBarMenuItems = [
    'Входящие задачи',
    'Исходящие задачи',
    'Статус выполнения',
    'Группы',
    'Проекты',
    'Цели',
    'Отчет'
  ];

  constructor() { }

  ngOnInit() {
  }

}
