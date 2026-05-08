package com.narxoz.rpg.council;

import com.narxoz.rpg.quest.*;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public class CouncilEngine {

    // Сохраняем ссылки на участников для отправки сообщений
    private Captain captain;
    private Scout scout;
    private Quartermaster quartermaster;
    private Healer healer;

    public CouncilRunResult runCouncil(List<Hero> heroes, QuestLog questLog, GuildMediator mediator) {
        System.out.println("\n🏛️ ВОЕННЫЙ СОВЕТ НАЧИНАЕТСЯ 🏛️\n");

        // Находим участников в медиаторе (упрощенный способ)
        // В реальном коде нужно получить их из mediator, но для демо создадим здесь
        if (captain == null) {
            captain = new Captain("Арагорн (Капитан)", (GuildHall) mediator);
            scout = new Scout("Леголас (Разведчик)", (GuildHall) mediator);
            quartermaster = new Quartermaster("Бертран (Интендант)", (GuildHall) mediator);
            healer = new Healer("Элендил (Целитель)", (GuildHall) mediator);
        }

        // Показываем героев
        System.out.println("👥 Участники совета:");
        for (Hero hero : heroes) {
            System.out.println("   • " + hero);
        }

        int totalReward = 0;
        int questCount = 0;
        int urgentCount = 0;

        // ДЕМО 1: Обход всех квестов в порядке прибытия (Iterator Pattern)
        System.out.println("\n📜 1. ОБЗОР ВСЕХ КВЕСТОВ (порядок прибытия):");
        System.out.println("   " + "-".repeat(50));

        QuestIterator orderedIter = questLog.ordered();
        while (orderedIter.hasNext()) {
            Quest quest = orderedIter.next();
            questCount++;
            totalReward += quest.getReward();

            System.out.println("   📌 " + quest.getName());
            System.out.println("      Приоритет: " + quest.getPriority());
            System.out.println("      Награда: " + quest.getReward() + " золота");
            System.out.println("      Локация: " + quest.getLocation());

            // Mediator Pattern в действии - отправляем от капитана
            System.out.print("      🤝 ");
            captain.requestPlanForQuest(quest.getName());
            System.out.println();
        }

        // ДЕМО 2: Только срочные квесты (Priority Iterator)
        System.out.println("\n⚡ 2. СРОЧНЫЕ КВЕСТЫ (HIGH и URGENT):");
        System.out.println("   " + "-".repeat(50));

        QuestIterator priorityIter = questLog.priorityAtLeast(QuestPriority.HIGH);
        while (priorityIter.hasNext()) {
            Quest quest = priorityIter.next();
            urgentCount++;

            System.out.println("   🚨 " + quest.getName() + " [" + quest.getPriority() + "]");
            System.out.println("      Награда: " + quest.getReward() + " золота");

            // Отправляем срочные сообщения через разведчика
            scout.reportIntel("Срочная разведка для: " + quest.getName());
        }

        // ДЕМО 3: Обратный порядок (Reverse Iterator)
        System.out.println("\n🔄 3. КВЕСТЫ В ОБРАТНОМ ПОРЯДКЕ (от новых к старым):");
        System.out.println("   " + "-".repeat(50));

        QuestIterator reverseIter = questLog.reverse();
        while (reverseIter.hasNext()) {
            Quest quest = reverseIter.next();
            System.out.println("   • " + quest.getName());
        }

        System.out.println("\n✅ ВОЕННЫЙ СОВЕТ ЗАВЕРШЕН\n");

        return new CouncilRunResult(questCount, totalReward, urgentCount);
    }
}