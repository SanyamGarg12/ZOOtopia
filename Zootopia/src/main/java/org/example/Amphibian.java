package org.example;


public class Amphibian implements Animal {

    private String sound;
    private String name;
    private String descr;

    public Amphibian(String name, String sound, String DESCR) {
        this.name = name;
        this.sound = sound;
        this.descr = DESCR;
    }

    @Override
    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDESCR(String descr) {
        this.descr = descr;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSound() {
        return this.sound;
    }

    @Override
    public String getDESCR() {
        return this.descr;
    }

    @Override
    public void view() {
        System.out.println("Name: " + this.name + "\n" + "Sound: " + this.sound + "\n" + "Description: " + this.descr
                + "\n" + "Type: " + getClass());
    }
}