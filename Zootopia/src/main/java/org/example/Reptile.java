package org.example;

public class Reptile implements Animal {
    private String sound;
    private String name;
    private String descr;

    public Reptile(String name, String sound, String DESCR) {
        this.sound = sound;
        this.name = name;
        this.descr = DESCR;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

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

    public void view() {
        System.out.println("Name: " + this.name + "\n" + "Sound: " + this.sound + "\n" + "Description: " + this.descr
                + "\n" + "Type: " + getClass());
    }
}