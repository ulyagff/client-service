# client service module
Клиент состоит из 2 частей:
- command line utility 
- бизнес логика, где посылаем http запросы на сервер

Командная строка принимает команды:
- set {key} {value} (добавление новой пары ключ-значение)
- get {key} (получение существующей пары ключ значение)
  
