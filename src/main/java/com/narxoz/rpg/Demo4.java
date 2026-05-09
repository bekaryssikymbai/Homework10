package com.narxoz.rpg;

import com.narxoz.rpg.quest.*;
import com.narxoz.rpg.guild.*;
import java.util.*;

public class Demo4 {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║     ДЕНЬ 4: OPEN/CLOSED PROOF - РАСШИРЕНИЯ БЕЗ ИЗМЕНЕНИЯ КОДА    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");

        // ==================== ЧАСТЬ 1: НОВЫЙ ИТЕРАТОР ====================
        System.out.println("\n🔧 ЧАСТЬ 1: НОВЫЙ ТИП ИТЕРАТОРА (RewardSortedQuestIterator)");
        System.out.println("   " + "=".repeat(55));

        QuestLog questLog = new QuestLog();
        questLog.addQuest(new Quest("Спасти деревню", QuestPriority.HIGH, 500, "Темный лес"));
        questLog.addQuest(new Quest("Победить дракона", QuestPriority.URGENT, 2000, "Гора"));
        questLog.addQuest(new Quest("Найти артефакт", QuestPriority.NORMAL, 300, "Руины"));
        questLog.addQuest(new Quest("Сопроводить купца", QuestPriority.LOW, 150, "Путь"));
        questLog.addQuest(new Quest("Защитить замок", QuestPriority.URGENT, 1000, "Замок"));
        questLog.addQuest(new Quest("Собрать травы", QuestPriority.NORMAL, 75, "Лес"));

        System.out.println("\n📊 Квесты в порядке УБЫВАНИЯ награды (НОВЫЙ итератор!):");
        System.out.println("   " + "-".repeat(50));

        QuestIterator rewardIter = questLog.rewardSorted();
        int rank = 1;
        while (rewardIter.hasNext()) {
            Quest q = rewardIter.next();
            System.out.printf("   %d. %-25s - %5d золота %s%n",
                    rank++, q.getName(), q.getReward(), "💰");
        }

        System.out.println("\n✅ ДОКАЗАТЕЛЬСТВО: Новый итератор добавлен БЕЗ изменения существующего кода!");

        // ==================== ЧАСТЬ 2: НОВЫЙ УЧАСТНИК ====================
        System.out.println("\n\n🔧 ЧАСТЬ 2: НОВЫЙ УЧАСТНИК ГИЛЬДИИ (Loremaster)");
        System.out.println("   " + "=".repeat(55));

        GuildHall hall = new GuildHall();

        // Старые участники
        new Quartermaster("Бертран (Интендант)", hall);
        new Scout("Леголас (Разведчик)", hall);
        new Healer("Элендил (Целитель)", hall);
        Captain captain = new Captain("Арагорн (Капитан)", hall);

        // НОВЫЙ участник - Хранитель знаний
        Loremaster loremaster = new Loremaster("Эльронд (Хранитель знаний)", hall);

        System.out.println("\n📢 Демонстрация работы НОВОГО участника:");
        System.out.println("   " + "-".repeat(50));

        // Капитан запрашивает план
        System.out.println("\n   1) Капитан запрашивает план:");
        captain.requestPlanForQuest("Поход в Морию");

        // Хранитель знаний делится знаниями
        System.out.println("\n   2) Хранитель знаний делится древними знаниями:");
        loremaster.shareLore("В Мории обитает древний балрог - огненный демон");

        System.out.println("\n   3) Хранитель знаний предупреждает о проклятии:");
        loremaster.warnOfCurse("Артефакт проклят - никто не может его носить");

        System.out.println("\n   4) Хранитель знаний делится историей:");
        loremaster.shareHistory("Мория была великим королевством гномов");

        System.out.println("\n✅ ДОКАЗАТЕЛЬСТВО: Новый участник добавлен БЕЗ изменения существующих участников!");

        // ==================== ЧАСТЬ 3: СРАВНЕНИЕ ВСЕХ ИТЕРАТОРОВ ====================
        System.out.println("\n\n📊 ЧАСТЬ 3: СРАВНЕНИЕ ВСЕХ 4 ТИПОВ ИТЕРАТОРОВ");
        System.out.println("   " + "=".repeat(55));

        // 1. Ordered Iterator
        System.out.println("\n   1️⃣ ORDERED (порядок добавления):");
        QuestIterator iter = questLog.ordered();
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("      • " + q.getName());
        }

        // 2. Reverse Iterator
        System.out.println("\n   2️⃣ REVERSE (обратный порядок):");
        iter = questLog.reverse();
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("      • " + q.getName());
        }

        // 3. Priority Iterator
        System.out.println("\n   3️⃣ PRIORITY (только HIGH+):");
        iter = questLog.priorityAtLeast(QuestPriority.HIGH);
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("      • " + q.getName() + " [" + q.getPriority() + "]");
        }

        // 4. Reward Sorted Iterator (НОВЫЙ!)
        System.out.println("\n   4️⃣ REWARD SORTED (по награде) - НОВЫЙ!");
        iter = questLog.rewardSorted();
        while (iter.hasNext()) {
            Quest q = iter.next();
            System.out.println("      • " + q.getName() + " - " + q.getReward() + "💰");
        }

        // ==================== ИТОГИ ====================
        System.out.println("\n\n🎉🎉🎉 ДЕНЬ 4 УСПЕШНО ЗАВЕРШЕН! 🎉🎉🎉");
        System.out.println("\n📋 ЧТО БЫЛО СДЕЛАНО:");
        System.out.println("   ✅ Добавлен новый тип итератора - RewardSortedQuestIterator");
        System.out.println("   ✅ Добавлен новый участник гильдии - Loremaster");
        System.out.println("   ✅ Доказан Open/Closed Principle");


}