package com.narxoz.rpg.guild;

import java.util.Arrays;
import java.util.List;

public class Scout extends GuildMember {

    public Scout(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        if (topic.equals("recon")) {
            System.out.println("[Разведчик " + getName() + "] 🔍 Запрос разведки: " + payload);
            System.out.println("[Разведчик " + getName() + "] 📡 Собираю информацию...");
        } else if (topic.equals("planning")) {
            System.out.println("[Разведчик " + getName() + "] 🗺️ Передаю данные о: " + payload);
        }
    }

    @Override
    public List<String> getSubscribedTopics() {
        return Arrays.asList("recon", "planning");
    }

    public void reportIntel(String intel) {
        getMediator().dispatch("recon", this, "Данные: " + intel);
    }

    public void scoutLocation(String location) {
        getMediator().dispatch("planning", this, "Разведка локации: " + location);
    }
}