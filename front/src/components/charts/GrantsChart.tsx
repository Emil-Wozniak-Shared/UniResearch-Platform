import { BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer } from "recharts";
import { type GrantFundingByYear } from "../../types/dashboard";

type Props = {
  data: GrantFundingByYear[];
};

export const GrantsChart = ({ data }: Props) => (
  <ResponsiveContainer width="100%" height={300}>
    <BarChart data={data}>
      <XAxis dataKey="year" />
      <YAxis />
      <Tooltip />
      <Bar dataKey="totalAmount" />
    </BarChart>
  </ResponsiveContainer>
);
