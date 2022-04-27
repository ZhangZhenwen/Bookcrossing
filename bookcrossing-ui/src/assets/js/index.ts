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

export interface Book {
    bookId: number,
    bookNo: string,
    name: string,
    author: string,
    type: string,
    status: string,
    createDate: string,
}

export interface Announcement {
    announcementId: number;
    title: string;
    content: string;
    createDate: string
}

export interface News {
    newsId: number;
    title: string;
    content: string;
    createDate: string
}

export interface Comment {
    commentId: number;
    parentId: number;
    content: string;
    type: string;
    status: string;
    createDate: string;
    userId: number;
}

export interface BookType {
    bookTypeId: number;
    typeName: string;
    createDate: string;
}