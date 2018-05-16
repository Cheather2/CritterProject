public class Scout extends Human {


    public Scout(String name, double health, double speed, double agility, double strength) {
        super(name, health, speed, agility, strength, 0);
    }

    @Override
    String attackMessage() {
        return "Swings his fist";
    }

    @Override
    public String toString() {
        String result;
        result = String.format("%s the Scout, id = %d, health = %f, speed = %f, agility = %f, strength = %f, armorstrength = %f",
                name, id, health, speed, agility, strength, armorStrength);
        return result;
    }
}
