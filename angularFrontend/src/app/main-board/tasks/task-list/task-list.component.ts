import {Component, OnDestroy, OnInit} from "@angular/core";
import {Task} from "../task.model";
import {TaskService} from "../task.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  subscription:Subscription;
  tasks: Task[];

  constructor(private taskService: TaskService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  onEditTask(index: number) {
    this.router.navigate(["../edit", index], {relativeTo: this.activatedRoute});
  }

  ngOnInit() {
    this.tasks = this.taskService.getTasks();
    this.subscription = this.taskService.listChangeEmitter.subscribe(
      () => {
        this.tasks = this.taskService.getTasks();
      }
    );
  }

  addTask() {
    this.router.navigate(["../new"], {relativeTo: this.activatedRoute});
  }


}
