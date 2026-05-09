package com.narxoz.rpg.guild;

import java.util.Arrays;
import java.util.List;

public class Loremaster extends GuildMember {

    // ✅ ВАЖНО: Добавьте этот конструктор!
    public Loremaster(String name, GuildMediator mediator) {
        super(name, mediator);  // Вызываем конструктор родителя
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        if (topic.equals("lore")) {
            System.out.println("[Хранитель знаний " + getName() + "] 📖 Древнее знание: " + payload);
            System.out.println("[Хранитель знаний " + getName() + "] Записываю в свиток...");
        } else if (topic.equals("curse")) {
            System.out.println("[Хранитель знаний " + getName() + "] ⚠️ ПРЕДУПРЕЖДЕНИЕ О ПРОКЛЯТИИ: " + payload);
            System.out.println("[Хранитель знаний " + getName() + "] 🔮 Ищу способ снятия проклятия...");
        } else if (topic.equals("history")) {
            System.out.println("[Хранитель знаний " + getName() + "] 📜 Историческая справка: " + payload);
        } else if (topic.equals("planning")) {
            System.out.println("[Хранитель знаний " + getName() + "] 🏛️ Предоставляю архивные данные для: " + payload);
        }
    }

    @Override
    public List<String> getSubscribedTopics() {
        return Arrays.asList("lore", "curse", "history", "planning");
    }

    // Outbound convenience methods
    public void shareLore(String lore) {
        getMediator().dispatch("lore", this, lore);
    }

    public void warnOfCurse(String curse) {
        getMediator().dispatch("curse", this, curse);
    }

    public void shareHistory(String history) {
        getMediator().dispatch("history", this, history);
    }
}