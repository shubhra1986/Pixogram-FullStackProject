import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyMedia1Component } from './my-media1.component';

describe('MyMedia1Component', () => {
  let component: MyMedia1Component;
  let fixture: ComponentFixture<MyMedia1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyMedia1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyMedia1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
