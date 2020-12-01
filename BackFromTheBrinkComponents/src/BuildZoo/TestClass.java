package BuildZoo;
import java.util.*;

public class TestClass {
	
	static Scanner input = new Scanner(System.in);
	
	static int costOfZoo = 30;
	static Player testPlayer = new Player("John Doe");

	public static void main(String[] args) {
		//Intialization 
		testPlayer.setMaterial(200);
		testPlayer.getInventory().addBiome("Sky");
		testPlayer.getInventory().getBiomes().get(0).addAnimalHabitat("Whooping Crane");
		testPlayer.getInventory().getBiomes().get(0).addAnimalHabitat("Grey Parrot");
		testPlayer.getInventory().getBiomes().get(0).addAnimalHabitat("Hawaiian Duck");
		
		//Display biomes
		ArrayList<Biome> playerBiomes = testPlayer.getBiomes();
		System.out.println("You have the following biomes: ");
		for(int i =0; i< playerBiomes.size(); i++)
		System.out.println(i+1 + ": " + playerBiomes.get(i).getName());
		
		//Player selects biome by enter number
		System.out.println("Please select the Biome you like to build a zoo on: ");
		int selectionBiome = input.nextInt()-1;
		input.nextLine();
		
		//Get and select animal habitats of that biome to build zoo on
		System.out.println("Displaying Animal Habitats and number of Zoos for " + playerBiomes.get(selectionBiome).getName() + " biome: " );
		ArrayList<AnimalHabitat> playerHabitats = playerBiomes.get(selectionBiome).getAnimalHabitats();
		for(int i = 0; i < playerHabitats.size(); i++)
			System.out.println(i+1 + ": " + playerHabitats.get(i).getAnimalHabitatName() + ": " + playerHabitats.get(i).getNumberOfZoos());
		System.out.println("Please select the Animal Habitat you would like to build a Zoo on: ");
		int selectionHabitat = input.nextInt()-1;
		input.nextLine();
		
		//Confirmation
		System.out.println("Are you sure you would like to build a zoo on the " + playerHabitats.get(selectionHabitat).getAnimalHabitatName() + " habitat in the " + playerBiomes.get(selectionBiome).getName() + " biome.");
		System.out.println("1 for Yes, 2 for No");
		int confirmation = input.nextInt();
		if(confirmation == 1 ) {
			//Building zoo on habitat
			if(testPlayer.checkPlayerResources(costOfZoo)) {
				System.out.println("Successfully built a zoo on the " + playerHabitats.get(selectionHabitat).getAnimalHabitatName() + " habitat in the " + playerBiomes.get(selectionBiome).getName() + " biome.");
				playerHabitats.get(selectionHabitat).addZoo();
			}
		} else {
			System.out.println("Cancelled Build Zoo");
		}

		System.out.println(testPlayer.getName());
		for(int i =0; i < testPlayer.getBiomes().size(); i++) {
			System.out.println();
		}
	}


	public static ArrayList<Object> getProperties() {
		//get materials
		//get biomes
			//get habitats for that
				//get zoos for that habitats
		ArrayList<Object> playerInfo = new ArrayList<>();
		//store materials at index 0
		playerInfo.add(testPlayer.getMaterial());
		//store ArrayList<Biome> biomes at index 1
		
	}

	
}
