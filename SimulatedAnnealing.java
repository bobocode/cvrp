import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SimulatedAnnealing {
    
    private static final float min_temperature = 1.0f;
    private static final float cooling_rate = 0.0000001f;
    private static final float initial_temperature = 1000.0f;
    private static final float probability = 0.0f; // random rate
    static Random random = new Random(System.currentTimeMillis());
    
    public static Integer[] runSA() {
        Integer[] initial_state = getInitialState();
        
        // Integer[] best_solution = SGA.runSGA();
        Integer[] best_state = SA(initial_state);
        // double optimal_cost=getDistance(initial_state);
        
        return best_state;
        
    }
    
    public static Integer[] SA(Integer[] initial_state) {
        
        Integer[] current_state = Arrays.copyOf(initial_state,
                                                initial_state.length); // get the intial path
        Integer[] temperory_state = new Integer[250];
        Integer[] best_state = new Integer[250];
        // ArrayList<Integer[]> TSPs=new ArrayList<Integer[]>();
        
        double temperature = initial_temperature;
        double probability = random.nextDouble();
        // double probability = Math.random();
        
        while (temperature >= min_temperature) {
            temperory_state = getTemperoryState(current_state);
            double current_cost = getCVRPcost(current_state);
            double temperature_cost = getCVRPcost(temperory_state);
            double best_cost= getCVRPcost(current_state);
            // System.out.println(current_cost);
            if (temperature_cost < current_cost) {
                if(temperature_cost< best_cost){
                    best_state = Arrays.copyOf(temperory_state,
                                               temperory_state.length);
                    current_state = Arrays.copyOf(temperory_state,
                                                  temperory_state.length);
                }else{
                    current_state = Arrays.copyOf(temperory_state,
                                                  temperory_state.length);
                }
                
            } else if (temperature_cost > current_cost
                       && Math.exp((current_cost - temperature_cost) / temperature) > probability) {
                // TSPs.add(current_state);
                best_state = Arrays.copyOf(current_state,
                                           current_state.length);
                current_state = Arrays.copyOf(temperory_state,
                                              temperory_state.length);
                
            }
            //			 double best_cost = getCVRPcost(best_state);
            //			 System.out.println(best_cost);
            
            temperature *= (1 - cooling_rate);
            
        }
        // for(int i=0;i<TSPs.size();i++){
        //
        // if(getDistance(TSPs.get(i)) < getDistance(best_state)){
        // best_state=Arrays.copyOf(TSPs.get(i), TSPs.get(i).length);
        // }
        // }
        return best_state;
        
    }
    
    /*
     * static Chromosome swapMutation(Chromosome x) { Random random = new
     * Random(); int a = random.nextInt(250 - 1) + 1; int b = random.nextInt(250
     * - 1) + 1; Integer[] genes = x.getGenes(); int temp_gene = genes[a];
     * genes[a] = genes[b]; genes[b] = temp_gene; return new Chromosome(genes);
     * }
     */
    
    static Integer[] getInitialState() {
        // there is 250 locations
        Integer[] array = new Integer[250];
        for (int i = 0; i < 250; i++) {
            array[i] = i;
        }
        // randomly generate gene sequence for TSP
        Collections.shuffle(Arrays.asList(array));
        if (array[0] != 0) {
            int loc = 0;
            int temp = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    loc = i;
                }
                
                array[loc] = temp;
                array[0] = 0;
            }
        }
        return array;
    }
    
    /*	private static double getDistance(Integer[] state) {
     // TODO Auto-generated method stub
     double distance = 0.0;
     for (int i = 1; i < state.length; i++) {
     distance += FruityBunData.DistanceMatrix[state[i]][state[i - 1]];
     }
     
     distance += FruityBunData.DistanceMatrix[state[state.length - 1]][0];
     return distance;
     }*/
    
    private static double getCVRPcost(Integer[] state) {
        double cost = 0.0;
        // the capacity of each truck is 500
        int capacity = 500;
        // 1 means the depot, which is the start section
        int i = 0;
        // there are 250 locations
        for (i = 1; i < 250; i++) {
            if (capacity - FruityBunData.CustomerDemand[state[i]] > 0) {
                capacity -= FruityBunData.CustomerDemand[state[i]];
                cost += FruityBunData.DistanceMatrix[state[i]][state[i - 1]];
            } else {
                // in this case, best_route[i-1] is the last customer so the
                // truck should go back to the depot
                capacity = 500 - FruityBunData.CustomerDemand[state[i]];
                cost += FruityBunData.DistanceMatrix[state[i - 1]][0];
                cost += FruityBunData.DistanceMatrix[0][state[i]];
            }
        }
        cost += FruityBunData.DistanceMatrix[state[i - 1]][0];
        return cost;
    }
    
    private static Integer[] getTemperoryState(Integer[] current_state) {
        // TODO Auto-generated method stub
        Integer[] temperory = Arrays
        .copyOf(current_state, current_state.length);
        Random random = new Random();
        int a = random.nextInt(249) + 1;
        int b = random.nextInt(249) + 1;
        
        while (a == b) {
            b = random.nextInt(249) + 1;
        }
        double rate = Math.random();
        // System.out.println(rate);
        if (rate < 0.5d) {
            int temp = temperory[a];
            temperory[a] = temperory[b];
            temperory[b] = temp;
        } else if (0.5d < rate && rate < 0.75d) {
            if (a < b) {
                while (a < b) {
                    
                    temperory[a] = temperory[a] ^ temperory[b];
                    temperory[b] = temperory[b] ^ temperory[a];
                    temperory[a] = temperory[b] ^ temperory[a];
                    
                    a++;
                    b--;
                }
                
            } else {
                while (b < a) {
                    
                    temperory[b] = temperory[b] ^ temperory[a];
                    temperory[a] = temperory[a] ^ temperory[b];
                    temperory[b] = temperory[a] ^ temperory[b];
                    
                    b++;
                    a--;
                }
                
            }
        } else if (rate > 0.75d) {
            
            if (a < b) {
                int temp = 0;
                temp = temperory[b];
                for (int i = b; i > a; i--) {
                    temperory[i] = temperory[i - 1];
                    
                }
                temperory[a] = temp;
            } else {
                int temp = 0;
                temp = temperory[a];
                for (int i = a; i > b; i--) {
                    temperory[i] = temperory[i - 1];
                    
                }
                temperory[b] = temp;
            }
            
        }
        
        return temperory;
        
    }
    
}
