import { BrowserRouter, Routes, Route } from "react-router-dom";
import { DashboardLayout } from "./components/layout/DashboardLayout";
import { DashboardPage } from "./pages/DashboardPage";
import { ResearchersPage } from './pages/ResearchersPage';
import { InstitutionsPage } from './pages/InstitutionsPage';
import { GrantsPage } from './pages/GrantsPage';
import { LoginPage } from './pages/LoginPage';
import { ProfilePage } from "./pages/ProfilePage";
import { Provider } from "react-redux";
import { store } from "./store/store";

const App = () => (
    <Provider store={store}>
      <BrowserRouter>
        <DashboardLayout>
          <Routes>
            <Route path="/" element={<DashboardPage />} />
            <Route path="/profile" element={<><ProfilePage /></>} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/researchers" element={<><ResearchersPage /></>} />
            <Route path="/institutions" element={<><InstitutionsPage /></>} />
            <Route path="/grants" element={<><GrantsPage /></>} />
          </Routes>
        </DashboardLayout>
      </BrowserRouter>
    </Provider>
);

export default App;