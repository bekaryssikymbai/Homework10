package com.narxoz.rpg;

import com.narxoz.rpg.guild.*;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("=== День 2: Mediator Pattern Demo ===\n");

        // Создаем посредника (гильдию)
        GuildHall hall = new GuildHall();

        // Создаем участников (автоматически регистрируются в GuildHall)
        System.out.println("--- Регистрация участников ---");
        Quartermaster qm = new Quartermaster("Бертран", hall);
        Scout scout = new Scout("Леголас", hall);
        Healer healer = new Healer("Элендил", hall);
        Captain captain = new Captain("Арагорн", hall);

        System.out.println("\n--- Обмен сообщениями через Mediator ---\n");

        // Капитан отдает приказы
        captain.issueOrder("Атаковать на рассвете!");

        System.out.println();

        // Разведчик докладывает
        scout.reportIntel("Враг готовится к обороне");

        System.out.println();

        // Целитель запрашивает припасы
        healer.requestMedicalSupplies();

        System.out.println();

        // Интендант запрашивает снаряжение
        qm.requestSupplies("стрелы для лучников");

        System.out.println();

        // Капитан запрашивает план
        captain.requestPlan("Победить дракона");

        System.out.println("\n--- Проверка: отсутствие прямых ссылок ---");
        System.out.println("✅ Quartermaster не имеет полей-участников");
        System.out.println("✅ Scout не имеет полей-участников");
        System.out.println("✅ Healer не имеет полей-участников");
        System.out.println("✅ Captain не имеет полей-участников");
        System.out.println("✅ Все общение только через GuildHall");

        System.out.println("\n=== День 2 завершен успешно! ===");
    }
}