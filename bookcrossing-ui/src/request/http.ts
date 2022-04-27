import axios from 'axios'
import router from '../router';
import store from '../store'
import { ElMessage } from "element-plus";

const request = axios.create({
    headers: {'Content-Type': 'application/json; charset=utf-8'},
    baseURL: '/api'
})

request.interceptors.request.use(
    config => {
        const token = localStorage.getItem("token");
        token && (config.headers.Authorization = token);
        return config
    }
)

request.interceptors.response.use(
    response => {
        switch (response.data.code) {
            case 200:
                return Promise.resolve(response);
            case 401:
                let path: any = router.currentRoute.value
                router.replace({
                    path: '/login',
                    query: {
                        redirect: path
                    }
                });
                break;
            default:
                ElMessage.error({
                    message: response.data.msg,
                    type: "error"
                });
                break;
        }
    },
    error => {
        if (error.response.status) {
            let path: any = router.currentRoute.value
            switch (error.response.status) {
                case 401:
                    router.replace({
                        path: '/login',
                        query: {
                            redirect: path
                        }
                    });
                    break;
                case 403:
                    localStorage.removeItem('token');
                    store.commit('loginSuccess', null);

                    setTimeout(() => {
                        router.replace({
                            path: '/login',
                            query: {
                                redirect: path
                            }
                        })
                    }, 1000);
                    break;
                case 404:
                    break;
                default:
                    break;
            }
        }

        return Promise.reject(error.response);
    }
)

export function get(url: string, params: object) {
    return new Promise((resolve, reject) => {
        request.get(url, {
            params: params
        })
        .then(res => {
            resolve(res.data);
        }).catch(err => {
            reject(err.data);
        })
    })
}

export function post(url: string, params: object) {
    return new Promise((resolve, reject) => {
        request.post(url, JSON.stringify(params))
        .then(res => {
            resolve(res.data);
        }).catch(err => {
            reject(err.data)
        })
    })
}

export function put(url: string, params: object) {
    return new Promise((resolve, reject) => {
        request.put(url, JSON.stringify(params))
            .then(res => {
                resolve(res.data);
            }).catch(err => {
            reject(err.data)
        })
    })
}

export function del(url: string, params: object) {
    return new Promise((resolve, reject) => {
        request.delete(url, {data: JSON.stringify(params)})
            .then(res => {
                resolve(res.data);
            }).catch(err => {
            reject(err.data)
        })
    })
}

export default request
