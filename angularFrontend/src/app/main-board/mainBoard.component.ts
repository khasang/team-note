import {Component, Input, OnInit} from '@angular/core';
import {Task} from "./tasks/task.model";

@Component({
  selector: 'app-main-board',
  templateUrl: './mainBoard.component.html',
  styleUrls: ['./mainBoard.component.css']
})
export class MainBoardComponent implements OnInit {
  @Input()sidebarFeature:string;

  constructor() {
  }

  ngOnInit() {
    this.sidebarFeature='inputTasks';
  }

}
