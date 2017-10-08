import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Task} from "../task.model";
import {TaskService} from "../task.service";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  constructor(private taskService:TaskService) {
  }

  @Input() tasks:Task[] = [];
  @Input() loadedFeature:string;

  @Output("editTask") editTask = new EventEmitter<{index:number,task:Task}>();
  @Output("formSelect") listTaskClose = new EventEmitter<string>();

  onEditTask(index:number,task:Task){
    this.editTask.emit({index,task});
    this.listTaskClose.emit('editTask');
  }

  ngOnInit() {
  }


}
