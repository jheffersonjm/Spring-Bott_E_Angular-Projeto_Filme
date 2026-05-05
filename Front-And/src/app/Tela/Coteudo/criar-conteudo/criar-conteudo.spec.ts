import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarConteudo } from './criar-conteudo';

describe('CriarConteudo', () => {
  let component: CriarConteudo;
  let fixture: ComponentFixture<CriarConteudo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CriarConteudo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CriarConteudo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
