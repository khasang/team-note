import {Component, OnInit} from "@angular/core";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: []
})
export class AppComponent implements OnInit {
  suggestUserName(){
    const suggestedName = 'Superuser';
  }

  onSubmit(form:NgForm){
    console.log(form.value);
  }
  ngOnInit() { }
}
