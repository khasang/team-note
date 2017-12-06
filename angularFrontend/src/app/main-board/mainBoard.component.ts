import {Component, Input, OnInit} from "@angular/core";
import {Task} from "./tasks/task.model";
import {SidebarService} from "../sidebar/sidebar.service";
import {TaskService} from "./tasks/task.service";
import {DataServiceService} from "../data-services/data-service/data-service.service";

@Component({
  selector: 'app-main-board',
  templateUrl: './mainBoard.component.html',
  styleUrls: ['./mainBoard.component.css']
})
export class MainBoardComponent implements OnInit {
  @Input() sidebarFeature: string;
  @Input() taskArray: Task[];

  constructor(private sidebarService:SidebarService, private taskService:TaskService) {
    this.sidebarFeature = sidebarService.itemSelected.name;
  }

  ngOnInit() {
  }

//Delete after testing
  testLoadTaskFromDB(){
    this.taskService.setTasksFromDB();
  }
}
