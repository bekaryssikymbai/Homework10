package com.narxoz.rpg.quest;

import java.util.List;

public class ReverseQuestIterator implements QuestIterator {
    private List<Quest> snapshot;
    private int cursor;

    public ReverseQuestIterator(QuestLog log) {
        this.snapshot = log.snapshot();
        this.cursor = snapshot.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return cursor >= 0;
    }

    @Override
    public Quest next() {
        if (!hasNext()) {
            return null;
        }
        return snapshot.get(cursor--);
    }
}