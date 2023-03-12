import java.util.Random;

public class Hero {
    String name;
    int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void attack(Hero opponent) {
        Random random = new Random();
        if (random.nextDouble(1) < 0.5)
            opponent.hitPoints -= 10;
        else
            hitPoints -= 10;
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    public void fightUntilTheDeathHelper(Hero opponent) {
        while (hitPoints != 0 && opponent.getHitPoints() != 0)
            attack(opponent);
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "        " + opponent.getName() + ": " + opponent.getHitPoints();
    }

    public int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int[] score = new int[2];
        for (int i = 0; i < n; i++) {
            String result = fightUntilTheDeath(opponent);
            int colonOneIndex = result.indexOf(":");
            int colonTwoIndex = result.indexOf(":", colonOneIndex + 1);
            int heroHealth = Integer.parseInt(result.substring(colonOneIndex + 2, colonOneIndex + 3));
            int opponentHealth = Integer.parseInt(result.substring(colonTwoIndex + 2, colonTwoIndex + 3));

            if (heroHealth > opponentHealth)
                score[0]++;
            else
                score[1]++;
        }
        return score;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] score = nFightsToTheDeathHelper(opponent, n);
        if (score[0] > score[1]) {
            return name + ": " + score[0] + " wins\n" + opponent.getName() + ": " + score[1] + " wins\n" + name + " wins!";
        }
        else {
            return name + ": " + score[0] + " wins\n" + opponent.getName() + ": " + score[1] + " wins\n" + opponent.getName() + " wins!";
        }
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        while (hitPoints != 0 && opponent.getHitPoints() != 0) {
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "        " + opponent.getName() + ": " + opponent.getHitPoints());
        }
    }





}
