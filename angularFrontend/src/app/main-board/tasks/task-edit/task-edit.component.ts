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
  private subscribeParames:Subscription;;

  addTask(name: HTMLInputElement, initiator: HTMLInputElement, taskExecutor: HTMLInputElement) {
    if (name.value && initiator.value) {
      this.taskService.addTask(this.changingTask);
    }
    this.goToTaskList();
  }

  editTask(name: HTMLInputElement, initiator: HTMLInputElement, executor: HTMLInputElement) {
    this.changingTask.taskName = name.value;
    this.changingTask.initiator = initiator.value;
    this.changingTask.executor = executor.value;

    this.taskService.editTask(this.changingTask);
    this.goToTaskList();
  }

  createNewTask() {
    return new Task(this.taskService.getNewId(), "", "", "");
  }

  goToTaskList(){
    this.router.navigate(["../../list"],{relativeTo:this.route})
  }
  ngOnInit() {
    if (this.route.snapshot.params['id']) {

      this.createNewTask();
    }
    this.subscribeParames = this.route.params.subscribe(
      (params: Params) => {
        this.changingTask = this.taskService.getTask(+params['id']);
        if (!this.changingTask) {
          this.isNewTask = true;
          this.changingTask = this.createNewTask();
        }
      }
    )
  }

  ngOnDestroy(){
    this.subscribeParames.unsubscribe();
  }
}
