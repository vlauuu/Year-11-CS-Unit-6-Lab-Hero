import java.util.Random;
public class Hero {


    private String name;
    private int hitPoints;

    public Hero(String name)
    {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void attack (Hero opponent)
    {
        Random rand = new Random();
        double chance = rand.nextDouble();

        if(chance < 0.5)
        {
            opponent.setHitPoints(opponent.getHitPoints() - 10);
        }

    }

    public void senzuBean()
    {
        hitPoints = 100;
    }

    public void fightUntilTheDeathHelper(Hero opponent)
    {
        hitPoints = 100;
        opponent.setHitPoints(100);

        if(hitPoints > 0 && opponent.hitPoints > 0)
        {
            Random rand = new Random();
            double chance = rand.nextDouble();

            if(chance < 0.5)
            {
                int newHP = opponent.getHitPoints() - 10;
                opponent.setHitPoints(newHP);
            }

            Random rand2 = new Random();
            double chance2 = rand2.nextDouble();

            if(chance2 < 0.5)
            {
                hitPoints = hitPoints - 10;
            }
        }

    }

    public String fightUntilTheDeath(Hero opponent)
    {
        fightUntilTheDeathHelper(opponent);

        String output = name + ":" + hitPoints + "      " + opponent.getName() + ":" + opponent.getHitPoints();
        return output;

    }

    public int[] nFightsToTheDeathHelper(Hero opponent, int n)
    {
        int win = 0;
        int lose = 0;

        for(int count = 1; count <= n; count ++)
        {
            hitPoints = 100;
            opponent.senzuBean();
            fightUntilTheDeathHelper(opponent);

            if(hitPoints == 0)
            {
                win = win + 1;
            }
            else
            {
                lose = lose + 1;
            }

        }

        int[] output = {win, lose};

        return output;
    }

    public String nFightsToTheDeath(Hero opponent, int n){

        int[] output = nFightsToTheDeathHelper(opponent, n);

        String outputS;

        System.out.println(name + ": " + output[0] + " wins");
        System.out.println(opponent.getName() + ": " + output[1] + " wins");

        if(output[0] > output[1])
        {
            outputS = name + " wins!";
        } else if (output[0] > output[1]) {
            outputS = opponent.getName() + " wins!";
        }else {
            outputS = "OMG! It was actually a draw!";
        }

        return outputS;

    }


}
