public class Ninja extends Human {
	public Ninja() {
		this.stealth = 10;
	}
	public void steal(Human target) {
		target.health-=this.stealth;
		this.health += this.stealth;
		//human.steal
	}
	public void runAway() {
		this.health -= 10;
	}
}