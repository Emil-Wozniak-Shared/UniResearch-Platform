import api from "./api";

export const list = async () => {
    const token = localStorage.getItem("token");
    const response = await api.get("/api/institutions", {
        headers: { Authorization: `Bearer ${token}` }
    });
    return response
}

export default {list};