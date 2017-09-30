import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  @Output() featureSelected = new EventEmitter<string>();
  menuItems:{name:string,localName:string}[] = [];

  inputItem = {name: "inputTasks", localName: "Входящие задачи"};
  outputItem = {name: "outputTasks", localName: 'Исходящие задачи'};
  taskStatusItem = {name: 'taskStatusItem', localName: "Статус выполнения"};
  groups = {name: 'groups', localName: "Группы"};
  projects = {name: 'projects', localName: "Проекты"};
  goals = {name: 'goals', localName: "Цели"};
  reports = {name: 'reports', localName: "Отчет"};

  loadItems() {
    this.menuItems.push(this.inputItem);
    this.menuItems.push(this.outputItem);
    this.menuItems.push(this.taskStatusItem);
    this.menuItems.push(this.groups);
    this.menuItems.push(this.projects);
    this.menuItems.push(this.goals);
    this.menuItems.push(this.reports);
  }

  onSelectItem(feature){
    this.featureSelected.emit(feature);
  }

  constructor() {
    this.loadItems();
  }

  ngOnInit() {
    this.featureSelected.emit('inputTasks')
  }

}
