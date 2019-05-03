<template>
    <b-container class="bg-dark">
        <b-card no-body>
            <h4 slot="header" class="text-center">{{ album ? album.title : 'Топовые треки' }}</h4>
            <b-row class="no-gutters">
                <div class="col-auto">
                    <b-img v-if="album" :src="'http://localhost:8080/images/' + album.src" img-fluid :alt="'Обложка альбома ' + album.title"></b-img>
                </div>
                <b-col>
                    <div class="card-block px-2">
                        <div class="card-text" v-if="album">
                            <p><strong>Исполнитель: </strong>{{ album.artist }}</p>
                            <p><strong>Жанр: </strong>{{ album.genre }}</p>
                            <p><strong>Описание: </strong>{{ album.description }}</p>
                        </div>
                        <b-list-group v-for="track in tracks" :key="track.title">
                            <b-list-group-item>{{ track.artist }} - {{ track.title }}
                                <div id="container">
                                    <div id="disc">
                                        <audio id="player" controls>
                                            <source :src="'http://localhost:8080/music/' + album.artist + '/adrenaline/' + track.src" type="audio/mp3">
                                        </audio>
                                    </div>
                                </div>
                            </b-list-group-item>
                        </b-list-group>
                    </div>
                </b-col>
            </b-row>
            <div class="card-footer">
                <b-button variant="secondary" v-if="album" @click="">Добавить в корзину</b-button>
            </div>
        </b-card>
    </b-container>
</template>

<script>
    import api from '../api'

    export default {
        name: "Album",
        props: {
            topTracks: {
                type: Array,
                required: false,
                default: () => []
            },
            album: null
        },
        data() {
            return {
                tracks: []
            }
        },
        watch: {
            'topTracks'(value) {
                this.tracks = value;
            },
            'album'(value) {
                this.getAlbumTracks(value.id);
            }
        },
        methods: {
            getAlbumTracks(albumId){
                this.$http
                    .get(this.$root.apiUrl + api.track.getByAlbum(albumId))
                    .then(response => {
                        if (response.status === 200) {
                            this.tracks = response.body;
                        }
                    });
            }
        }
    }
</script>

<style scoped>
    /*body {*/
    /*margin: 0;*/
    /*display: flex;*/
    /*justify-content: center;*/
    /*align-items: center;*/
    /*height: 100vh;*/
    /*background: #F0EEED;*/
    /*}*/
    /*audio {*/
    /*display: none;*/
    /*}*/
    /*#container {*/
    /*height: 180px;*/
    /*width: 180px;*/
    /*background: rgba(255,255,255,.8);*/
    /*border-radius: 24px;*/
    /*position: relative;*/
    /*box-shadow: 0 0 20px 0 rgba(0,0,0,.15);*/
    /*transition: .5s linear;*/
    /*}*/
    /*#container:before {*/
    /*content: "\f001";*/
    /*font-family: FontAwesome;*/
    /*font-size: 70px;*/
    /*background: -webkit-linear-gradient(50deg, #FD9F85 50%, #E837C2);*/
    /*-webkit-background-clip: text;*/
    /*-webkit-text-fill-color: transparent;*/
    /*color: #FF7E24;*/
    /*position: absolute;*/
    /*line-height: 180px;*/
    /*left: 60px;*/
    /*}*/
    /*#container:hover #disc {*/
    /*margin-left: 110px;*/
    /*transform: rotate(360deg);*/
    /*}*/
    /*#disc {*/
    /*position: absolute;*/
    /*height: 140px;*/
    /*width: 140px;*/
    /*z-index: -1;*/
    /*border-radius: 50%;*/
    /*background: transparent;*/
    /*margin: 20px;*/
    /*transition: .9s linear;*/
    /*box-shadow:*/
    /*0 8px 6px -8px rgba(0,0,0,0.5),*/
    /*0 0 1px 1px rgba(0,0,0,0.5),*/
    /*0 0 0 1px #666 inset,*/
    /*0 0 0 2px #222 inset,*/
    /*0 30px 0px -29px #444 inset,*/
    /*0 -30px 0px -29px #444 inset,*/
    /*0 0 0 3px #333 inset,*/
    /*0 0 0 4px #222 inset,*/
    /*0 0 0 5px #333 inset,*/
    /*0 33px 0px -27px #444 inset,*/
    /*0 -33px 0px -27px #444 inset,*/
    /*0 0 0 6px #222 inset,*/
    /*0 0 0 7px #333 inset,*/
    /*0 0 0 8px #222 inset,*/
    /*0 34px 0px -25px #444 inset,*/
    /*0 -34px 0px -25px #444 inset,*/
    /*0 0 0 9px #333 inset,*/
    /*0 0 0 10px #222 inset,*/
    /*0 0 0 11px #333 inset,*/
    /*0 35px 0px -23px #444 inset,*/
    /*0 -35px 0px -23px #444 inset,*/
    /*0 0 0 12px #222 inset,*/
    /*0 0 0 13px #333 inset,*/
    /*0 0 0 14px #222 inset,*/
    /*0 36px 0px -21px #444 inset,*/
    /*0 -36px 0px -21px #444 inset,*/
    /*0 0 0 15px #333 inset,*/
    /*0 0 0 16px #222 inset,*/
    /*0 0 0 17px #333 inset,*/
    /*0 37px 0px -19px #444 inset,*/
    /*0 -37px 0px -19px #444 inset,*/
    /*0 0 0 18px #222 inset,*/
    /*0 0 0 19px #333 inset,*/
    /*0 0 0 20px #222 inset,*/
    /*0 38px 0px -17px #444 inset,*/
    /*0 -38px 0px -17px #444 inset,*/
    /*0 0 0 21px #333 inset,*/
    /*0 0 0 22px #222 inset,*/
    /*0 0 0 23px #333 inset,*/
    /*0 39px 0px -15px #444 inset, */
    /*0 -39px 0px -15px #444 inset, */
    /*0 0 0 24px #222 inset,*/
    /*0 0 0 25px #333 inset,  */
    /*0 0 0 26px #222 inset,*/
    /*0 40px 0px -13px #444 inset,*/
    /*0 -40px 0px -13px #444 inset,*/
    /*0 0 0 27px #333 inset,*/
    /*0 0 0 28px #222 inset,*/
    /*0 0 0 29px #333 inset,*/
    /*0 41px 0px -11px #444 inset,*/
    /*0 -41px 0px -11px #444 inset,*/
    /*0 0 0 30px #222 inset,*/
    /*0 0 0 43px #333 inset,*/
    /*0 0 0 45px #AF2A10 inset,*/
    /*0 0 0 47px #333 inset,*/
    /*0 0 0 62px #AF2A10 inset,*/
    /*0 0 10px 78px rgba(0,0,0,0.5) inset;*/
    /*}*/

</style>