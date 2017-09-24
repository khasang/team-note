import { Component, OnInit } from '@angular/core';
import {Task} from "../models/Task";

@Component({
  selector: 'app-main-board',
  templateUrl: './mainBoard.component.html',
  styleUrls: ['./mainBoard.component.css']
})
export class MainBoardComponent implements OnInit {
  tasks = [];

  createNewTask(task:Task){
    this.tasks.push()
  }

  constructor() {
    this.createTestTasks();
  }

  ngOnInit() {
  }

  createTestTasks(){
    this.tasks.push(new Task("Забрать машину","Галя"));
    this.tasks.push(new Task("Написать first-page","Сергей"));
    this.tasks.push(new Task("Купить подарок", "Павел"));
    this.tasks.push(new Task("Разобраться с Angular","Павел"));
  }

}
