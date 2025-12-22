import { useEffect, useState } from "react";
import { StatCard } from "../components/cards/StatCard";
import { GrantsChart } from "../components/charts/GrantsChart";
import { getDashboardStats, getGrantFundingByYear } from "../api/dashboardApi";
import { type DashboardStats, type GrantFundingByYear } from "../types/dashboard";

export const DashboardPage = () => {
  const [stats, setStats] = useState<DashboardStats | null>(null);
  const [grants, setGrants] = useState<GrantFundingByYear[]>([]);

  useEffect(() => {
    getDashboardStats().then(setStats);
    getGrantFundingByYear().then(setGrants);
  }, []);

  if (!stats) return <div>Loading...</div>;

  return (
    <div className="grid gap-6">
      <div className="grid grid-cols-4 gap-4">
        <StatCard title="Researchers" value={stats.researchersCount} />
        <StatCard title="Institutions" value={stats.institutionsCount} />
        <StatCard title="Active Grants" value={stats.activeGrantsCount} />
        <StatCard title="Publications (YTD)" value={stats.publicationsThisYear} />
      </div>

      <div className="bg-white p-4 rounded shadow">
        <h2 className="text-lg font-semibold mb-2">Grant Funding by Year</h2>
        <GrantsChart data={grants} />
      </div>
    </div>
  );
};
