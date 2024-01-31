import { Injectable } from '@angular/core';
import { UserToken } from '../models/user-token.model';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  constructor() { }

  signOut(): void {
    sessionStorage.clear();
  }

  public saveToken(token: string): void {
    sessionStorage.removeItem(TOKEN_KEY);
    sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string | null {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user: UserToken): void {
    sessionStorage.removeItem(USER_KEY);
    sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): UserToken {
    const user = sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }

    return null;
  }

  public getUserRoles(): string[] {
    const roles = this.getUser()
      .authorities
      ?.filter((authority: string) => authority.startsWith("ROLE_"))
      .map((authority: string) => authority.replace("ROLE_","").toLowerCase());

    return roles ?? [];
  }

  public isUserLoggedIn(): boolean {
    return sessionStorage.getItem(TOKEN_KEY) != null && sessionStorage.getItem(USER_KEY) != null;
  }

  public hasAccessRole(accessRoles: string[]): boolean {
    return accessRoles && accessRoles.filter(value => this.getUserRoles().includes(value)).length > 0;
  }
}
