import api from "./api";

type Credentials = {
    username: string,
    password: string
}

export const login = async ({username, password}: Credentials) => {
    const response = await api.post("/api/login", { username,  password });
    return response
}

export default login;