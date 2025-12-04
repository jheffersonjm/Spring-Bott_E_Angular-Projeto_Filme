import { TestBed } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { TelaLoginService } from './tela-login-service';

describe('TelaLoginService', () => {
  let service: TelaLoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TelaLoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
