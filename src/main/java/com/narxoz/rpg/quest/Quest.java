package com.narxoz.rpg.quest;

public class Quest {
    private String name;
    private QuestPriority priority;
    private int reward;
    private String location;

    public Quest(String name, QuestPriority priority, int reward, String location) {
        this.name = name;
        this.priority = priority;
        this.reward = reward;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public QuestPriority getPriority() {
        return priority;
    }

    public int getReward() {
        return reward;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return name + " [" + priority + "] - " + reward + " gold at " + location;
    }
}