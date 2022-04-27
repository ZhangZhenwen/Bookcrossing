import { createStore } from "vuex";

export default createStore({
    state: {
        loginStatus: false,
    },
    getters: {
        getLoginStatus: (state) => {
            return state.loginStatus;
        }
    },
    mutations: {
        setLoginStatus: (state, status) => {
            state.loginStatus = status;
        }
    }
});
