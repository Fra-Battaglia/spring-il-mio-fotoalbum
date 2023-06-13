<script>
	const BASE_API_URL = 'http://localhost:8080/api/v1';

	import axios from 'axios';
	import HelloWorld from './HelloWorld.vue';
	export default {
		data() {
			return {
				photos: [],
				inputSearch: ""
			}
		},

		components: {
			HelloWorld
		},

		methods: {
			getPhotos() {
				axios.get(BASE_API_URL + "/photo").then(res => {
					this.photos = res.data;
				})
			},

			searchPhoto() {
				axios
					.get(BASE_API_URL + "/photo?title=" + this.inputSearch)
					.then((res) => {
					this.photos = res.data;
				})
			}
		},

		mounted() {
			this.searchPhoto();
		}
		
	}
</script>

<template>
	<h1 style="text-align: center; font-weight: 700; font-size: 54px;">Photos</h1>
	
	<div class="a">
		<label for="search">Search Photos</label>
			<div class="search-photo">
				<input type="text" name="search" v-model="this.inputSearch" />
			</div>
		<button @click="searchPhoto()">Search</button>
		
	</div>

	<div class="photos">
		<div v-for="item in photos" class="card col p-0">
			<div v-if="item.visible == true">
				<img :src="item.url" :alt="item.title" class="card-img">
				<div class="info p-2">
					<h1 class="green">{{ item.title }}</h1>
					<p>{{ item.description }}</p>
					<div class="tags">
						<div v-for="category in item.categories" class="tag">{{ category.name }}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</template>

<style lang="scss" scoped>

	.container {
		width: 1280px;
		margin: 0 auto;
	}

	.a {
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
		padding: 0.5em 0;
		margin-bottom: 2em;

		label {
			font-size: 1.5em;
		}

		button {
			background-color: #ffffff;
			font-size: 1em;
			border-radius: 10px;
			padding: 0.5em 1em;
			margin-top: 1em;
			border: none;
		}
	}
	.search-photo {
		text-align: center;
		border-radius: 10px;
		padding: 0.5em 1em;
		
		border: 1px solid #ffffff;

		input {
			font-size: 2em;
			color: #ffffff;
			background-color: transparent;
			border: 0;
		}

		textarea:focus, input:focus{
			outline: none;
			background-color: transparent;
		}
	}

	.tags {
		display: flex;
		gap: 5px;
		.tag {
			background-color: hsla(160, 100%, 37%, 1);
			color: white;
			border-radius: 5px;
			padding: 2.5px;
		}
	}
	.photos {
		display: flex;
		justify-content: space-between;
		gap: 1em;
		.card {
			width: 300px;

			h1 {
				font-weight: 700;
			}
			.card-img {
				width: 100%;
				aspect-ratio: 4 / 3;
				object-fit: cover;
			}
		}
	}
</style>
