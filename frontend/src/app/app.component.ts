import {Component, OnInit} from "@angular/core";
import {Task} from "./sharing/entities/task.entity";
import {SidebarService} from "./sidebar/sidebar.service";
import * as firebase from "firebase";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [SidebarService]
})
export class AppComponent implements OnInit {
  loadedFeature: string = 'inputTasks';

  taskArray: Task[] = [];

  constructor(private sidebarService: SidebarService) {

    this.sidebarService.selectItemEmitter.subscribe(
      (feature) => {
        this.loadedFeature = feature;

      }
    );
  }

  ngOnInit() {
   /* firebase.initializeApp({
      apiKey:"AIzaSyCa4k6Blrw70Xr7PpTHJuM7e7jZVnDYdyE",
      authDomain:"https://team-note-firebase.firebaseio.com/"
    });*/
  }
}
