import axios from "axios";
import { createSlice, createAsyncThunk, type PayloadAction } from "@reduxjs/toolkit";
import { type Institution} from "../types/institution.model"

interface InstitutionsState {
  data: Institution[];
  loading: boolean;
  error: string | null;
}

const initialState: InstitutionsState = {
  data: [],
  loading: false,
  error: null,
};

const API_URL = "http://localhost:8080/api/institutions";

export const fetchInstitutions = createAsyncThunk(
  "institutions/fetchInstitutions",
  async () => {
    const response = await axios.get<Institution[]>(API_URL);
    return response.data;
  }
);

export const fetchInstitutionById = createAsyncThunk(
  "institutions/fetchInstitutionById",
  async (id: string) => {
    const response = await axios.get<Institution>(`${API_URL}/${id}`);
    return response.data;
  }
);

export const createInstitution = createAsyncThunk(
  "institutions/createInstitution",
  async (payload: Partial<Institution>) => {
    const response = await axios.post<Institution>(API_URL, payload);
    return response.data;
  }
);

export const updateInstitution = createAsyncThunk(
  "institutions/updateInstitution",
  async ({ id, payload }: { id: string; payload: Partial<Institution> }) => {
    const response = await axios.put<Institution>(`${API_URL}/${id}`, payload);
    return response.data;
  }
);

export const deleteInstitution = createAsyncThunk(
  "institutions/deleteInstitution",
  async (id: string) => {
    await axios.delete(`${API_URL}/${id}`);
    return id;
  }
);

export const institutionsSlice = createSlice({
  name: "institutions",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchInstitutions.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchInstitutions.fulfilled, (state, action: PayloadAction<Institution[]>) => {
        state.loading = false;
        state.data = action.payload;
      })
      .addCase(fetchInstitutions.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message || "Failed to fetch institutions";
      })
      .addCase(fetchInstitutionById.fulfilled, (state, action: PayloadAction<Institution>) => {
        // Replace or add single institution
        const index = state.data.findIndex((i) => i.id === action.payload.id);
        if (index >= 0) state.data[index] = action.payload;
        else state.data.push(action.payload);
      })
      .addCase(createInstitution.fulfilled, (state, action: PayloadAction<Institution>) => {
        state.data.push(action.payload);
      })
      .addCase(updateInstitution.fulfilled, (state, action: PayloadAction<Institution>) => {
        const index = state.data.findIndex((i) => i.id === action.payload.id);
        if (index >= 0) state.data[index] = action.payload;
      })
      .addCase(deleteInstitution.fulfilled, (state, action: PayloadAction<string>) => {
        state.data = state.data.filter((i) => i.id !== action.payload);
      });
  },
});

export default institutionsSlice.reducer;
