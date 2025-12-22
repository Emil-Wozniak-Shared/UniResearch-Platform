import api from "./api";
import { type DashboardStats, type GrantFundingByYear } from "../types/dashboard";

export const getDashboardStats = async (): Promise<DashboardStats> => {
//       try {
//           const { data } = await api.get("/api/dashboard/stats").then(res => res.json());
//           return data;
//       } catch (e) {
//           console.error(e)
//           return [];
//       }
    return []
};

export const getGrantFundingByYear = async (): Promise<GrantFundingByYear[]> => {
//     try {
//         const { data } = await api.get("/api/dashboard/grants/funding").then(res => res.json());
//         return data;
//     } catch (e) {
//         console.error(e)
//         return [];
//     }
    return []
};
