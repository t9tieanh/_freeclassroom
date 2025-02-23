import axios from "axios";
import NProgress from "nprogress";
import { store } from "../redux/store";


const instance = axios.create({
    baseURL: 'http://localhost:8080/freeclassroom',
});


instance.defaults.withCredentials = true; 


instance.interceptors.request.use(function (config) {

    // const accessToken = store.getState()?.account.account?.access_token
    // config.headers["Authorization"] = `Bearer ${accessToken}`;

    // console.log(accessToken)

    NProgress.start();
    // Do something before request is sent
    return config;
}, function (error) {
// Do something with request error
    return Promise.reject(error);
});

// Add a response interceptor
instance.interceptors.response.use(function (response) {
    NProgress.done();
    console.log(response);

    return response?.data;
}, function (error) {
    NProgress.done();

    console.log('error',error)

    return error?.response?.data
});

export default instance;