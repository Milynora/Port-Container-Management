class Container {
    String id;
    String description;
    int weight;

    public Container(String id, String description, int weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    public String toString() {
    	return String.format("%-6s | %-12s | %4dkg", id, description, weight);
    }
}
