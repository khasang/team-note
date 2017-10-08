import {Task} from "./main-board/tasks/task.model";

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
    var task = new Task("Забрать машину", "Галя", "Я");
    task.description = "Нужно очень быстро!";
    task.finishDate = (new Date()).toLocaleDateString();
    taskArray.push(task);
    taskArray.push(new Task("Написать first-page", "Сергей", "Я"));
    taskArray.push(new Task("Купить подарок", "Павел", "Я"));
    taskArray.push(new Task("Разобраться с Angular", "Павел", "Я"));
    return taskArray;
  }

  private createTestOutputTasks() {
    var taskArray: Task[] = [];
    var task = new Task("Выучить стихотворение", "Я", "Даша");

    task.description = "Нужно очень быстро!";
    task.finishDate = (new Date()).toLocaleDateString();
    taskArray.push(task);
    taskArray.push(new Task("Написать книгу", "Я", "Маша"));
    return taskArray;
  }
}
