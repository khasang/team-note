import { Component, OnInit } from '@angular/core';
import {Task} from "./task.model";


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  taskArray:Task[] = [];
  taskLayoutSelected;
  taskChange:{index:number,task:Task};


  createTestTasks(){
    var task = new Task("Забрать машину","Галя");
    task.description = "Нужно очень быстро!";
    task.finishDate=(new Date()).toLocaleDateString();
    this.taskArray.push(task);
    this.taskArray.push(new Task("Написать first-page","Сергей"));
    this.taskArray.push(new Task("Купить подарок", "Павел"));
    this.taskArray.push(new Task("Разобраться с Angular","Павел"));
  }
  onSelectTask(data){
    this.taskChange=data;
  }

  onAddNewTask(data){
    this.taskArray.push(data);
  }

  onChangeTask(data){
    this.taskArray[data.index] = data.task;
  }
  returnToTaskList(data){
    this.taskLayoutSelected=data;
  }
  goToTaskEdit(data){
    this.taskLayoutSelected=data;
  }

  constructor() {
    this.createTestTasks();
  }

  addNewTask(){
    this.taskLayoutSelected='taskAdd';
  }

  ngOnInit() {
    this.taskLayoutSelected='taskList'
  }

}
