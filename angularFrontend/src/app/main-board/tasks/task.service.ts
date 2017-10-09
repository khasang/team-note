import {EventEmitter, Injectable} from '@angular/core';
import {Task} from "./task.model";
import {TestTaskBD} from "../../testTaskBD";

@Injectable()
export class TaskService {
  constructor(private testTaskBD:TestTaskBD) { }

 inputTasks:Task[] = this.testTaskBD.taskInputArray;
 outputTasks:Task[] = this.testTaskBD.taskOutputArray;

  taskEmitter = new EventEmitter<string>();


}
