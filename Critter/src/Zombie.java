public class Zombie extends Human implements visionImpaired{


    public Zombie() {
        super("Zeke the Zombie", .5, .5, .25, 2.0, 0.0);
    }


    @Override
    String attackMessage() {
        return "BITES";
    }

    @Override
    public double calculateImpairment() {
        return 1.0 - health;
    }

    @Override
    public String toString() {
        String result;
        result = String.format("%s, id = %d, health = %f, speed = %f, agility = %f, strength = %f, armorstrength = %f",
                name, id, health, speed, agility, strength, armorStrength);
        return result;
    }
}
