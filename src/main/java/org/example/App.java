package org.example;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private String firstPlanet;
    private String secondPlanet;
    private Double weight = 0.00;
    private List<Planet> planets = new ArrayList<>();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        populateList();
        consoleService.welcomePrompt();
        System.out.println(" ");
        System.out.println(" ");
        double answer = calculate();
        System.out.println(" ");
        System.out.println("if you weigh " + this.weight + " on " + this.firstPlanet.toLowerCase()
        + " you would weigh around " + answer + " on " + this.secondPlanet.toLowerCase() + ".");
    }

    public double calculate() {
        double firstPlanetGravity = 0.00;
        double secondPlanetGravity = 0.00;

        this.firstPlanet = consoleService.promptForString("Please enter the planet you want the weight to be on.");
        this.firstPlanet = check(this.firstPlanet);
        System.out.println(" ");
        this.weight = consoleService.promptForDouble("Please enter the weight you want to calculate.");
        System.out.println(" ");
        this.secondPlanet = consoleService.promptForString("Please enter the planet your calculating the weight on.");
        this.secondPlanet = check(this.secondPlanet);

        while (this.secondPlanet.equalsIgnoreCase(this.firstPlanet)) {
            this.secondPlanet = consoleService.promptForString("Please enter a planet different from the first planet!");
            this.secondPlanet = check(this.secondPlanet);
        }

        for (Planet planet : planets) {
            if (planet.getName().equalsIgnoreCase(this.firstPlanet)) {
                firstPlanetGravity = planet.getGravity();
            } else if (planet.getName().equalsIgnoreCase(this.secondPlanet)) {
                secondPlanetGravity = planet.getGravity();
            }
        }
        return Math.round(weight * (secondPlanetGravity/firstPlanetGravity));
    }
//    while (this.secondPlanet.equalsIgnoreCase(this.firstPlanet))
    public void populateList() {
        planets.add(new Planet("mercury", 3.7));
        planets.add(new Planet("venus", 8.87));
        planets.add(new Planet("earth", 9.81));
        planets.add(new Planet("mars", 3.71));
        planets.add(new Planet("saturn", 10.44));
        planets.add(new Planet("jupiter", 24.79));
        planets.add(new Planet("uranus", 8.86));
        planets.add(new Planet("neptune", 11.15));
        planets.add(new Planet("pluto", 0.62));
    }

    public String check(String planet) {
        String newPlanet = "";
        for (Planet world : planets) {
            if (world.getName().equalsIgnoreCase(planet)) {
                return planet;
            }
        }
        while (true) {
            newPlanet = consoleService.promptForString("Invalid Planet. Enter valid planet.");
            for (Planet world : planets) {
                if (world.getName().equalsIgnoreCase(newPlanet)) {
                    return newPlanet;
                }
            }
        }
    }

}