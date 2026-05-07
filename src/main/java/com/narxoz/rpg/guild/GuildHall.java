package com.narxoz.rpg.guild;

import java.util.*;

public class GuildHall implements GuildMediator {
    private Map<String, List<GuildMember>> subscribers = new HashMap<>();

    @Override
    public void register(GuildMember member) {
        for (String topic : member.getSubscribedTopics()) {
            subscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(member);
        }
        System.out.println("[GuildHall] Зарегистрирован: " + member.getName());
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        System.out.println("[GuildHall] Маршрутизация '" + topic + "' от " + from.getName() + ": " + payload);

        List<GuildMember> members = subscribers.get(topic);
        if (members != null) {
            for (GuildMember member : members) {
                member.receive(topic, from, payload);
            }
        }
    }
}