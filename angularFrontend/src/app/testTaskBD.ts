import {Task} from "./main-board/tasks/task.model";
import {DataServiceService} from "./data-services/data-service/data-service.service";

export class TestTaskBD {
  //this class for test only

  taskInputArray: Task[];
  taskOutputArray: Task[];

  constructor() {
    this.taskInputArray = this.createTestInputTasks();
    this.taskOutputArray = this.createTestOutputTasks();

  }

  private createTestInputTasks() {
    var taskArray: Task[] = [];
    var task = new Task(1,"Забрать машину", "Галя", "Я");
    task.description = "Нужно очень быстро!";
    task.finishDate = (new Date()).toLocaleDateString();
    taskArray.push(task);
    taskArray.push(new Task(2,"Написать first-page", "Сергей", "Я"));
    taskArray.push(new Task(3,"Купить подарок", "Павел", "Я"));
    taskArray.push(new Task(4,"Разобраться с Angular", "Павел", "Я"));


    return taskArray;
  }

  private createTestOutputTasks() {
    var taskArray: Task[] = [];
    var task = new Task(1,"Выучить стихотворение", "Я", "Даша");

    task.description = "Нужно очень быстро!";
    task.finishDate = (new Date()).toLocaleDateString();
    taskArray.push(task);
    taskArray.push(new Task(2,"Написать книгу", "Я", "Маша"));
    return taskArray;
  }
}
