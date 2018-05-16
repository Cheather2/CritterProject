public abstract class Critter implements Comparable<Critter> {

    static int lastId = 1000;
    String name;
    int id = lastId++;
    double health;
    double speed;
    double agility;
    double strength;
    double armorStrength;

    public Critter(String name, double health, double speed, double agility, double strength, double armorStrength) {
        this.name = name;
        this.health = health;
        if(speed < 0){speed = 0;}
        this.speed = speed;
        if(agility < 0){agility = 0;}
        this.agility = agility;
        if(strength < 0){strength = 0;}
        this.strength = strength;
        if(armorStrength < 0){armorStrength = 0;}
        this.armorStrength = armorStrength;
    }

    public static int getLastId() {
        return lastId;
    }

    private static void setLastId(int lastId) {
        Critter.lastId = lastId;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getHealth() {
        return health;
    }

    private void setHealth(double health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    private void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAgility() {
        return agility;
    }

    private void setAgility(double agility) {
        this.agility = agility;
    }

    public double getStrength() {
        return strength;
    }

    private void setStrength(double strength) {
        this.strength = strength;
    }

    public double getArmorStrength() {
        return armorStrength;
    }

    private void setArmorStrength(double armorStrength) {
        this.armorStrength = armorStrength;
    }

    @Override
    public String toString() {
        return "Critter" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", health=" + health +
                ", speed=" + speed +
                ", agility=" + agility +
                ", strength=" + strength +
                ", armorStrength=" + armorStrength;
    }

    @Override
    public int compareTo(Critter other) {
        int result = this.name.compareToIgnoreCase(other.name);
        if(result == 0) {
           double difference = this.health - other.health;
            if(difference < 0){
                result = -1;
            }else if(difference == 0){
                double idDif = this.id - other.id;
                if(idDif < 0){
                    result = -1;
                }else{
                    result = 1;
                }
            }else{
                result = 1;
            }
        }
        return result;
    }

    public static double attackEffectiveness(Critter fighter){
      Double strength = fighter.getStrength();
      Double agility = fighter.getAgility();
      Double speed = fighter.getSpeed();
      Double health = fighter.getHealth();

        double effectiveness = strength * agility * speed * health;

        if(fighter instanceof visionImpaired){
            effectiveness *= ((visionImpaired) fighter).calculateImpairment();
        }
        return effectiveness;
    }

    final public void acceptDamage(Double damage) {
        double healthReduction = 0.0;
        if(armorStrength > Math.random())
            armorStrength -= damage/2;
        else
            healthReduction = damage;
        health -= healthReduction;
    }

    static boolean isDead(double health){
        return health <= 0;
    }

    abstract String attackMessage();
}
