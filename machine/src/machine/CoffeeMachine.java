package machine;
import java.util.Scanner;

public class CoffeeMachine {
	private static final int ESPRESSO_WATER = 250;
    private static final int ESPRESSO_BEANS = 16;
    private static final int ESPRESSO_PRICE = 4;
    private static final int LATTE_WATER = 350;        
    private static final int LATTE_MILK = 75;
    private static final int LATTE_BEANS = 20;
    private static final int LATTE_PRICE = 7;        
    private static final int CAPPUCCINO_WATER = 200;
    private static final int CAPPUCCINO_MILK = 100;        
    private static final int CAPPUCCINO_BEANS = 12;        
    private static final int CAPPUCCINO_PRICE = 6;
    static boolean exit = false;
    
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;
    
    public enum CoffeeMachineState {
    	
    	START_MACHINE {
    		@Override    		
    	    public CoffeeMachineState nextState() {
    			return MAIN_MENU;
    		}
    	},
    	MAIN_MENU {
    		@Override    		
    	    public CoffeeMachineState nextState() {
    			System.out.println("Write action (buy, fill, take, remaining, exit):");
    	        Scanner scanner = new Scanner(System.in);
    	        String input = scanner.next();
    	        switch (input) {
	                case "buy":
	                    return CHOOSE_COFFEE;
	                case "fill":
	                    return FILL_MACHINE;
	                case "take":
	                    take();
	                    return MAIN_MENU;
	                case "remaining":
	                    printState();
	                    return MAIN_MENU;
	                case "exit":
	                    return EXIT_MACHINE;            
    	        }
				return START_MACHINE; 
    		}   		
    	},
    	CHOOSE_COFFEE {
    		@Override    		
    	    public CoffeeMachineState nextState() {
    			System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    	        Scanner scanner = new Scanner(System.in);
    	        String input = scanner.next();
    	        switch (input) {
                case "1":
                    if (water < ESPRESSO_WATER) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beans < ESPRESSO_BEANS) {
                        System.out.println("Sorry, not enough coffee!");
                    } else if (cups < 1) {
                        System.out.println("Sorry, not enough cups!");
                    } else {                 
                        System.out.println("I have enough resources, making you a coffee!");
                        water = water - ESPRESSO_WATER;
                        beans = beans - ESPRESSO_BEANS;
                        cups = cups - 1;
                        money = money + ESPRESSO_PRICE;
                    }                
                    return MAIN_MENU;
                case "2":
                    if (water < LATTE_WATER) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < LATTE_MILK) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (beans < LATTE_BEANS) {
                        System.out.println("Sorry, not enough coffee!");
                    } else if (cups < 1) {
                        System.out.println("Sorry, not enough cups!");
                    } else {                 
                        System.out.println("I have enough resources, making you a coffee!");
                        water = water - LATTE_WATER;
                        milk = milk - LATTE_MILK;
                        beans = beans - LATTE_BEANS;
                        cups = cups - 1;
                        money = money + LATTE_PRICE;
                    }                                
                    return MAIN_MENU;
                case "3":
                    if (water < CAPPUCCINO_WATER) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < CAPPUCCINO_MILK) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (beans < CAPPUCCINO_BEANS) {
                        System.out.println("Sorry, not enough coffee!");
                    } else if (cups < 1) {
                        System.out.println("Sorry, not enough cups!");
                    } else {                 
                        System.out.println("I have enough resources, making you a coffee!");
                        water = water - CAPPUCCINO_WATER;
                        milk = milk - CAPPUCCINO_MILK;
                        beans = beans - CAPPUCCINO_BEANS;
                        cups = cups - 1;
                        money = money + CAPPUCCINO_PRICE;
                    }               
                    return MAIN_MENU;
                case "back":                
                	return MAIN_MENU;
    	        } 
    	        return START_MACHINE;    
    		}     			
    	},
    	FILL_MACHINE {
    		@Override    		
    	    public CoffeeMachineState nextState() {
    			Scanner scanner = new Scanner(System.in);
    	        System.out.println("Write how many ml of water you want to add:");
    	        int input = scanner.nextInt();
    	        water = water + input;
    	        System.out.println("Write how many ml of milk you want to add:");
    	        input = scanner.nextInt();
    	        milk = milk + input;
    	        System.out.println("Write how many grams of coffee beans you want to add:");
    	        input = scanner.nextInt();
    	        beans = beans + input;
    	        System.out.println("Write how many disposable cups of coffee you want to add:");
    	        input = scanner.nextInt();
    	        cups = cups + input;
    			return MAIN_MENU;
    		}
    		
    	},
    	EXIT_MACHINE {
    		@Override    		
    	    public CoffeeMachineState nextState() {
    			exit = true;
    			return this;
    		}
    		
    	};
    	
    	public abstract CoffeeMachineState nextState();
    	
    }
    
    static void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money\n");
    }
    
