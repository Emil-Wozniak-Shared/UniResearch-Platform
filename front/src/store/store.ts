import researchersReducer from "./researchersSlice";
import institutionsReducer from "./institutionsSlice";

export const store = configureStore({
    reducer: {
        researchers: researchersReducer,
        institutions: institutionsReducer,
    }
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;