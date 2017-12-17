export class Role{
  id:number;
  roleName:string;
  roleDescription:string;

  constructor(id?:number,roleName?:string,roleDescription?:string){
    this.id=id;
    this.roleName=roleName;
    this.roleDescription=roleDescription;
  }
}
