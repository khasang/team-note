export class Task{
  public taskName:String;
  public initiator:String;
  public executor:String;
  public description:String;
  public dateOfCreation:String;
  public group:String;
  public project:String;
  public status:String;
  public finishDate:String;


  constructor(taskName?: string,
              initiator?:string,
              executor?:string,
              description?:String,
              group?:String,
              project?:String,
              status?:String,
              finishDate?:String) {
    this.taskName = taskName;
    this.initiator=initiator;
    this.executor=executor;
    this.description=description;
    this.group=group;
    this.project=project;
    this.status="create";
    this.finishDate=finishDate;
    this.dateOfCreation=new Date().toDateString();
  }




}
