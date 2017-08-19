public class CVRP {

	public static void main(String[] args) {

		//System.out.println("Begins");
		//long startTime = System.currentTimeMillis();
		//Integer[] best_solution = SGA.runSGA();
		Integer[] best_solution = SimulatedAnnealing.runSA();
		
		Solution.getSimpleSolution(best_solution);
		//long endTime = System.currentTimeMillis();
		//long time = endTime - startTime;
		//System.out.println("time " + time + "ms");
		//System.out.println("End");
	}
}
