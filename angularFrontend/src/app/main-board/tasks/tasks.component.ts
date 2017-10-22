import {Component, OnDestroy, OnInit} from "@angular/core";
import {TaskService} from "./task.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css'],
})
export class TasksComponent implements OnInit {


  constructor(private taskService: TaskService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  executor: string;
  subscriptions:Subscription;

  ngOnInit() {
    this.executor = this.route.snapshot.params['executor'];
    this.route.params.subscribe(
      (params: Params) => {
        this.executor = params['executor'];
        if (this.executor === 'me') {
          this.taskService.setTasks('me');
        }
        if (this.executor === 'not_me') {
          this.taskService.setTasks('not_me');
        }
      }
    );
  }



}
