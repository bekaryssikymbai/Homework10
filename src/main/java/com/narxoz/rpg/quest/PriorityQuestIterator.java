package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class PriorityQuestIterator implements QuestIterator {
    private List<Quest> filteredSnapshot;
    private int cursor = 0;

    public PriorityQuestIterator(QuestLog log, QuestPriority minPriority) {
        this.filteredSnapshot = new ArrayList<>();
        List<Quest> allQuests = log.snapshot();
        for (Quest quest : allQuests) {
            if (quest.getPriority().compareTo(minPriority) >= 0) {
                filteredSnapshot.add(quest);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return cursor < filteredSnapshot.size();
    }

    @Override
    public Quest next() {
        if (!hasNext()) {
            return null;
        }
        return filteredSnapshot.get(cursor++);
    }
}