import { Component } from '@angular/core';
import { TelaLoginService, Logar } from '../../Service/Tela_Login/tela-login-service';
import { lastValueFrom } from 'rxjs';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule, NgIf } from '@angular/common';

@Component({
  selector: 'app-tela-login',
  standalone: true,
  imports: [FormsModule, CommonModule, NgIf],
  templateUrl: './tela-login.html',
  styleUrl: './tela-login.css',
})
export class TelaLogin {
  loginData: Logar = {
    gmail: '',
    senha: ''
  };

  mensagemErro: string = '';
  carregando: boolean = false;
  mostrarSenha: boolean = false;

  constructor(private telaLoginService: TelaLoginService, private router: Router) {}

  async logarSistema() {
    // Limpar mensagem de erro anterior
    this.mensagemErro = '';

    // Validar campos
    if (!this.loginData.gmail || !this.loginData.senha) {
      this.mensagemErro = 'Por favor, preencha todos os campos!';
      return;
    }

    // Validar email
    if (!this.validarEmail(this.loginData.gmail)) {
      this.mensagemErro = 'Por favor, insira um email válido!';
      return;
    }

    this.carregando = true;

    try {
      const response$ = this.telaLoginService.getUsuario();
      const usuarios = await lastValueFrom(response$);
      
      // Verificar se encontrou o usuário
      const usuarioEncontrado = usuarios.find(
        (u: Logar) => u.gmail === this.loginData.gmail && u.senha === this.loginData.senha
      );

      if (usuarioEncontrado) {
        console.log('Login bem-sucedido:', usuarioEncontrado);
        // Salvar dados do usuário no localStorage
        localStorage.setItem('usuario', JSON.stringify(usuarioEncontrado));
        // Redirecionar para a home
        this.router.navigate(['/home']);
      } else {
        this.mensagemErro = 'Email ou senha incorretos!';
      }
    } catch (error) {
      console.error('Erro ao fazer login:', error);
      this.mensagemErro = 'Erro ao conectar com o servidor. Tente novamente mais tarde.';
    } finally {
      this.carregando = false;
    }
  }

  validarEmail(email: string): boolean {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  }

  alternarVisibilidadeSenha() {
    this.mostrarSenha = !this.mostrarSenha;
  }
}