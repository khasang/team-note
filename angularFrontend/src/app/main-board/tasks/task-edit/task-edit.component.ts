import {Component, OnDestroy, OnInit} from "@angular/core";
import {Task} from "../task.model";
import {TaskService} from "../task.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit,OnDestroy {


  constructor(private taskService: TaskService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  changingTask: Task;
  isNewTask;
  private subscribeParames:Subscription;

  taskName = "";
  taskInitiator = "";
  taskExecutor = "";

  editTask() {
    this.changingTask.taskName = this.taskName;
    this.changingTask.initiator = this.taskInitiator;
    this.changingTask.executor = this.taskExecutor;

    this.taskService.editTask(this.changingTask);
    this.gotoList();
  }

  addTask(){
    this.changingTask.taskName = this.taskName;
    this.changingTask.initiator = this.taskInitiator;
    this.changingTask.executor = this.taskExecutor;
    this.taskService.addTask(this.changingTask);
    this.gotoList();
  }

  createNewTask() {
    return new Task(this.taskService.getNewId(), "", "", "");
  }


  ngOnInit() {
    this.subscribeParames = this.route.params.subscribe(
      (params: Params) => {
        this.changingTask = this.taskService.getTask(+params['id']);
        if (!this.changingTask) {
          this.isNewTask = true;
          this.changingTask = this.createNewTask();
        }
      }
    );
    this.taskName = this.changingTask.taskName;
    this.taskInitiator = this.changingTask.initiator;
    this.taskExecutor = this.changingTask.executor;
  }

  gotoList(){
    var url ="";
    if(this.isNewTask) {
      url='../list'
    }else{
      url='../../list'
    }
    this.router.navigate([url],{relativeTo:this.route});
  }

  ngOnDestroy(){
    this.subscribeParames.unsubscribe();
  }
}
