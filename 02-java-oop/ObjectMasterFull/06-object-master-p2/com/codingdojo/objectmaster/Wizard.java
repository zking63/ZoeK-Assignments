package com.codingdojo.objectmaster;
public class Wizard extends Human {
    public Wizard() {
        this.health = 50;
        this.intelligence = 8;
    }
    public void heal(Human target){
        target.health += this.intelligence;
        System.out.println(target.health);
        System.out.println(this.intelligence);
    }
    public void fireball(Human target){
        target.health -= (this.intelligence * 3);
        System.out.println(target.health);
        System.out.println(this.intelligence);
    }
}