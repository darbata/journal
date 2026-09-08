import axios from "axios";
import {userManager} from "../auth.ts";

const apiUrl = "http://localhost:8080/api"

export const client = axios.create({
    baseURL: apiUrl,
    timeout: 1000,
});

client.interceptors.request.use(async (config) => {
    const user = await userManager.getUser();
    if (user && !user.expired) {
        config.headers.set("Authorization", `Bearer ${user.access_token}`);
    }
    return config;
});

client.interceptors.response.use(
    (response) => response,
    async (error) => {
        if (error.response?.status === 401) {
            try {
                await userManager.signinSilent();
            } catch {
                await userManager.signinRedirect();
            }
        }
        return Promise.reject(error);
    }
);