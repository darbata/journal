import axios from "axios";

const apiUrl = "http://localhost:8080/api/entries"

// TODO: When auth is configured removed hardcoded user

export const client = axios.create({
    baseURL: apiUrl,
    timeout: 1000,
    headers: {"X-User" : "daz"}
});