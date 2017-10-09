import {Component, EventEmitter, Input, OnInit, Output} from "@angular/core";
import {Task} from "../task.model";
import {TaskService} from "../task.service";
import {ActivatedRoute, Params, Route, Router, RouterLinkActive} from "@angular/router";

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  constructor(private taskService:TaskService,
              private route:ActivatedRoute,
              private router:Router) {

  }

  indexChangingTask;
  changingTask:Task;
  isNewTask;

  addTask(name: HTMLInputElement, initiator: HTMLInputElement,taskExecutor:HTMLInputElement) {
    this.changingTask = new Task(name.value, initiator.value,taskExecutor.value);
    if (name.value && initiator.value) {

    }

  }

  editTask(name: HTMLInputElement, initiator: HTMLInputElement,taskExecutor:HTMLInputElement) {
    this.changingTask = new Task(name.value, initiator.value,taskExecutor.value);
    if (name.value && initiator.value) {
      //this.changeTask.emit(this.taskChange);
    }

  }


  ngOnInit() {
   this.route.params.subscribe(
     (params:Params)=>{
       if(params['changeOperation'] ==='new'){
         this.changingTask = new Task('','','');
       }
       if(params['changeOperation'] ==='edit'){
         if(params['executor'] === 'me'){
           this.changingTask = this.taskService.inputTasks[params['id']];
         } else {
           this.changingTask = this.taskService.outputTasks[params['id']];
         }

       }

     }
   )


  }

}
