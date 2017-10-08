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
export class AppComponent implements OnInit {
  loadedFeature: string = 'inputTasks';
  testTaskBD = new TestTaskBD();
  taskArray: Task[] = this.testTaskBD.taskInputArray;

  constructor(private sidebarService: SidebarService) {

    this.sidebarService.selectItemEmitter.subscribe(
      (feature) => {
        this.loadedFeature = feature;
        if (this.loadedFeature === 'inputTasks') {
          this.taskArray = this.testTaskBD.taskInputArray;
        }
        if (this.loadedFeature === 'outputTasks') {
          this.taskArray = this.testTaskBD.taskOutputArray;
        }
      }
    );
  }

  ngOnInit() { }
}
