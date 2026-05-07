package com.narxoz.rpg.guild;

import java.util.Arrays;
import java.util.List;

public class Quartermaster extends GuildMember {

    public Quartermaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        if (topic.equals("supplies")) {
            System.out.println("[Интендант " + getName() + "] Получен запрос: " + payload);
            System.out.println("[Интендант " + getName() + "] ✅ Выдаю припасы!");
        } else if (topic.equals("planning")) {
            System.out.println("[Интендант " + getName() + "] 📦 Готовлю снаряжение для: " + payload);
        }
    }

    @Override
    public List<String> getSubscribedTopics() {
        return Arrays.asList("supplies", "planning");
    }

    public void requestSupplies(String item) {
        getMediator().dispatch("supplies", this, "Нужно: " + item);
    }
}