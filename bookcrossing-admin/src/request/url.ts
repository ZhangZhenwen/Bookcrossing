import { get, post} from "@/request/http";

/**
 * @author zhenwen
 * @date 2021/9/10
 */

/*
 * module base url
 */
const BOOK = "/book"
const CROSSINFO = "/crossinfo"
const ANNOUNCEMENT = "/announcement"
const NOTICE = "/notice"
const NEWS = "/news"
const COMMENT = "/comment"
const USER = "/user"

const getList = (url: string, data: object) => {
    return get(url + "/list", data);
}

const addData = (url: string, data: object) => {
    return post(url + "/add", data);
}

export default {
    BOOK,
    CROSSINFO,
    ANNOUNCEMENT,
    NOTICE,
    NEWS,
    COMMENT,
    USER,

    getList,
    addData,
}