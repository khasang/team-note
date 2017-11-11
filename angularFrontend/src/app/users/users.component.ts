import {Component, OnDestroy, OnInit} from "@angular/core";
import {Observable} from "rxjs/Observable";
import 'rxjs/Rx';
import {Observer} from "rxjs/Observer";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit,OnDestroy {

  mySubscriptions: Subscription;
  constructor() {
  }

  ngOnInit() {
    // const myNumbers = Observable.interval(1000);
    // myNumbers.subscribe(
    //   (number:number)=>{
    //     console.log(number);
    //   },
    //   ()=>{},
    //   ()=>{}
    // )
    const myObservable = Observable.create(
      (observer:Observer<string>)=>{
        setTimeout(
          ()=>{observer.next('privet')},2000
        );
        setTimeout(
          ()=>{observer.next('poka')},3000
        );
        setTimeout(
          ()=>{observer.next('tut')},2500
        );
        setTimeout(
          ()=>{observer.error("DOES NOT WORK")},4500
        );
        setTimeout(
          ()=>{observer.complete()},4000
        )
      }
    );
    this.mySubscriptions = myObservable.subscribe(
      (data:string)=>{
        console.log(data);
      },
      (error:string)=>{
        console.log(error);
      },
      ()=>{
        console.log("completed")
      }
    )
  }


  ngOnDestroy(){
    this.mySubscriptions.unsubscribe();
  }

}
