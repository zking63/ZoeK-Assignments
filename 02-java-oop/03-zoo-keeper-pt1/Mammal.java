public class Mammal {
    public int energyLevel = 100;
    public Integer displayEnergy() {
        System.out.println(energyLevel);
        return energyLevel;
    }
    public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}