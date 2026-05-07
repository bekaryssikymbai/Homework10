package com.narxoz.rpg.guild;

import java.util.Arrays;
import java.util.List;

public class Healer extends GuildMember {

    public Healer(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        if (topic.equals("medical")) {
            System.out.println("[Целитель " + getName() + "] 💊 Запрос помощи: " + payload);
            System.out.println("[Целитель " + getName() + "] 🧪 Готовлю зелья!");
        } else if (topic.equals("planning")) {
            System.out.println("[Целитель " + getName() + "] 🏥 Оцениваю риски для: " + payload);
        }
    }

    @Override
    public List<String> getSubscribedTopics() {
        return Arrays.asList("medical", "planning");
    }

    public void requestMedicalSupplies() {
        getMediator().dispatch("medical", this, "Нужны лечебные травы");
    }
}