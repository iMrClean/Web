export default {
    album: {
        getAll: '/albums',
        getOne: id => '/albums/' + id,

    },
    track: {
        getTop: 'пока не знаю как реализовать',
        getByAlbum: albumId => '/albums/' + albumId + '/tracks'
    },
    buy: '/buy'
}