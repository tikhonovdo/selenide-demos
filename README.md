# Selenide demos

---
## Disclaimer
Данный проект является набором сценариев использования selenide и сопутствующей обвязки.

Для запуска нужны:
- java 21,
- maven,
- docker (для тестов с selenoid),
- chrome for testing,
- chrome driver

### Chrome driver
Ссылки на последние два пункта, использующиеся в проекте:
- chrome for testing:
  - [win64](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/win64/chrome-win64.zip),
  - [linux64](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/linux64/chrome-linux64.zip),
  - [mac-arm64](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/mac-arm64/chrome-mac-arm64.zip),
  - [mac-x64](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/mac-x64/chrome-mac-x64.zip).
- chrome driver:
  - [win64](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/win64/chromedriver-win64.zip),
  - [linux64](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/linux64/chromedriver-linux64.zip),
  - [mac-arm64](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/mac-arm64/chromedriver-mac-arm64.zip),
  - [mac-x64](https://storage.googleapis.com/chrome-for-testing-public/134.0.6944.2/mac-x64/chromedriver-mac-x64.zip).

Другие версии можно [поискать здесь](https://googlechromelabs.github.io/chrome-for-testing/known-good-versions-with-downloads.json).

### Тесты с selenoid
Для локального запуска нужно
1) скачать требуемый образ браузера (используется в кейсах и _browsers.json_):
```shell
docker pull selenium/standalone-chromium:133.0
```
2) Требуется явно создать подсеть для selenoid,
```shell
docker network create selenoid
```
3) Собрать приложение, запустить контейнер selenoid,
```shell
docker network create selenoid
mvn clean package && docker compose build && docker compose up selenoid
```
После этого Selenoid должен быть доступен на http://localhost:4444 и можно запускать связанные с ним тесты.
