import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrestamosListComponent } from './prestamos-list.component';

describe('PrestamosListComponent', () => {
  let component: PrestamosListComponent;
  let fixture: ComponentFixture<PrestamosListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrestamosListComponent]
    });
    fixture = TestBed.createComponent(PrestamosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
