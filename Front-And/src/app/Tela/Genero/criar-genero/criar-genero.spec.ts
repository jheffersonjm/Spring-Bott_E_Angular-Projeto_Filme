import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarGenero } from './criar-genero';

describe('CriarGenero', () => {
  let component: CriarGenero;
  let fixture: ComponentFixture<CriarGenero>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CriarGenero]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CriarGenero);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
