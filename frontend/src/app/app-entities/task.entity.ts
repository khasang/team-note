export class Task{
  public id:number
  public taskName:string;
  public initiator:string;
  public executor:string;
  public description:string;
  public dateOfCreation:string;
  public group:string;
  public project:string;
  public status:string;
  public finishDate:string;


  constructor(id:number,
              taskName?: string,
              initiator?:string,
              executor?:string,
              description?:string,
              group?:string,
              project?:string,
              status?:string,
              finishDate?:string
  ) {
    this.id = id;
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
