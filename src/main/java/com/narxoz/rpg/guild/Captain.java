package com.narxoz.rpg.guild;

import java.util.Arrays;
import java.util.List;

public class Captain extends GuildMember {

    public Captain(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        if (topic.equals("orders")) {
            System.out.println("[Капитан " + getName() + "] ⚔️ Получен приказ: " + payload);
            System.out.println("[Капитан " + getName() + "] 📢 Отдаю команды отряду!");
        } else if (topic.equals("planning")) {
            System.out.println("[Капитан " + getName() + "] 🎯 Разрабатываю стратегию для: " + payload);
        }
    }

    @Override
    public List<String> getSubscribedTopics() {
        return Arrays.asList("orders", "planning");
    }

    public void issueOrder(String order) {
        getMediator().dispatch("orders", this, order);
    }

    public void requestPlan(String quest) {
        getMediator().dispatch("planning", this, "План для квеста: " + quest);
    }
    public void requestPlanForQuest(String questName) {
        getMediator().dispatch("planning", this, "План для квеста: " + questName);
    }
}