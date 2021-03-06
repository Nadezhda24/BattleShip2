***Battleship***
=====================================

**`Назначения разработки`** 

Функциональным назначением программы является развлекательная функция.
Программа может эксплуатироваться в домашних условиях. Конечные потребители – обычные люди, не нуждающиеся в дополнительном инструктаже и обучении.


------------
**`Требования к программе`**

Игра – массовая онлайновая, жанр игры - стратегия. Визуальное представление – двумерное.

Battleship - всеми любимая с детства настольная игра с новыми возможностями. При первом запуске игроку необходимо зарегистрироваться для входа в игру. При регистрации он указывает свое имя, электронную почту и пароль. 

-----------------
 После аутентификации пользователь попадает в меню, где он может:
 + посмотреть или изменить личные данные в профиле, нажав на свое имя, а именно:
	- имя пользователя
	- фото профиля
	- опыт, то есть кол-во набранных очков
	- рейтинг
	- количество игр
	- количество монет (вертуальная валюта), необходимая для покупки боевых припасов;
 + начать игру с другим пользователем, нажав "играть";
 + ознакомиться с правилами игры более подробно, выбрав кнопку "помощь";
 + выйти из игры, нажав "выход";

------------
**Правила игры**
 
 Данная игра предназначена для двух участников, в которой игроки по очереди выбирают координаты на неизвестной им карте соперника. Если у соперника по этим координатам имеется корабль (координаты заняты), то корабль или его часть «топится», а попавший получает право сделать ещё один ход. При это игрок, чей корабль был "подбит", может изменить расположение корабля (трехпалубного и четырехпалубного) относительно первой пораженной клетки,то есть повернуть его по часовой или против часовой стрелки. Перед каждым ходом игрок имеет право переместить свой корабль на любую клетку, не просмотренную противником. Цель игрока — первым потопить все корабли противника.
 
 Каждый из игроков имеет право перед началом игры запустить или не запустить, по желанию пользователя, на поле противника "пиратский корабль", который размещает 5 мин,так что противник не знает их расположения на протяжении всей игры.  

------------
*Правила размещения кораблей*
 
 Игровое поле — квадрат 10×10 у каждого игрока, на котором размещается флот кораблей:
  + 1 корабль — ряд из 4 клеток («четырёхпалубный»; линкор)
  + 2 корабля — ряд из 3 клеток («трёхпалубные»; крейсера)
  + 3 корабля — ряд из 2 клеток («двухпалубные»; эсминцы)
  + 4 корабля — 1 клетка («однопалубные»; торпедные катера)
 
 Размещение кораблей устанавливает пользователь или может задаваться рандомно.

 После этого на поле размещается некоторое количество сундуков с бонусами(от 1 до 3):
  + монеты (100, 200, 300);
  + боевые припасы ("сильное уничтожение", "свеча", "исцеление", "бомба"); 
  + захват пиратами, то есть игрок пропускает ход
  
  При размещении корабли не могут касаться друг друга сторонами и углами.

------------
*Боевые припасы:*

 Боевой припас применяется перед ходом и действует только в его течении.
 + `сильное уничтожение` - при попадании в корабль противника уничтожается весь корабль, иначе ничего не происходит;
 + `свеча` - открывает часть поля противника, размером 3х3, игроку на 5 секунд;
 + `бомба` - при попадании на поля противника поражает область размером 3х3;
 + `исцелении` - восстанавливает "подбитый" корабль;
	
------------
*Рейтинг и звания*

 Каждый игрок за сражение получает опредленные очки и в зависимости от данных очков получает звания:

 + матрос;
 + старшина 2 статьи;
 + старшина 1 статьи;
 + главный старшина;
 + главный корабельный старшина;
 + мичман;
 + старший мичман;
 + мл. лейтенант;
 + лейтенант;
 + ст. лейтенант;
 + капитан 1-го ранга;
 + контр-адмирал;
 + вице-адмирал;
 + адмирал;
 + адмирал флота;

 Если во время поиска противника игру ожидают более двух игроков, то выбирается пара с одинаковыми или близкими званиями. 
 Очки за победу зависят от звания противника. Так если звание противника выше, то значение увеличивается в зависимости от коэффициента, а если меньше или равно, то остается стандартным.
 
 
 ------------------
 
 **`Требования к организации входных данных`**
 
Входные данные: игровые настройки пользователя (включение и отключение уведомлений,звука), а также непосредственное управление во время игрового процесса с помощью экрана мобильного телефона. Игровой процесс состоит из последовательности фиксированных моментов времени, именуемых ходами (или шагами), во время которых игроки совершают свои действия.

 ------------------
 
 **`Требования к организации выходных данных`**
 
Выходным результатом является рейтинг игроков по количеству набранных очков за победы в играх.

-----------------
 
 **`Условия эксплуатации`** 
 
Программа предназначена для эксплуатации на Android  как мобильное приложение.

-----------------
 
**`Требования к видам облуживания`** 

Приложение не требует проведения каких-либо видов обслуживания.

-----------------
 
**`Требование к составу и параметрам технических средств`**

Мобильное устройство с операционной системой Android 7.0 и выше.

-----------------
 
 **`Требования к исходным кодам и языкам программирования`**
 
Исходные коды программы должны быть реализованные на языке Java. В качестве интегрированной среды разработки программы должна быть использована сред Android Studioа.

-----------------
 **`Специальные требования`**
 
Программа должна обеспечивать взаимодействие с пользователем посредством графического пользовательского интерфейса.
