import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

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
    };
  }

  login(email: string, password: string): Observable<any> {
    const local = '/login';
    return this.http.post(
      `${this.endpoint}${local}`,
      { email, password },
      this.httpOptions
    );
  }
}
