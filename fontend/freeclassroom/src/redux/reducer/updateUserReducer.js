
import {  UPDATE_USER } from "../action/updateUserAction";
import { DeleteUser } from "../action/updateUserAction";

const INITIAL_STATE = {
    account : {
        accessToken: "",
        username: "",
        email: "",
        role: "",
    },
    isAuthentication : false
};

const updateUserReducer = (state = INITIAL_STATE, action) => {
    switch (action.type) {
        case UPDATE_USER:
            return {
                ...state, account : {
                    accessToken: action.payload.accessToken,
                    username : action.payload.username, 
                    email : action.payload.email, 
                    role : action.payload.role, 
                }, 
                isAuthentication : action.payload.valid
            };
        
        case DeleteUser: 
            return {
                ...state, account : INITIAL_STATE.account, isAuthentication: false 
            }

        default: return state;
    }
};

export default updateUserReducer;