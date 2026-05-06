package com.narxoz.rpg;

import com.narxoz.rpg.quest.*;
import java.util.List;
public class Demo {
    public static void main(String[] args) {
        System.out.println("=== День 1: Iterator Pattern Demo ===\n");

        // Создаем квесты
        QuestLog questLog = new QuestLog();
        questLog.addQuest(new Quest("Спасти деревню", QuestPriority.HIGH, 500, "Темный лес"));
        questLog.addQuest(new Quest("Победить дракона", QuestPriority.URGENT, 2000, "Гора дракона"));
        questLog.addQuest(new Quest("Найти артефакт", QuestPriority.NORMAL, 300, "Древние руины"));
        questLog.addQuest(new Quest("Сопроводить купца", QuestPriority.LOW, 150, "Торговый путь"));
        questLog.addQuest(new Quest("Защитить замок", QuestPriority.URGENT, 1000, "Ворота замка"));

        // Демо 1: Прямой порядок
        System.out.println("1. Квесты в порядке добавления:");
        QuestIterator iter = questLog.ordered();
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("   - " + q.getName() + " [" + q.getPriority() + "]");
        }

        // Демо 2: Обратный порядок
        System.out.println("\n2. Квесты в обратном порядке:");
        iter = questLog.reverse();
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("   - " + q.getName());
        }

        // Демо 3: Фильтр по приоритету
        System.out.println("\n3. Срочные квесты (HIGH и выше):");
        iter = questLog.priorityAtLeast(QuestPriority.HIGH);
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("   - " + q.getName() + " [" + q.getPriority() + "] - " + q.getReward() + " золота");
        }
    }
}