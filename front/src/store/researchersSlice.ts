import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import api from "../api/api";

export const fetchResearchers = createAsyncThunk("researchers/fetch", async () => {
  const response = await api.get("/api/researchers");
  return response.data;
});

const researchersSlice = createSlice({
  name: "researchers",
  initialState: { data: [], status: "idle" },
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(fetchResearchers.fulfilled, (state, action) => {
      state.data = action.payload;
      state.status = "succeeded";
    });
  }
});

export default researchersSlice.reducer;
