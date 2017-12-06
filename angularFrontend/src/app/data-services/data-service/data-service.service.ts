import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {TaskService} from "../../main-board/tasks/task.service";
import {Task} from "../../main-board/tasks/task.model";
import {Subject} from "rxjs/Subject";

@Injectable()
export class DataServiceService {

  dataLoadSubject = new Subject();

  constructor(private http: Http) {
  }

  saveTaskToDB(tasks:Task[]) {
    console.log(tasks);
    return this.http.put("https://team-note-firebase.firebaseio.com/tasks", tasks);
  }

  getTaskFromDB() {
    this.http.get("https://team-note-firebase.firebaseio.com/tasks.json")
      .subscribe(
        (response: Response) => {
          this.dataLoadSubject.next(response.json())
        }
      );
  }

}
