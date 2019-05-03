<template>
    <div id="albumList">
        <div class="bg-dark clr-white">
            <h2 class="text-center clr-white">Альбомы</h2>
            <b-row>
                <b-col md="1">
                    <a class="carousel-control-next" @click="slidePrev()">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    </a>
                </b-col>
                <b-col v-for="album in albums" :key="album.title">
                    <p class="text-center">{{ album.title }}</p>
                    <div class="album-img-container">
                        <b-img-lazy class="album-img" center thumbnail fluid
                                    :src="'http://localhost:8080/images/' + album.src"
                                    :alt="'Обложка альбома ' + album.title"></b-img-lazy>
                        <div class="play-btn-align">
                            <img class="play-btn" src="../assets/play-btn.png" @click="chosenAlbum = album"/>
                        </div>
                    </div>
                </b-col>
                <b-col md="1" >
                    <a class="carousel-control-prev" @click="slideNext()">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    </a>
                </b-col>
            </b-row>
        </div>
    </div>
</template>

<script>
    import api from '../api';

    export default {
        name: "AlbumList",
        data() {
            return {
                albums: [],
                chosenAlbum: null,
                albumsPageable: {
                    page: 0,
                    size: 5
                },
            }
        },
        created() {
            this.getAllAlbums();
        },
        watch: {
            'chosenAlbum'(album) {
                // this.$refs.album.fetA();
                this.$emit("select", album);
            }
        },
        methods: {
            slidePrev() {
                if (this.albumsPageable.page !== 0) {
                    this.albumsPageable.page = this.albumsPageable.page - 1;
                    this.getAllAlbums();
                }
            },
            slideNext() {
                this.albumsPageable.page = this.albumsPageable.page + 1;
                this.getAllAlbums();
            },
            getAllAlbums() {
                this.$http
                    .get(this.$root.apiUrl + api.album.getAll, {
                        params:this.albumsPageable
                    })
                    .then(response => {
                        if (response.status === 200) {
                            this.albums = response.body;
                        }
                    });
            },
        }
    }
</script>

<style scoped>
    .clr-white {
        color: white;
    }
    .play-btn {
        width: 145px;
        height: 145px;
    }
    .play-btn-align {
        transition: .5s ease;
        opacity: 0;
        position: absolute;
        top: 45%;
        left: 50%;
        transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
    }
    .album-img {
        width: 250px;
        height: 250px;
        margin: 40px;
        transition: .5s ease;
        backface-visibility: hidden;
    }
    .album-img-container:hover .album-img {
        opacity: 0.3;
    }
    .album-img-container:hover .play-btn-align {
        opacity: 1;
    }
</style>
