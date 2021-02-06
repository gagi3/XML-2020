import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginRequest } from 'src/app/model/login-request';
import { Korisnik } from 'src/app/model/korisnik';
import { Adresa } from 'src/app/model/adresa';
import { FizickoLice } from 'src/app/model/fizicko-lice';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private endpoint = 'http://localhost:8081/api/user';

  private httpHeaders: any;
  private httpOptions: any;

  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/xml',
      Accept: 'application/xml',
      'Response-Type': 'text',
    });

    this.httpOptions = {
      headers: this.httpHeaders,
      responseType: 'text',
    };
  }

  login(email: string, password: string): Observable<any> {
    const local = '/login';

    const loginRequest = new LoginRequest(email, password);

    return this.http.post(
      `${this.endpoint}${local}`,
      loginRequest.toXML(),
      this.httpOptions
    );
  }

  register(
    ime: string,
    prezime: string,
    grad: string,
    ulica: string,
    broj: string,
    email: string,
    password: string,
    tip: string
  ): Observable<any> {
    const local = '/register';

    const adresa = new Adresa(grad, ulica, broj);
    const fizickoLice = new FizickoLice(ime, prezime, adresa);
    const korisnik = new Korisnik(fizickoLice, email, password, tip);

    return this.http.post(
      `${this.endpoint}${local}`,
      korisnik.toXML(),
      this.httpOptions
    );
  }

  logout() {
    localStorage.removeItem('token');
  }
}
