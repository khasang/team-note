import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {TaskService} from "../../main-board/tasks/task.service";
import {Task} from "../../main-board/tasks/task.model";

@Injectable()
export class DataServiceService {

  constructor(private http: Http, private taskService: TaskService) {
  }

  saveTaskToDB() {
    return this.http.put("https://team-note-firebase.firebaseio.com/tasks.json", this.taskService.getTasks());
  }

  getTaskFromDB() {
    this.http.get("https://team-note-firebase.firebaseio.com/tasks.json")
      .subscribe(
        (response: Response) => {
          const tasks: Task[] = response.json();
          this.taskService.setTasksFromDB(tasks);
        }
      );
  }

}
