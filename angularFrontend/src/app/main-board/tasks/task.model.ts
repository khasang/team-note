export class Task{
  public taskName:String;
  public description:String;
  public initiator:String;
  public executor:String;
  public dateOfCreation:String;
  public group:String;
  public project:String;
  public status:String;
  public finishDate:String;

  constructor(taskName,initiator){
    this.taskName = taskName;
    this.initiator=initiator;
    this.status="create";
    this.dateOfCreation=new Date().toDateString();
  }
}
