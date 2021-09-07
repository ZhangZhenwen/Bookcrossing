import request from "../http";
import url from "../url"

export function getTopNavInfo() {
    return request.get(url.nav, {params: {type: "top"}})
}

export function getHeadNavInfo() {
    return request.get(url.nav, {params: {type: "head"}})
}
