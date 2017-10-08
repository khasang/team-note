import {EventEmitter, Injectable} from "@angular/core";

@Injectable()
export class SidebarService {
  inputItem = {name: "inputTasks", localName: "Входящие задачи"};
  outputItem = {name: "outputTasks", localName: 'Исходящие задачи'};
  taskStatusItem = {name: 'taskStatusItem', localName: "Статус выполнения"};
  groups = {name: 'groups', localName: "Группы"};
  projects = {name: 'projects', localName: "Проекты"};
  goals = {name: 'goals', localName: "Цели"};
  reports = {name: 'reports', localName: "Отчет"};

  selectItemEmitter = new EventEmitter<string>();
  menuItems: { name: string, localName: string }[] = [];
  itemSelected: { name: string, localName: string };

  loadItems() {
    this.menuItems.push(this.inputItem);
    this.menuItems.push(this.outputItem);
    this.menuItems.push(this.taskStatusItem);
    this.menuItems.push(this.groups);
    this.menuItems.push(this.projects);
    this.menuItems.push(this.goals);
    this.menuItems.push(this.reports);
  }

  constructor() {
    this.loadItems();
    this.itemSelected = this.menuItems[0];
  }


}
