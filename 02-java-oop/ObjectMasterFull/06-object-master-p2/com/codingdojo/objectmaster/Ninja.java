package com.codingdojo.objectmaster;
public class Ninja extends Human {
    public Ninja() {
        this.stealth = 10;
    }
    public void steal(Human target){
        target.health -= this.stealth;
        this.health += this.stealth;
        System.out.println(target.health);
        System.out.println(this.health);
    }
    public void runAway(){
        this.health -= 10;
    }
}