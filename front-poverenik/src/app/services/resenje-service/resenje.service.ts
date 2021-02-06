import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ResenjeService {
  private endpoint = 'http://localhost:8081/resenje';

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

  create(xml: string): Observable<any> {
    const local = '/create';
    return this.http.post(`${this.endpoint}${local}`, xml, this.httpOptions);
  }
}
