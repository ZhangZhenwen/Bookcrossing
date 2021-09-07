import axios from 'axios'
import router from '../router';
import store from '../store'
import QS from 'qs'

const request = axios.create({
    headers: {'Content-Type': 'application/json; charset=utf-8'},
    baseURL: '/api'
})

/**
 * 请求头添加token
 */
request.interceptors.request.use(
    config => {
        const token = store;
        token && (config.headers.Authorization = token);
        return config
    }
)

request.interceptors.response.use(
    response => {
        if(response.status === 200) {
            return Promise.resolve(response.data);
        } else {
            return Promise.resolve(response.data);
        }
    },
    error => {
        if (error.response.status) {
            console.log(router.currentRoute)
            let path: any = router.currentRoute.value
            switch (error.response.status) {
                // 没有权限信息
                case 401:
                    router.replace({
                        path: '/login',
                        query: {
                            redirect: path
                        }
                    });
                    break;
                // token过期
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
                // 资源不可达
                case 404:
                    break;
                default:
                    break;
            }
        }

        return Promise.reject(error.response);
    }
)

/**
 * Get请求
 *
 * @param url 请求路径
 * @param params 请求参数
 */
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

/**
 * Post请求
 *
 * @param url 请求路径
 * @param params 请求参数
 */
export function post(url: string, params: object) {
    return new Promise((resolve, reject) => {
        request.post(url, QS.stringify(params))
        .then(res => {
            resolve(res.data);
        }).catch(err => {
            reject(err.data)
        })
    })
}

export default request
