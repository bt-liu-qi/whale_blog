import request from '@/utils/request'

export function getList(params) {
    return request({
        url: '/essay',
        method: 'get',
        params
    })
}


export function deleted(idList) {
    return request({
        url: `/essay/?idList=${idList}`,
        method: 'delete'
    })
}

export function update(data) {
    return request({
        url: `/essay`,
        method: 'put',
        data
    })
}

