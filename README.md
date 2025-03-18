# Selenide proxy usage test

---
## Disclaimer
Данный проект является тестом использования proxy в selenide. :)

Для запуска проекта нужна:
- java 21,
- maven,
- docker + compose
- [chrome for testing](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/win64/chrome-win64.zip)
- [chrome driver](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/win64/chromedriver-win64.zip)

#### Локальный запуск
1) Требуется явно создать подсеть для selenoid, 
2) Собрать приложение, запустить контейнеры postgres и selenoid,
```shell
docker network create selenoid
mvn clean package && docker compose build && docker compose up selenoid
```

#### Запуск приложения в докер-контейнере
1) создать `.env.docker` файл, в котором указать `ACTIVE_PROFILES=docker`
2) собрать образ и запустить via docker compose
```shell
mvn clean package -Pdocker && docker compose build && docker compose --env-file .env.docker up
```