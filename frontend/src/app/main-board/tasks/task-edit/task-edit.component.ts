import {Component, OnDestroy, OnInit} from "@angular/core";
import {Task} from "../../../sharing/entities/task.entity";
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
    let name = this.changingTask.name;
    let creator = this.changingTask.creator;
    let executor = this.changingTask.executor;

    this.taskForm = new FormGroup({
      'name': new FormControl(name, Validators.required),
      'creator': new FormControl(creator, Validators.required),
      'executor': new FormControl(executor, Validators.required)
    });
  }

  editTask() {
    this.changingTask.name = this.taskForm.value.name;
    this.changingTask.executor = this.taskForm.value.executor;
    this.changingTask.creator = this.taskForm.value.creator;

    this.taskService.editTask(this.isNewTask, this.changingTask)
      .subscribe(
        () => {
          this.gotoList();
        }
      );
  }

  createNewTask() {
    return new Task(null, "", "", "");
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
