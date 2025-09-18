class Ship {
    String name;
    String captain;

    public Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    public String toString() {
    	return String.format("%-12s | Capt. %-12s", name, captain);
    }
}
