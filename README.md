День	Паттерн	Результат
День 1	Iterator	3 итератора (Ordered, Reverse, Priority)
День 2	Mediator	4 участника + маршрутизация по темам
День 3	Интеграция	CouncilEngine с обоими паттернами
День 4	Open/Closed	Новый итератор + новый участник


Homework10/
├── src/main/java/com/narxoz/rpg/
│   ├── Demo1.java (или Main.java для Дня 1)
│   ├── Demo2.java (для Дня 2)
│   ├── Demo3.java (для Дня 3)
│   ├── Demo4.java (для Дня 4 - ФИНАЛЬНЫЙ)
│   ├── quest/
│   │   ├── Quest.java
│   │   ├── QuestPriority.java
│   │   ├── QuestIterator.java
│   │   ├── QuestLog.java
│   │   ├── OrderedQuestIterator.java
│   │   ├── ReverseQuestIterator.java
│   │   ├── PriorityQuestIterator.java
│   │   └── RewardSortedQuestIterator.java
│   ├── guild/
│   │   ├── GuildMediator.java
│   │   ├── GuildHall.java
│   │   ├── GuildMember.java
│   │   ├── Quartermaster.java
│   │   ├── Scout.java
│   │   ├── Healer.java
│   │   ├── Captain.java
│   │   └── Loremaster.java
│   ├── combatant/
│   │   └── Hero.java
│   └── council/
│       ├── CouncilRunResult.java
│       └── CouncilEngine.java
├── uml-iterator.md (UML диаграмма 1)
├── uml-mediator.md (UML диаграмма 2)
└── README.md
