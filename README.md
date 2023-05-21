## Задание


## API

- `GET`     /users/{id} - получение пользователя по id
- `DELETE`  /users/{id} - удаление пользователя по id
- `POST`    /users - создание пользователя
- `PATCH`   /users/{id}/details - обновление информации пользователя
- `PATCH`   /users/{id}/contact - обновление контактной информации пользователя


`User Crud API.postman_collection.json` - Postman коллекция для API запросов к серверу.

Для запуска Postgres необходимо выполнить следующую команду (Docker):`docker run --name some-postgres -p 5432:5432 -e POSTGRES_USER=app -e POSTGRES_PASSWORD=mysecretpassword -d postgres`

## Ссылки

- https://bootify.io/spring-data/mapstruct-with-maven-and-lombok.html
