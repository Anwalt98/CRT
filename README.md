# CRT
Реализован набор автотестов для тестирования ui, имитирующего регистрационную форму веб-сайта.
В документе ТестКейсы находится тестовый сценарий, реализованный на Java.
В документе Баги находятся обнаруженные баги, согласно указанным требованиям.
В автотестах использовался Selenium. Пред и пост условия вынесены в отдельный фреймворк, как и работа с элементами и некоторыми другими элементами. Файл с тестовыми данными называется TestData.json.
Запускаются автотесты через testng.xml, командой mvn test.
Тест №2 падает, поскольку обнаружен баг - поля для обязательного заполнения при регистрации пропускают пустую строку.
