## [REST API](http://localhost:8080/doc)

## Концепция:

- Spring Modulith
    - [Spring Modulith: достигли ли мы зрелости модульности](https://habr.com/ru/post/701984/)
    - [Introducing Spring Modulith](https://spring.io/blog/2022/10/21/introducing-spring-modulith)
    - [Spring Modulith - Reference documentation](https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```

- Есть 2 общие таблицы, на которых не fk
    - _Reference_ - справочник. Связь делаем по _code_ (по id нельзя, тк id привязано к окружению-конкретной базе)
    - _UserBelong_ - привязка юзеров с типом (owner, lead, ...) к объекту (таска, проект, спринт, ...). FK вручную будем
      проверять

## Аналоги

- https://java-source.net/open-source/issue-trackers

## Тестирование

- https://habr.com/ru/articles/259055/

Список выполненных задач:
Разобраться со структурой проекта (onboarding).
Удалить социальные сети: vk, yandex. +
  Удалил сети.
Вынести чувствительную информацию в отдельный проперти файл +
  Добавил application.properties в resources
Сделать рефакторинг метода com.javarush.jira.bugtracking.attachment.FileUtil#upload чтоб он использовал современный подход для работы с файловой системмой.
  Переделал метод на использование библиотеки java.nio.file
Добавить новый функционал: добавления тегов к задаче (REST API + реализация на сервисе). Фронт делать необязательно. Таблица task_tag уже создана. +
  Сделал Entity Tag(использует TagId для состовного ключа) Контроллер TagController, Сервис TagService и репозиторий TagRepository.
  Контроллер позволяет:
    получить список всех тегов.
    получить список тегов конкретной задачи
    добавить конкретной задаче тег.
  Фронт не делал.
Написать Dockerfile для основного сервера
  Сделал Dockerfile
Написать docker-compose файл для запуска контейнера сервера вместе с БД и nginx. Для nginx используй конфиг-файл config/nginx.conf.
  Написал docker-compose файл.
  Файл конфига nginx.conf не изменял.
  В конфигурации прописал запуск с параметром prod: - SPRING_PROFILES_ACTIVE=prod