package com.narxoz.rpg.council;

public class CouncilRunResult {
    private int questsReviewed;
    private int totalReward;
    private int urgentQuests;

    public CouncilRunResult(int questsReviewed, int totalReward, int urgentQuests) {
        this.questsReviewed = questsReviewed;
        this.totalReward = totalReward;
        this.urgentQuests = urgentQuests;
    }

    public int getQuestsReviewed() {
        return questsReviewed;
    }

    public int getTotalReward() {
        return totalReward;
    }

    public int getUrgentQuests() {
        return urgentQuests;
    }

    public void display() {
        System.out.println("\n📊 ИТОГИ ВОЕННОГО СОВЕТА:");
        System.out.println("   • Просмотрено квестов: " + questsReviewed);
        System.out.println("   • Срочных квестов: " + urgentQuests);
        System.out.println("   • Потенциальная награда: " + totalReward + " золота");
    }
}