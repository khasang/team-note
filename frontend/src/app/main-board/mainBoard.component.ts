import {Component, Input, OnInit} from "@angular/core";
import {Task} from "../app-entities/task.entity";
import {SidebarService} from "../sidebar/sidebar.service";
import {AuthService} from "../auth/auth.service";

@Component({
  selector: 'app-main-board',
  templateUrl: './mainBoard.component.html',
  styleUrls: ['./mainBoard.component.css']
})
export class MainBoardComponent implements OnInit {
  @Input() sidebarFeature: string;
  @Input() taskArray: Task[];

  constructor(private sidebarService:SidebarService,
              private authService:AuthService ) {
    this.sidebarFeature = sidebarService.itemSelected.name;
  }

  ngOnInit() {
  }

}