//    void buy() {
//        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//        switch (input) {
//            case "1":
//                if (water < ESPRESSO_WATER) {
//                    System.out.println("Sorry, not enough water!");
//                } else if (beans < ESPRESSO_BEANS) {
//                    System.out.println("Sorry, not enough coffee!");
//                } else if (cups < 1) {
//                    System.out.println("Sorry, not enough cups!");
//                } else {                 
//                    System.out.println("I have enough resources, making you a coffee!");
//                    water = water - ESPRESSO_WATER;
//                    beans = beans - ESPRESSO_BEANS;
//                    cups = cups - 1;
//                    money = money + ESPRESSO_PRICE;
//                }                
//                break;
//            case "2":
//                if (water < LATTE_WATER) {
//                    System.out.println("Sorry, not enough water!");
//                } else if (milk < LATTE_MILK) {
//                    System.out.println("Sorry, not enough milk!");
//                } else if (beans < LATTE_BEANS) {
//                    System.out.println("Sorry, not enough coffee!");
//                } else if (cups < 1) {
//                    System.out.println("Sorry, not enough cups!");
//                } else {                 
//                    System.out.println("I have enough resources, making you a coffee!");
//                    water = water - LATTE_WATER;
//                    milk = milk - LATTE_MILK;
//                    beans = beans - LATTE_BEANS;
//                    cups = cups - 1;
//                    money = money + LATTE_PRICE;
//                }                                
//                break;
//            case "3":
//                if (water < CAPPUCCINO_WATER) {
//                    System.out.println("Sorry, not enough water!");
//                } else if (milk < CAPPUCCINO_MILK) {
//                    System.out.println("Sorry, not enough milk!");
//                } else if (beans < CAPPUCCINO_BEANS) {
//                    System.out.println("Sorry, not enough coffee!");
//                } else if (cups < 1) {
//                    System.out.println("Sorry, not enough cups!");
//                } else {                 
//                    System.out.println("I have enough resources, making you a coffee!");
//                    water = water - CAPPUCCINO_WATER;
//                    milk = milk - CAPPUCCINO_MILK;
//                    beans = beans - CAPPUCCINO_BEANS;
//                    cups = cups - 1;
//                    money = money + CAPPUCCINO_PRICE;
//                }               
//                break;
//            case "back":                
//                break;
//        }        
//    }
    
//    void fill() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Write how many ml of water you want to add:");
//        int input = scanner.nextInt();
//        water = water + input;
//        System.out.println("Write how many ml of milk you want to add:");
//        input = scanner.nextInt();
//        milk = milk + input;
//        System.out.println("Write how many grams of coffee beans you want to add:");
//        input = scanner.nextInt();
//        beans = beans + input;
//        System.out.println("Write how many disposable cups of coffee you want to add:");
//        input = scanner.nextInt();
//        cups = cups + input;
//    }
    
    static void take() {
        System.out.println("I gave you $"+ money);
        money = 0;
    }
    
//    void promptUser() {
//        System.out.println("Write action (buy, fill, take, remaining, exit):");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//        CoffeeMachine cm = new CoffeeMachine();
//        switch (input) {
//            case "buy":
//                cm.buy();
//                break;
//            case "fill":
//                cm.fill();
//                break;
//            case "take":
//                cm.take();
//                break;
//            case "remaining":
//                cm.printState();
//                break;
//            case "exit":
//                exit = true;
//                break;            
//        }
//        
//    }
    
    public static void main(String[] args) {        
    	CoffeeMachineState state = CoffeeMachineState.START_MACHINE;
        while (!exit) {
            state = state.nextState();
        }       
                
    }
}
    		
	
