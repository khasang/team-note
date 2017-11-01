import {Component, OnInit, ViewChild} from "@angular/core";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: []
})
export class AppComponent implements OnInit {
  @ViewChild('f') myForm:NgForm;
  defaultQuestion = 'pet';
  answer='';
  genders=['male','female'];

  suggestUserName(){
    this.myForm.setValue({
      username:"Pavel",
      email:"privet@nnn.ru",
      secret:"",
      answer:"",
      gender:"male"
    });
  }

  onSubmit(){
    console.log(this.myForm);
  }
  ngOnInit() { }
}
