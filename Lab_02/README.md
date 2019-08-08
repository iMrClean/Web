## Лабораторная работа №2
~~~
Замерьте скорость отдачи контента на сервере из лабораторной работы №1.
Добавьте логирование приходящих запросов.
~~~

~~~
Сконфигурируйте nginx сервер таким образом, чтобы запросы проходили через
nginx и перенаправлялись на сервер из лабораторной работы №1.
~~~

~~~
Используйте nginx отдачи статического контента. Как изменилось время ответа
сервера?
~~~

~~~
Настройте кеширование и gzip сжатие файлов. Как изменилось время ответа
сервера?
~~~

~~~
Запустите еще 2 инстанса вашего сервера из лабораторной работы №1,
настройте перенаправление таким образом, чтобы на серверы приходили
запросы в соотношении 3:1.
~~~

~~~
Напишите еще два мини-сервера. Каждый из них должен обрабатывать два
GET-запроса.
~~~

~~~
Настройте отдачу страницы о состоянии сервера
~~~

#### Дополнительные задания:

~~~
Настройте https порт на сервере nginx. Используйте самоподписанный
сертификат. ( Создание сертификата )
~~~

~~~
Добавьте ServerPush картинки для страницы index.html. Как изменилось время
ответа сервера и загрузки страницы?
~~~

~~~
Для повышения уровня безопасности необходимо скрывать внутреннюю
реализацию вашего сервера. Скройте все заголовки Server (nginx можно
оставить) из header ответа, а также дополнительные заголовки, которые
дописывает ваш сервер, если есть.
~~~