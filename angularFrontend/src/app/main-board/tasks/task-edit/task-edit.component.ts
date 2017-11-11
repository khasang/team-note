import {Component, OnDestroy, OnInit, ViewChild} from "@angular/core";
import {Task} from "../task.model";
import {TaskService} from "../task.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";
import {NgForm} from "@angular/forms";

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

  @ViewChild('f') taskForm: NgForm;
  changingTask: Task;
  isNewTask;
  private subscribeParams: Subscription;

  editTask() {
    this.taskService.editTask(this.taskForm.value);
    this.gotoList();
  }

  addTask() {
    this.taskService.addTask(this.changingTask);
    this.gotoList();
  }

  createNewTask() {
    return new Task(this.taskService.getNewId(), "", "", "");
  }

  ngOnInit() {
    this.subscribeParams = this.route.params
      .subscribe(
      (params: Params) => {
        this.changingTask = this.taskService.getTask(+params['id']);
        if (!this.changingTask) {
          this.isNewTask = true;
          this.changingTask = this.createNewTask();
        }
      }
    );
    this.subscribeParams.add(
      this.taskService.startedEditing.subscribe()
    )
  }

  gotoList() {
    var url = "";
    if (this.isNewTask) {
      url = '../list'
    } else {
      url = '../../list'
    }
    this.router.navigate([url], {relativeTo: this.route});
  }

  ngOnDestroy() {
    this.subscribeParams.unsubscribe();
  }
}
