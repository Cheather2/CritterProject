public class Soldier extends Human {


    public Soldier(String name, double strength) {
        super(name, 1.0, 1.0, 1.0, strength, 0);
    }

    @Override
    String attackMessage() {
        return "Thrusts a spear";
    }

    @Override
    public String toString() {
            String result;
            result = String.format("%s the Soldier, id = %d, health = %f, speed = %f, agility = %f, strength = %f, armorstrength = %f",
                    name, id, health, speed, agility, strength, armorStrength);
            return result;
        }
}
