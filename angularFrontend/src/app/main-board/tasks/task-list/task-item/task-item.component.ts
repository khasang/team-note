import {Component, Input, OnInit} from '@angular/core';
import {Task} from "../../task.model";

@Component({
  selector: 'app-task-item',
  templateUrl: './task-item.component.html',
  styleUrls: ['./task-item.component.css']
})
export class TaskItemComponent implements OnInit {
  @Input("taskItem")taskItem:Task;
  @Input()loadedFeature:string;



  constructor() {
  }

  ngOnInit() {
  }

}
