public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Container> containerStack = new ArrayDeque<>();
        Deque<Ship> shipQueue = new ArrayDeque<>();

        while (true) {
            System.out.print(
                "====== PORT CONTAINER MANAGEMENT SYSTEM ======\n" +
                "[1] Store container (push)\n" +
                "[2] View port containers\n" +
                "[3] Register arriving ship (enqueue)\n" +
                "[4] View waiting ships\n" +
                "[5] Load next ship (pop container + poll ship)\n" +
                "[0] Exit\n" +
                "Choose an option: "
            );

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a number from 0 to 5.\n");
                continue;
            }

            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter container ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();

                    int weight;
                    try {
                        System.out.print("Enter weight (kg): ");
                        weight = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("\nInvalid weight. Must be a number.\n");
                        break;
                    }

                    Container container = new Container(id, desc, weight);
                    containerStack.push(container);
                    System.out.println("\nStored: " + container.toInlineString());
                    break;

                case 2:
                    if (containerStack.isEmpty()) {
                        System.out.println("No containers in port.");
                    } else {
                        System.out.println("TOP →");
                        for (Container c : containerStack) {
                            System.out.println(c);
                        }
                        System.out.println("← BOTTOM");
                    }
                    break;

                case 3:
                    System.out.print("Enter ship name: ");
                    String shipName = scanner.nextLine();

                    System.out.print("Enter captain's name: ");
                    String captain = scanner.nextLine();

                    Ship ship = new Ship(shipName, captain);
                    shipQueue.offer(ship);
                    System.out.println("\nRegistered: " + ship.toInlineString());
                    break;

                case 4:
                    if (shipQueue.isEmpty()) {
                        System.out.println("No ships waiting.");
                    } else {
                        System.out.println("FRONT →");
                        for (Ship s : shipQueue) {
                            System.out.println(s);
                        }
                        System.out.println("← REAR");
                    }
                    break;

                case 5:
                    if (containerStack.isEmpty()) {
                        System.out.println("No containers to load.");
                    } else if (shipQueue.isEmpty()) {
                        System.out.println("No ships waiting.");
                    } else {
                        Container loadedContainer = containerStack.pop();
                        Ship loadingShip = shipQueue.poll();
                        System.out.println("Loaded: " + loadedContainer.toInlineString() + " → " + loadingShip.toInlineString());
                        System.out.println("Remaining containers: " + containerStack.size());
                        System.out.println("Remaining ships waiting: " + shipQueue.size());
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println("\n----------------------------------------------\n");
        }
    }
}
