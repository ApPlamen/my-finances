import { ActivatedRouteSnapshot, CanActivateChildFn, CanActivateFn, Router, RouterStateSnapshot } from "@angular/router";
import { TokenStorageService } from "../services/token-storage.service";
import { inject } from "@angular/core";

export const canActivate: CanActivateFn = (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => checkUserLogin(route, state);
export const canActivateChild: CanActivateChildFn = (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => canActivate(route, state);

function checkUserLogin(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const tokenStorageService = inject(TokenStorageService);
    const router = inject(Router);

    if (tokenStorageService.isUserLoggedIn()) {
        if (!tokenStorageService.hasAccessRole(route.data["accessRoles"])) {
            router.navigate(['/error-403']);
            return false;
        }

        return true;
    }

    this.router.navigate(['/login']);
    return false;
}
