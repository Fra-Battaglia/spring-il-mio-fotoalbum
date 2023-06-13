<script>
	import axios from "axios";
	const BASE_API_URL = "http://localhost:8080/api/v1";

	export default {
  		data() {
    		return {
				Message: {
				email: "",
				message: "",
      		},
   	 	};
  	},

  	methods: {
		sendMessage() {
      		console.log(this.Message);

			axios
				.post(BASE_API_URL + "/photo/message", this.Message)
				.then((res) => {
					this.$router.push("/");
				})
			},
  		},
	};
</script>

<template>
	<div class="message-box">
		<h1>Invia messaggio</h1>
		<form @submit.prevent="sendMessage" action="">
			<div class="fields">

				<div class="field">
					<label for="email">Email</label>
					<div class="input">
						<input type="email" name="email" v-model="Message.email">
					</div>
				</div>

				<div class="field">
					<label for="message">Message</label>
					<div class="input">
						<input type="text" name="message" v-model="Message.message">
					</div>
				</div>

			</div>
			<input type="submit" value="Send" class="button">
		</form>
	</div>
</template>

<style lang="scss" scoped>
	.message-box {
		display: flex;
		flex-direction: column;
		align-items: center;
		border: 1px solid var(--color-text);
		border-radius: 20px;
		margin: 50px 0;
		font-size: 1em;

		h1 {
			padding: 1em;
			font-weight: 700;
		}

		form {
			display: flex;
			flex-direction: column;
			align-items: center;
			gap: 1em;
			margin-bottom: 2em;

			.button {
				background-color: #FFFFFF;
				font-size: 1em;
				border-radius: 10px;
				padding: 0.5em 1em;
				margin-top: 1em;
				border: none;
			}
		}
		.fields {
			display: flex;
			align-items: center;
			gap: 2em;

			.field {
				display: flex;
				gap: 0.5em;
				align-items: center;
				.input {
					text-align: center;
					border-radius: 10px;
					padding: 0.5em 1em;
					border: 1px solid var(--color-text);
	
					input {
						border: 0;
						background-color: transparent;
						color: #FFFFFF;
					}
	
					textarea:focus, input:focus{
						outline: none;
						background-color: transparent;
					}
				}
			}
		}
	}
</style>