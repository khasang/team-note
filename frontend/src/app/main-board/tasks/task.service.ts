import {EventEmitter, Injectable} from "@angular/core";
import {Task} from "../../app-entities/task.entity";
import {TestTaskBD} from "../../testTaskBD";
import {DataServiceService} from "../../data-services/data-service/data-service.service";
import {Response} from "@angular/http"

@Injectable()
export class TaskService {

  constructor(private testTaskBD: TestTaskBD,
              private taskDataService: DataServiceService) {

  }

  tasks: Task[] = [];
  listChangeEmitter = new EventEmitter();

  setTasks(taskFeature: string) {
    if (taskFeature === 'me') {
      //тут все измениться
    }
    if (taskFeature === 'not_me') {
      this.tasks = this.testTaskBD.taskOutputArray;
    }
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

    return this.taskDataService.saveTaskToDB(this.tasks.slice());
  }

  loadTasksFromDB() {
    this.taskDataService.getTaskFromDB()
      .subscribe(
      (response: Response) => {
        this.tasks  =response.json();
        this.listChangeEmitter.emit();
      }
    );
  }

  //тут все измениться
  getNewId() {
    return this.tasks.length + 1;
  }
}
