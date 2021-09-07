import request  from '../http'
import url from '../url'

export function projectList() {
    return request.get(url.project);
}