# language: ru
@all
Функция: PetClinic

  Сценарий: Изменение имени клиента
    Пусть запущен браузер Firefox
    И введен адрес "http://localhost:8080/"
    И произведен клик по меню "find owners"
    И в поле "Last name" введено "Black"
    И нажать кнопку, начинающуюся с "Find"
    И нажать кнопку, начинающуюся с "Edit"

    И запомнить произвольное слово из 6 букв как "имя"
    И в поле "First Name" введено запомненное "имя"

    И запомнить текст поля ввода "Address" как "адрес"
    И запомнить текст поля ввода "City" как "город"
    И запомнить текст поля ввода "Telephone" как "телефон"
    И нажать кнопку, начинающуюся с "Update"

    Тогда в таблице в строке "Name" значится запомненное "имя" дополненное словом " Black"
    И в таблице в строке "Address" значится запомненный "адрес"
    И в таблице в строке "City" значится запомненный "город"
    И в таблице в строке "Telephone" значится запомненный "телефон"

    Тогда закрываем браузер

