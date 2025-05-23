# Инструкция по запуску автоматических тестов

## 1. Необходимые условия

Перед началом выполнения автоматических тестов убедитесь, что выполнены следующие условия:

- Установлена актуальная версия Android Studio.
- Инсталлирован Android SDK.
- Проект правильно собран и успешно запускается.
- Для тестирования подключены необходимые библиотеки: Espresso и UIAutomator.
- Подключено тестируемое устройство или настроен виртуальный эмулятор.

## 2. Подготовка среды

1. Откройте проект в Android Studio.
2. Проверьте, что в файле `build.gradle` корректно указан тестовый модуль.
3. Убедитесь, что ваше устройство или эмулятор активно.
4. Выполните сборку проекта с помощью команды:
  ./gradlew assembleDebug
5. Выполните сборку тестов:
  ./gradlew assembleAndroidTest

## 3. Запуск тестов через Android Studio

1. Перейдите в меню `Run` > `Edit Configurations`.
2. Выберите конфигурацию `Android Instrumented Tests`.
3. Укажите нужный тестовый класс или пакет.
4. Нажмите `Run`.

## 4. Запуск тестов из терминала

Для выполнения всех тестов используйте команду:
./gradlew connectedAndroidTest

## 5. Просмотр результатов тестирования

Отчёт о прохождении тестов доступен в виде файла `allure-results.zip`. Этот файл содержит результаты в формате отчёта Allure.

