export class Task{
  taskName='';
  description='';
  initiator='';
  executor='';
  dateOfCreation='';
  group = '';
  project='';
  status='';
  finishDate='';

  constructor(taskName,initiator){
    this.taskName = taskName;
    this.initiator=initiator;
    this.status="create";
    this.dateOfCreation=new Date().toDateString();
  }
}
