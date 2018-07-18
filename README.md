[![Build Status](https://travis-ci.org/mifodiy4j/trafficControlDot.svg?branch=master)](https://travis-ci.org/mifodiy4j/trafficControlDot)


# trafficControlDot

Управление.

Рассмотрим выпуклую область на плоскости X — Y.
Пусть имеется некоторая начальная точка (x0,y0).
Далее, пусть была выбрана некоторая конечная точка (x1,y1).
Обе точки принадлежат области. Мы можем выдавать команды двух типов:
1. Сделать шаг по координате x вправо или влево, причем величина шага
не может быть больше, чем некоторый фиксированный максимальный размер шага dxmax.
2. Сделать шаг по координате y вниз или вверх, причем величина шага
не может быть больше, чем некоторый фиксированный максимальный размер шага dymax.
То есть по сути мы можем перемещаться по горизонтали и по вертикали на произвольные,
но не слишком большие расстояния. За одну команду мы можем сделать шаг по горизонтали
ИЛИ по вертикали, но не одновременно.
ЗАПРЕЩЕНО делать такие шаги, которые выводили бы нас за пределы области.
Вопросы:
1. Придумайте алгоритм, с помощью которого будет сгенерирована последовательность команд,
приводящая нас из начальной точки в конечную.
2. Для любой ли допустимой области (не обязательно такой, как изображено на рисунке,
но обязательно выпуклой) возможно найти такую последовательность шагов?
3. Придумайте алгоритм, с помощью которого будет сгенерирована последовательность команд,
приводящая нас из начальной точки в конечную, но с дополнительным условием, что величина
шагов не может меньше, чем некоторые фиксированные минимальные размеры шага dxmin, dymin.