/**
 * @author zhenwen
 * @date 2021/9/14
 */

export interface AjaxResult<T> {
    code: string,
    msg: string,
    data: T,
}

export interface PageData<T> {
    content: Array<T>,
    first: boolean,
    last: boolean,
    number: number,
    numberOfElements: number,
    size: number,
    totalElements: number,
    totalPages: number,
}