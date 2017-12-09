import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Task} from "../../app-entities/task.entity";

@Injectable()
export class DataServiceService {

  constructor(private http: Http) {
  }

  saveTaskToDB(tasks:Task[]) {
    return this.http.put("https://team-note-firebase.firebaseio.com/tasks.json", tasks);
  }

  getTaskFromDB() {
     return this.http.get("https://team-note-firebase.firebaseio.com/tasks.json");
  }

}
