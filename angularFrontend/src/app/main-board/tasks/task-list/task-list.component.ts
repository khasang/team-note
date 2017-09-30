import { Component, OnInit } from '@angular/core';
import {Task} from "../task.model";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  tasks:Task[] = [];
  constructor() {
    this.createTestTasks();
  }

  ngOnInit() {
  }



  createTestTasks(){
    var task = new Task("Забрать машину","Галя");
        task.description = "Нужно очень быстро!";
        task.finishDate=(new Date()).toLocaleDateString();
    this.tasks.push(task);
    this.tasks.push(new Task("Написать first-page","Сергей"));
    this.tasks.push(new Task("Купить подарок", "Павел"));
    this.tasks.push(new Task("Разобраться с Angular","Павел"));
  }
}
