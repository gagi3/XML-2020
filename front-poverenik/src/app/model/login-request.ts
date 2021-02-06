export class LoginRequest {
  private username: string;
  private password: string;

  constructor(username: string, password: string) {
    this.username = username;
    this.password = password;
  }

  toXML() {
    return `
      <login-request>
        <username>${this.username}</username>
        <password>${this.password}</password>
      </login-request>
    `;
  }
}
