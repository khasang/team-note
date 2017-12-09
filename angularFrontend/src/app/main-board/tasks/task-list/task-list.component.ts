import {Component, OnDestroy, OnInit} from "@angular/core";
import {Task} from "../../../app-entities/task.entity";
import {TaskService} from "../task.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit,OnDestroy {

  subscription: Subscription;
  tasks: Task[];

  constructor(private taskService: TaskService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  addTask() {
    this.router.navigate(["../new"], {relativeTo: this.activatedRoute});
  }

  onEditTask(taskId: number) {
    this.router.navigate(["../edit", taskId], {relativeTo: this.activatedRoute});
  }

  ngOnInit() {
    this.taskService.loadTasksFromDB();
    this.tasks = this.taskService.tasks.slice();
    this.subscription = this.taskService.listChangeEmitter.subscribe(
      () => {
        this.tasks = this.taskService.tasks.slice();
      }
    );
  }

  ngOnDestroy(): void {
    //this.taskService.taskLoaderSubscription.unsubscribe();
  }
}
