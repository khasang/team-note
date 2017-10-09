import {Component, Input, OnInit} from "@angular/core";
import {Task} from "./task.model";
import {TaskService} from "./task.service";
import {ActivatedRoute, Params, Router} from "@angular/router";


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css'],

})
export class TasksComponent implements OnInit {

  constructor(private taskService:TaskService,
              private rote:ActivatedRoute,
              private router:Router) { }

  taskArray: Task[];

  executor:string;

  taskChange: { index: number, task: Task };

  onSelectTask(data) {
    this.taskChange = data;
  }

  onAddNewTask(data) {
    this.taskArray.push(data);
  }

  onChangeTask(data) {
    this.taskArray[data.index] = data.task;
  }

  ngOnInit() {
    this.executor = this.rote.snapshot.params['executor'];
    this.rote.params.subscribe(
      (params:Params)=>{
        this.executor=params['executor'];
        if (this.executor ==='me'){this.taskArray = this.taskService.inputTasks;}
        if (this.executor ==='not_me') {this.taskArray = this.taskService.outputTasks;}
      }
    );
  }

}
