import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { AuthProvider} from "react-oidc-context";
import {BrowserRouter, Routes, Route} from "react-router";
import LoginPage from "./LoginPage.tsx";

const cognitoAuthConfig = {
    authority: "https://cognito-idp.ap-southeast-2.amazonaws.com/ap-southeast-2_fDTsChi0x",
    client_id: "1onomim5pu4st1ovou2v12v8v1",
    redirect_uri: "http://localhost:5173/",
    response_type: "code",
    scope: "email openid phone",
};

createRoot(document.getElementById('root')!).render(
  <BrowserRouter>
      <AuthProvider {...cognitoAuthConfig}>
          <Routes>
              <Route path="/" element={<App />} />
              <Route path="/login" element = {<LoginPage />} />
          </Routes>
      </AuthProvider>
  </BrowserRouter>
)