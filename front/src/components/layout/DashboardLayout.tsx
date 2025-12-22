import { ReactNode } from "react";
import { Sidebar } from "./Sidebar";

export const DashboardLayout = ({ children }: { children: ReactNode }) => (
 <div className="flex min-h-screen">
    <Sidebar />
    <main className="flex-1 bg-gray-100 p-6">
        {children}
    </main>
  </div>
);
