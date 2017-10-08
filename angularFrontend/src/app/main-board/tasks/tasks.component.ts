import {Component, Input, OnInit} from "@angular/core";
import {Task} from "./task.model";
import {TaskService} from "./task.service";


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css'],
  providers:[TaskService]
})
export class TasksComponent implements OnInit {
  constructor(private taskService:TaskService) { }

  @Input() taskArray: Task[];
  @Input() loadedFeature:string;

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

  addNewTask() {
    this.taskLayoutSelected = 'taskAdd';
  }

  ngOnInit() {
    this.taskLayoutSelected = 'taskList'
  }

}
