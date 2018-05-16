public class Warrior extends Human implements visionImpaired {

    public Warrior(String name) {
        super(name, 1.0, .9, .9, 1.2, .9);
    }

    @Override
    String attackMessage() {
        String attack ;
        if (Math.random()> .40){
            attack = "Swings a massive sword";
        }else{
            attack = "Thrusts a sword";
        }
        return attack;
    }


    @Override
    public double calculateImpairment() {
        return armorStrength/2;
    }

    @Override
    public String toString() {
        String result;
        result = String.format("%s the Warrior, id = %d, health = %f, speed = %f, agility = %f, strength = %f, armorstrength = %f",
                name, id, health, speed, agility, strength, armorStrength);
        return result;
    }
}
