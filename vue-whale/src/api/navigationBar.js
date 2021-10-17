import request from '@/utils/request'

export function getList(params) {
    return request({
        url: '/navigationBar',
        method: 'get',
        params
    })
}


export function deleted(idList) {
    return request({
        url: `/navigationBar/?idList=${idList}`,
        method: 'delete'
    })
}

export function update(data) {
    return request({
        url: `/navigationBar`,
        method: 'put',
        data
    })
}

