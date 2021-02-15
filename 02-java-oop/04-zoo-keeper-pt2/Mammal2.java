public class Mammal2 {
    public int energyLevel = 100;
    public Integer displayEnergy() {
        System.out.println("Energy level: " +energyLevel);
        return energyLevel;
    }
    public Mammal2(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}