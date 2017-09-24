import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainBoardComponent } from './mainBoard.component';

describe('MainBoardComponent', () => {
  let component: MainBoardComponent;
  let fixture: ComponentFixture<MainBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
