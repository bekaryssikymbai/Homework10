package com.narxoz.rpg;

import com.narxoz.rpg.quest.*;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.*;
import java.util.*;

public class Demo3 {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     ДЕНЬ 3: ИНТЕГРАЦИЯ ITERATOR + MEDIATOR                 ║");
        System.out.println("║              Военный Совет Гильдии                         ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        // 1. СОЗДАЕМ ГЕРОЕВ
        List<Hero> heroes = Arrays.asList(
                new Hero("Арагорн", 120, 25),
                new Hero("Гимли", 150, 20),
                new Hero("Леголас", 90, 30),
                new Hero("Гэндальф", 100, 35)
        );

        // 2. СОЗДАЕМ КВЕСТЫ
        QuestLog questLog = new QuestLog();
        questLog.addQuest(new Quest("Спасти деревню от бандитов", QuestPriority.HIGH, 500, "Темный лес"));
        questLog.addQuest(new Quest("Убить дракона", QuestPriority.URGENT, 2000, "Гора Дракона"));
        questLog.addQuest(new Quest("Найти древний артефакт", QuestPriority.NORMAL, 300, "Забытые руины"));
        questLog.addQuest(new Quest("Сопроводить караван", QuestPriority.LOW, 150, "Торговый путь"));
        questLog.addQuest(new Quest("Защитить замок от орков", QuestPriority.URGENT, 1000, "Ворота замка"));

        // 3. СОЗДАЕМ MEDIATOR
        GuildHall hall = new GuildHall();

        System.out.println("\n📢 РЕГИСТРАЦИЯ УЧАСТНИКОВ ГИЛЬДИИ:");
        System.out.println("   " + "-".repeat(40));

        Quartermaster qm = new Quartermaster("Бертран", hall);
        Scout scout = new Scout("Леголас", hall);
        Healer healer = new Healer("Элендил", hall);
        Captain captain = new Captain("Арагорн", hall);

        System.out.println("\n   ✅ Все участники зарегистрированы!");

        // 4. ДЕМО ITERATOR PATTERN
        System.out.println("\n📜 ДЕМО ITERATOR PATTERN:");
        System.out.println("   " + "-".repeat(40));

        System.out.println("\n   А) Прямой порядок:");
        QuestIterator iter = questLog.ordered();
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("      • " + q.getName() + " - " + q.getPriority());
        }

        System.out.println("\n   Б) Обратный порядок:");
        iter = questLog.reverse();
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("      • " + q.getName());
        }

        System.out.println("\n   В) Только HIGH и URGENT:");
        iter = questLog.priorityAtLeast(QuestPriority.HIGH);
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("      • " + q.getName() + " [" + q.getPriority() + "] - " + q.getReward() + " золота");
        }

        // 5. ДЕМО MEDIATOR PATTERN
        System.out.println("\n🤝 ДЕМО MEDIATOR PATTERN:");
        System.out.println("   " + "-".repeat(40));

        System.out.println("\n   Капитан отдает приказ:");
        captain.issueOrder("Атаковать дракона на рассвете!");

        System.out.println("\n   Разведчик докладывает:");
        scout.reportIntel("Дракон ослаблен, возможно ранен");

        System.out.println("\n   Целитель запрашивает припасы:");
        healer.requestMedicalSupplies();

        System.out.println("\n   Интендант выдает снаряжение:");
        qm.requestSupplies("Стрелы и зелья");

        System.out.println("\n   Капитан запрашивает план:");
        captain.requestPlanForQuest("Убить дракона");

        // 6. ПОДСЧЕТ РЕЗУЛЬТАТОВ
        int totalQuests = 0;
        int totalGold = 0;
        int urgentQuests = 0;

        iter = questLog.ordered();
        while (iter.hasNext()) {
            Quest q = iter.next();
            totalQuests++;
            totalGold += q.getReward();
            if (q.getPriority() == QuestPriority.URGENT || q.getPriority() == QuestPriority.HIGH) {
                urgentQuests++;
            }
        }

        System.out.println("\n📊 ИТОГИ ВОЕННОГО СОВЕТА:");
        System.out.println("   • Всего квестов: " + totalQuests);
        System.out.println("   • Срочных квестов: " + urgentQuests);
        System.out.println("   • Потенциальная награда: " + totalGold + " золота");

        System.out.println("\n ДЕНЬ 3  ЗАВЕРШЕН! ");
    }
}