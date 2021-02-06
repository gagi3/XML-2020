import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      ime: ['', Validators.required],
      prezime: ['', Validators.required],
      grad: ['', Validators.required],
      ulica: ['', Validators.required],
      broj: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
    });
  }

  onSubmit(): void {
    if (!this.registerForm) {
      return;
    }

    const {
      ime,
      prezime,
      grad,
      ulica,
      broj,
      email,
      password,
    } = this.registerForm.value;

    this.authService
      .register(ime, prezime, grad, ulica, broj, email, password, 'POVERENIK')
      .subscribe(() => this.router.navigate(['/login']));
  }
}
