import {Component, Input, OnInit} from "@angular/core";
import {Task} from "./task.model";


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  @Input() taskArray: Task[];
  taskLayoutSelected;
  taskChange: { index: number, task: Task };

  onSelectTask(data) {
    this.taskChange = data;
  }

  onAddNewTask(data) {
    this.taskArray.push(data);
  }

  onChangeTask(data) {
    this.taskArray[data.index] = data.task;
  }

  returnToTaskList(data) {
    this.taskLayoutSelected = data;
  }

  goToTaskEdit(data) {
    this.taskLayoutSelected = data;
  }

  constructor() {

  }

  addNewTask() {
    this.taskLayoutSelected = 'taskAdd';
  }

  ngOnInit() {
    this.taskLayoutSelected = 'taskList'
  }

}
