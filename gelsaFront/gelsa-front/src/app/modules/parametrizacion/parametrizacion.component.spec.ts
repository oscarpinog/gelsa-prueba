import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParametrizacionComponent } from './parametrizacion.component';

describe('ParametrizacionComponent', () => {
  let component: ParametrizacionComponent;
  let fixture: ComponentFixture<ParametrizacionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ParametrizacionComponent]
    });
    fixture = TestBed.createComponent(ParametrizacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
