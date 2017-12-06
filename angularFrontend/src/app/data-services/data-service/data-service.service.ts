import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";
import {Task} from "../../main-board/tasks/task.model";
import {Subject} from "rxjs/Subject";

@Injectable()
export class DataServiceService {

  dataLoadSubject = new Subject();

  constructor(private http: Http) {
  }

  saveTaskToDB(tasks:Task[]) {
    return this.http.put("https://team-note-firebase.firebaseio.com/tasks.json", tasks);
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
