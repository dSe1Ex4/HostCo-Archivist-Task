<img src="https://repository-images.githubusercontent.com/278657424/24fe8500-c6bd-11ea-9c0f-04640e0f6129" title="FVCproductions" alt="FVCproductions">

# Тестовое задания для комании HostCo
---

### Первый запуск

1) Настройте файл application.yml (см. [Файл конфигурации](#файл-конфигурации))
2) Собрать Maven проект
```shell
$ mvn clean install
```
3) Бек сервер готов к использованию
---

## Файл конфигурации
> src\main\resources\application.yml

- Настройки SOAP
```YML
app:
    SOAP:
        Token: "D468E929-A94E-4F16-A7D2-DB414EC53071"
        BaseReqURL: "http://www.hostco.ru/reguser"
        URL: "https://cas-test.hostco.ru/RegUserService/services/RegUserService"
```

- Настройки REST
```YML
    REST:
        ServiceURL: "http://localhost:8112"
```

- Настройки подключения к БД
```YML

spring:
    datasource:
        driver-class-name: org.postgresql.Driver
        url: jdbc:postgresql://localhost:5432/archidb
        username: archi
        password: 1234
    flyway:
        url: jdbc:postgresql://localhost:5432/archidb
        user: postgres
        password: 1234
```

- Debug настройки (включены по-умолчанию)
```YML
server:
    error.include-message: always

logging.level.org.springframework.ws: TRACE
```

