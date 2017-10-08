import {Component, EventEmitter, Input, OnInit, Output} from "@angular/core";
import {Task} from "../task.model";
import {TaskService} from "../task.service";

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  constructor(private taskService:TaskService) {
    if(!this.taskChange){
      this.taskChange =  {index:1,task:new Task("","")};
    }
  }

  @Input() isNewTask:boolean;
  @Input() taskChange: { index: number, task: Task };

  @Output("changeTask") changeTask = new EventEmitter<{ index: number, task: Task }>();
  @Output("addNewTask") addNewTask = new EventEmitter<Task>();
  @Output('formSelect') taskEditOff = new EventEmitter<string>();

  addTask(name: HTMLInputElement, initiator: HTMLInputElement,taskExecutor:HTMLInputElement) {
    this.taskChange.task = new Task(name.value, initiator.value,taskExecutor.value);
    if (name.value && initiator.value) {
      this.addNewTask.emit(this.taskChange.task);
    }
    this.goToTaskList();
  }

  editTask(name: HTMLInputElement, initiator: HTMLInputElement,taskExecutor:HTMLInputElement) {
    this.taskChange.task = new Task(name.value, initiator.value,taskExecutor.value);
    if (name.value && initiator.value) {
      this.changeTask.emit(this.taskChange);
    }
    this.goToTaskList();
  }

  goToTaskList() {
    this.taskEditOff.emit('taskList');
  }



  ngOnInit() {


  }

}
