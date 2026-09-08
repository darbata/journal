import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { AuthProvider} from "react-oidc-context";
import {BrowserRouter, Routes, Route} from "react-router";
import LoginPage from "./LoginPage.tsx";
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";
import {onSigninCallback, userManager} from "./auth.ts";

const queryClient = new QueryClient();

createRoot(document.getElementById('root')!).render(
  <BrowserRouter>
      <AuthProvider userManager={userManager} onSigninCallback={onSigninCallback}>
          <QueryClientProvider client={queryClient}>
              <Routes>
                  <Route path="/" element={<App />} />
                  <Route path="/login" element = {<LoginPage />} />
              </Routes>
          </QueryClientProvider>
      </AuthProvider>
  </BrowserRouter>
)