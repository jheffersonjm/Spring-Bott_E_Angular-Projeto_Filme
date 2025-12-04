import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { TelaLoginService } from '../Service/Tela_Login/tela-login-service';

export const authGuard = () => {
  const loginService = inject(TelaLoginService);
  const router = inject(Router);

  if (loginService.estaLogado()) {
    return true;
  }

  router.navigate(['/']);
  return false;
};
