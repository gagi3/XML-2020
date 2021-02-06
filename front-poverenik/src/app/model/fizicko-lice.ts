import { Adresa } from './adresa';

export class FizickoLice {
  public ime: string;
  public prezime: string;
  public adresa: Adresa;

  constructor(ime: string, prezime: string, adresa: Adresa) {
    this.ime = ime;
    this.prezime = prezime;
    this.adresa = adresa;
  }
}
