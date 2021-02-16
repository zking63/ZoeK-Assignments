package com.codingdojo.objectmaster;
public class HumanTest {
    public static void main(String[] args){
        Human human = new Human();
        Human human2 = new Human();
        Wizard wizard = new Wizard();
        Ninja ninja = new Ninja();

        human.attack(human2);
        wizard.heal(human);
        ninja.steal(human);
        ninja.runAway();
    }
}