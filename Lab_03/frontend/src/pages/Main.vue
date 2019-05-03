<template>
    <div id="main">
        <div id="header">
            <b-navbar type="dark" variant="dark" toggleable>
                <b-navbar-toggle target="nav_dropdown_collapse"></b-navbar-toggle>
                <b-collapse is-nav id="nav_dropdown_collapse">
                    <b-navbar-nav>
                        <router-link class="nav-link" to="/main">Главная страница</router-link>
                        <router-link class="nav-link" to="/about">О нас</router-link>
                    </b-navbar-nav>
                    <b-navbar-nav class="ml-auto">
                        <b-btn class="mr-3 buy-button" variant="secondary" @click="buyAlbums()">Купить альбомы</b-btn>
                        <div class="mr-3 align-self-center clr-white">Выбрано альбомов: {{ orderDTO.albumsId.length }}</div>
                        <b-nav-form>
                            <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Введите альбом" v-model="searchQuery"></b-form-input>
                            <b-button size="sm" class="my-2 my-sm-0" @click="getAllAlbums(searchQuery)">Поиск</b-button>
                        </b-nav-form>
                    </b-navbar-nav>
                </b-collapse>
            </b-navbar>
            <router-view></router-view>
        </div>
        <div id="content">
            <album :top-tracks="topTracks" :album="chosenAlbum"></album>
            <album-list @select="chosenAlbum = $event"></album-list>
        </div>
        <div id="footer">
            <div class="footer-copyright text-center py-3">
                © 2018 Copyright: В этот магазин была вложена душа, не используйте это в своих коммерческих целях, вас не поймут...
            </div>
        </div>
    </div>
</template>

<script>
    import api from '../api';
    import Album from '../components/Album'
    import AlbumList from '../components/AlbumList'

    export default {
        name: "Main",
        components: {Album, AlbumList},
        data() {
            return {
                topTracks: [],
                chosenAlbum: null,
                orderDTO: {
                    albumsId: []
                },
                searchQuery: null
            }
        },
        methods: {
            buyAlbums() {
                this.$http
                    .post(this.$root.apiUrl + api.buy, this.orderDTO)
                    .then(response => {
                        if (response.status === 204) {
                            alert("Куплено");
                        } else {
                            alert("govno");
                        }
                    });
            }
        }
    }
</script>

<style scoped>
    #main {
        margin-left: 20px;
        margin-right: 20px;
    }
    #footer {
        height:50px;
        width:100%;
        bottom:0px;
        left:0px;
        background: #CCCCCC;
        position:fixed;
    }
    .clr-white {
        color: white;
    }
    .buy-button:hover {
        background: green;
        border-color: green;
    }
</style>
