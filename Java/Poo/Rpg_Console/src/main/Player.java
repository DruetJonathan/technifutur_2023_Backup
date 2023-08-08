package main;

public class Player extends Character {
    public int numAtkUpgrades, numDefUpgrades;
    public String[] atkUpgrades = {"Force", "Pouvoir", "Puissance", "Force divine"};
    public String[] defUpgrades = {"Os lourds", "Peau de pierre", "Armure d'écailles", "Aura sacrée"};

    /**
     * Constructeur d'un joueur
     *
     * @param name  le nom
     */
    public Player(String name) {
        super(name, 100, 0);
        // Parametre upgrades
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        // Laisse le joueur choisir un trait quand il crée un perso
        chooseTrait();
    }

    private void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choisissez un trait de départ: ");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        //lecture du choix du user
        int input = GameLogic.readInt("-> ", 2);
        //Affichage du choix du user
        if (input == 1) {
            GameLogic.printHeading("Vous avez choisis " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("Vous avez choisis " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();

    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }
}
