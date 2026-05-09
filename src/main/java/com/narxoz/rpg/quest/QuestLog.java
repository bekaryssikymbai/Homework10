package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class QuestLog {
    private List<Quest> quests = new ArrayList<>();

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    // ТОЛЬКО ДЛЯ ВНУТРЕННЕГО ИСПОЛЬЗОВАНИЯ итераторами
    List<Quest> snapshot() {
        return new ArrayList<>(quests);
    }

    // День 1: базовые итераторы
    public QuestIterator ordered() {
        return new OrderedQuestIterator(this);
    }

    public QuestIterator reverse() {
        return new ReverseQuestIterator(this);
    }

    public QuestIterator priorityAtLeast(QuestPriority minPriority) {
        return new PriorityQuestIterator(this, minPriority);
    }// Добавьте этот метод в класс QuestLog
    public QuestIterator rewardSorted() {
        return new RewardSortedQuestIterator(this);
    }


}