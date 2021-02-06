import { FizickoLice } from './fizicko-lice';

export class Korisnik {
  private fizickoLice: FizickoLice;
  private username: string;
  private password: string;
  private tip: string;

  constructor(
    fizickoLice: FizickoLice,
    username: string,
    password: string,
    tip: string
  ) {
    this.fizickoLice = fizickoLice;
    this.username = username;
    this.password = password;
    this.tip = tip;
  }

  toXML() {
    return `
      <korisnik>
        <fizickoLice>
          <ime>${this.fizickoLice.ime}</ime>
          <prezime>${this.fizickoLice.prezime}</prezime>
          <adresa>
            <grad>${this.fizickoLice.adresa.grad}</grad>
            <ulica>${this.fizickoLice.adresa.ulica}</ulica>
            <broj>${this.fizickoLice.adresa.broj}</broj>
          </adresa>
        </fizickoLice>
        <username>${this.username}</username>
        <password>${this.password}</password>
        <tip>${this.tip}</tip>
      </korisnik>
    `;
  }
}
