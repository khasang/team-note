import {Component, OnInit} from "@angular/core";
import {Task} from "./main-board/tasks/task.model";
import {SidebarService} from "./sidebar/sidebar.service";
import {TestTaskBD} from "./testTaskBD";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [SidebarService]
})
export class AppComponent {







}
