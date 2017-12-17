import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusTasksComponent } from './status-tasks.component';

describe('StatusTasksComponent', () => {
  let component: StatusTasksComponent;
  let fixture: ComponentFixture<StatusTasksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatusTasksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatusTasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
