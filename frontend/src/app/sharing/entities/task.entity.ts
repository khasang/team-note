export class Task {
  public
  constructor(
    public id?: number,
    public creator?: string,
    public executor?: string,
    public status?: string,
    public priority?:number,
    public label?: string,
    public name?: string,
    public description?: string) {
  }
}
