import java.util.PriorityQueue;
import java.util.Scanner;

public class PokeParty {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int trainers = scanner.nextInt();
		for (int t = 0; t < trainers; t++) {
			int encounters = scanner.nextInt();
			String firstPokemonName = scanner.next();
			int firstPokemonLevel = scanner.nextInt();
			
			Pokemon firstPokemon = new Pokemon(firstPokemonName, firstPokemonLevel);
			// Initialize a heap, and start by including `firstPokemon`
			PriorityQueue<Pokemon> partyheap = new PriorityQueue<>();
			partyheap.add(firstPokemon);
			
			for (int e = 0; e < encounters; e++) {
				String encounterType = scanner.next();
				Pokemon encounterPokemon = new Pokemon(scanner.next(), scanner.nextInt());
				if (encounterType.equals("CATCH")) {
					partyheap.add(encounterPokemon);
					if(partyheap.size()>6) {
						partyheap.poll();
					}
				} else {
					// BATTLE
					Pokemon battlePokemon = partyheap.poll();
					while (battlePokemon.level < encounterPokemon.level) {
						System.out.printf("%s fights %s and loses!%n", battlePokemon.name, encounterPokemon.name);
						battlePokemon = partyheap.poll();
					}
					
					System.out.printf("%s fights %s and wins!%n", battlePokemon.name, encounterPokemon.name);
					partyheap.add(battlePokemon);
				}
			}
			
			System.out.println("Final party:");
			while (partyheap.size()>0) {
				Pokemon partyPokemon = partyheap.poll();
				System.out.printf("%s (%d)%n", partyPokemon.name, partyPokemon.level);
			}
		}
	}
	
	public static class Pokemon implements Comparable<Pokemon> {
		public final String name;
		public final int level;
		
		public Pokemon(String name, int level) {
			this.name = name;
			this.level = level;
		}
		
		public int compareTo(Pokemon other) {
			if(this.level == other.level) {
				return this.name.compareTo(other.name);
			}
			else {
				return this.level - other.level;
			}
		}
	}
}