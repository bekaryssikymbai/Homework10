package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class RewardSortedQuestIterator implements QuestIterator {
    private List<Quest> sortedSnapshot;
    private int cursor = 0;

    public RewardSortedQuestIterator(QuestLog log) {
        this.sortedSnapshot = new ArrayList<>(log.snapshot());
        // Сортировка по награде (от большего к меньшему)
        sortedSnapshot.sort((q1, q2) -> Integer.compare(q2.getReward(), q1.getReward()));
    }

    @Override
    public boolean hasNext() {
        return cursor < sortedSnapshot.size();
    }

    @Override
    public Quest next() {
        if (!hasNext()) {
            return null;
        }
        return sortedSnapshot.get(cursor++);
    }
}