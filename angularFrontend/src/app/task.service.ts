import {Subject} from "rxjs/Subject";

export class TaskService {
  constructor() {

  }

  taskActivated = new Subject();
}
