import { UserManager, WebStorageStateStore } from "oidc-client-ts";

export const userManager = new UserManager({
    authority: "https://cognito-idp.ap-southeast-2.amazonaws.com/ap-southeast-2_fDTsChi0x",
    client_id: "1onomim5pu4st1ovou2v12v8v1",
    redirect_uri: "http://localhost:5173/",
    response_type: "code",
    scope: "email openid phone",
    userStore: new WebStorageStateStore({ store: window.localStorage }),
});

export const onSigninCallback = () => {
    window.history.replaceState({}, document.title, window.location.pathname);
};