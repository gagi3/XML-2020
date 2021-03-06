import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/services/auth-service/auth.service';
import { Router } from '@angular/router';

let parseString = require('xml2js').parseString;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  onSubmit(): void {
    if (!this.loginForm) {
      return;
    }

    const { email, password } = this.loginForm.value;

    this.authService.login(email, password).subscribe((data) => {
      parseString(data, function (err: any, result: any) {
        const token = result.JWTResponse.token[0];
        localStorage.setItem('token', token);
      });
      this.router.navigate(['/']);
    });
  }
}
