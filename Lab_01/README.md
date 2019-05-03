#####
## OPTIONS
###
	http://mail.ru 			status 400 Bad Request
###
	http://ya.ru 			status 403 Frobidden
###
	www.rambler.ru 			status 403 Forbidden
###
	https://www.google.ru 		status 405 Method Not Allowed
###
	https://github.com/ 		status 404 Not Found
###
	www.apple.com/ 			status 200 OK
#####
## HEAD
###
	vk.com 				status 418 I'm a teapot
###
	www.apple.com 			status 200 OK
###
	www.msn.com 			status 200 OK
#####
## GET
###
	yandex.ru 			status 200 Ok
###
	google.com 			status 200 OK
###
	apple.com 			status 200 OK
#####
## POST
###
	yandex.ru 			status 403 Forbidden
###
	google.com 			status 405 Method Not Allowed
###
	apple.com 			status 200 Ok
##	Получите список всех факультетов МГТУ им. Н.Э.Баумана.
#####
Чтобы обратиться к методу API ВКонтакте, необходимо выполнить запрос такого вида:
##
https://api.vk.com/method/METHOD_NAME?PARAMETERS&access_token=ACCESS_TOKEN&v=V
##	Получаем токен:
client_id="Тут_был_id"
user_ids="Тут_был_id"
access_token="Тут_был_токен"
##	Авторизация:
https://oauth.vk.com/authorize?client_id="ID"&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=token&v=5.85&state=123456
##	Получаем список факультетов:
https://api.vk.com/method/database.getFaculties?university_id=250&access_token="ТОКЕН"&v=5.85
##	Получаем аватарку:
https://api.vk.com/method/users.get?user_ids="ID"&fields=photo_50&access_token="ТОКЕН"&v=5.85
##	Отправьте запись на стену любому пользователю/группе и убедитесь, что она пришла:
https://api.vk.com/method/wall.post?owner_id="ID"&message=0&access_token="ТОКЕН"&v=5.85
