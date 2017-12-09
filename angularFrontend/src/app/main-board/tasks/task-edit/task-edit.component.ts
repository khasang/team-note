import {Component, OnDestroy, OnInit} from "@angular/core";
import {Task} from "../../../app-entities/task.entity";
import {TaskService} from "../task.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit, OnDestroy {


  constructor(private taskService: TaskService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  taskForm: FormGroup;
  changingTask: Task;
  isNewTask;
  private routeParamsSubscription: Subscription;


  private initForm() {
    let taskName = this.changingTask.taskName;
    let taskInitiator = this.changingTask.initiator;
    let taskExecutor = this.changingTask.executor;

    this.taskForm = new FormGroup({
      'taskName': new FormControl(taskName, Validators.required),
      'taskInitiator': new FormControl(taskInitiator, Validators.required),
      'taskExecutor': new FormControl(taskExecutor, Validators.required)
    });
  }

  editTask() {
    this.changingTask.taskName = this.taskForm.value.taskName;
    this.changingTask.executor = this.taskForm.value.taskExecutor;
    this.changingTask.initiator = this.taskForm.value.taskInitiator;

    this.taskService.editTask(this.isNewTask, this.changingTask)
      .subscribe(
        () => {
          this.gotoList();
        }
      );
  }

  createNewTask() {
    return new Task(this.taskService.getNewId(), "", "", "");
  }

  ngOnInit() {
    this.routeParamsSubscription = this.route.params
      .subscribe(
        (params: Params) => {
          this.changingTask = this.taskService.getTask(+params['id']);
          if (!this.changingTask) {
            this.isNewTask = true;
            this.changingTask = this.createNewTask();
          }
          this.initForm();
        },
      );
  }

  gotoList() {
    let url = "";
    if (this.isNewTask) {
      url = '../list'
    } else {
      url = '../../list'
    }
    this.router.navigate([url], {relativeTo: this.route});
  }

  ngOnDestroy() {
    this.routeParamsSubscription.unsubscribe();
  }
}
