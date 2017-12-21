import {EventEmitter, Injectable} from "@angular/core";
import {Task} from "../../sharing/entities/task.entity";
import {DataTaskService} from "../../data-services/data-service/data-task-service.service";
import {Response} from "@angular/http"

@Injectable()
export class TaskService {

  constructor(private dataTaskService: DataTaskService) {

  }

  tasks: Task[] = [];
  listChangeEmitter = new EventEmitter();

  setTasks(taskFeature: string) {
    /*if (taskFeature === 'me') {
      //тут все измениться
      this.tasks = this.testTaskBD.taskInputArray;
    }
    if (taskFeature === 'not_me') {
      this.tasks = this.testTaskBD.taskOutputArray;
    }*/
    this.listChangeEmitter.emit();
  }

  getTask(id: number) {
    const task: Task = this.tasks.find(
      (t) => {
        return t.id === id;
      }
    );
    return task;
  }

  editTask(isNew: boolean, task: Task) {
    let index = this.tasks.indexOf(this.getTask(task.id));
    if (isNew) {
      this.tasks.push(task);
    }
    if (index && index >= 0) {
      this.tasks[index] = task;
    }

    return this.dataTaskService.putTask(task);
  }

  loadTasksFromDB() {
    this.dataTaskService.getAll()
      .subscribe(
      (response: Response) => {
        this.tasks  =response.json();
        this.listChangeEmitter.emit();
      }
    );


  }

}
