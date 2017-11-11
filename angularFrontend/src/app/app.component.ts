import {Component, OnInit} from "@angular/core";
import {TaskService} from "./task.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: []
})
export class AppComponent implements OnInit {

  task1Activated:boolean = false;
  task2Activated:boolean = false;
  constructor(private taskService:TaskService) {  }

  ngOnInit() {
    this.taskService.taskActivated.subscribe(
      (data:number)=>{
        if(data==1){
          this.task1Activated = true;
          this.task2Activated = false;
        }else{
          this.task1Activated = false;
          this.task2Activated = true;
        }
      }
    );
  }
}
