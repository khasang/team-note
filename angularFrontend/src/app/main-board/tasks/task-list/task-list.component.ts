import {Component, EventEmitter, Input, OnInit, Output} from "@angular/core";
import {Task} from "../task.model";
import {TaskService} from "../task.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  @Input() tasks:Task[];
  @Input() executor:string;
  constructor(private taskService: TaskService,
              private router: Router) {

  }

  onEditTask(index: number, task: Task) {
    this.router.navigate(["/tasks/" + this.executor +"/edit/"+index]);
  }

  ngOnInit() {
  }


}
