import {EventEmitter, Injectable} from "@angular/core";
import {Task} from "./task.model";
import {TestTaskBD} from "../../testTaskBD";

@Injectable()
export class TaskService {
  constructor(private testTaskBD: TestTaskBD) {
  }

  tasks: Task[] = this.testTaskBD.taskInputArray;
  listChangeEmitter = new EventEmitter();

  setTasks(taskFeature: string) {
    if (taskFeature === 'me') {
      this.tasks = this.testTaskBD.taskInputArray;
    }
    if (taskFeature === 'not_me') {
      this.tasks = this.testTaskBD.taskOutputArray;
    }
    this.listChangeEmitter.emit();
  }

  getTasks() {
    return this.tasks.slice();
  }

  getTask(id: number) {
    const task: Task = this.tasks.find(
      (t) => {
        return t.id === id
      }
    );
    return task;
  }

  editTask(isNew: boolean, task: Task) {
    var index = this.tasks.indexOf(this.getTask(task.id));
    if (isNew) {
      this.tasks.push(task);
    }
    if (index && index >= 0) {
      this.tasks[index] = task;
    }
  }

  //тут все измениться
  getNewId() {
    return this.tasks.length + 1;
  }

  setTasksFromDB(tasks: Task[]) {
    this.tasks = tasks;
    this.listChangeEmitter.emit();
  }

}
