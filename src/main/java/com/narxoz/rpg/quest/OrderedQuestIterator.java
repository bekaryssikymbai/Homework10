package com.narxoz.rpg.quest;

import java.util.List;

public class OrderedQuestIterator implements QuestIterator {
    private List<Quest> snapshot;
    private int cursor = 0;

    public OrderedQuestIterator(QuestLog log) {
        this.snapshot = log.snapshot();
    }

    @Override
    public boolean hasNext() {
        return cursor < snapshot.size();
    }

    @Override
    public Quest next() {
        if (!hasNext()) {
            return null;
        }
        return snapshot.get(cursor++);
    }
}