import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Solution {

	/*
	 * Simple solution for spliting the best TSP route into smaller routes from
	 * CVRP
	 */
	public static void getSimpleSolution(Integer[] best_route) {
		// the capacity of each truck is 500
		int capacity = 500;
		double cost = 0;
		StringBuilder br = new StringBuilder();
		// a set of paths is for the cvrp
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		// each path is for the TSP
		ArrayList<Integer> path = new ArrayList<Integer>();
		// 1 means the depot, which is the start section
		br.append("1->");
		path.add(0);
		int i = 0;
		// there are 250 locations
		for (i = 1; i < 250; i++) {
			if (capacity - FruityBunData.CustomerDemand[best_route[i]] > 0) {
				capacity -= FruityBunData.CustomerDemand[best_route[i]];
				cost += FruityBunData.DistanceMatrix[best_route[i]][best_route[i - 1]];
				br.append((best_route[i] + 1) + "->");
				path.add(best_route[i]);
			} else {
				// in this case, best_route[i-1] is the last customer so the
				// truck should go back to the depot
				capacity = 500 - FruityBunData.CustomerDemand[best_route[i]];
				cost += FruityBunData.DistanceMatrix[best_route[i - 1]][0];
				cost += FruityBunData.DistanceMatrix[0][best_route[i]];
				br.append("1\n");
				path.add(0);
				paths.add(path);
				// this is for a new path which the first customer is
				// best_route[i]+1
				path = new ArrayList<Integer>();
				path.add(0);
				path.add(best_route[i]);
				br.append("1->" + (best_route[i] + 1) + "->");
			}
		}
		cost += FruityBunData.DistanceMatrix[best_route[i - 1]][0];
		br.append("1");
		path.add(0);
		paths.add(path);
		//printBestSolutionTXT(br.toString(), cost);
		printSolution(br.toString(), cost,paths.size());
	}

	public static void printSolution(String paths, Double cost,int trucks) {
		System.out.println("login bz16119 30984");
		System.out.println("name Bo Zhang");
		System.out.println("algorithm Improved Simulated Annealing");
		System.out.println("cost " + cost);
		//System.out.println("trucks "+trucks);
		System.out.println(paths);
	}
	public static void printBestSolutionTXT(String paths,Double cost){
		try{PrintWriter file = new PrintWriter("solution.txt", "UTF-8");
	      file.println("login bz16119 30984");
	      file.println("name Bo Zhang");
	      file.println("algorithm Improved Simulated Annealing");
	      file.println("cost " + cost);
	      file.print(paths);
	      file.close();
	    }
	    catch (Exception ex)
	    {
	      System.out.println("3rr0r");
	    }
		
	}
}


