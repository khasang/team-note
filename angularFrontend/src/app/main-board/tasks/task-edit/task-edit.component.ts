import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Task} from "../task.model";

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {


  task:Task;




  constructor() { }

  ngOnInit() {
  }

}
