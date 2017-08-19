

public class FruityBunData {
    final static int DIMENSION = 250;
    
    final static int CAPACITY = 500; //the capacity of each truck
    
    final static int[][] coordinateArray =
    {{-33, 33}, {-99, -97}, {-59, 50}, {0, 14}, {-17, -66}, {-69, -19}, {31, 12},
    {5, -41}, {-12, 10}, {-64, 70}, {-12, 85}, {-18, 64}, {-77, -16}, {-53, 88},
    {83, -24}, {41, 24}, {17, 21}, {42, 96}, {-65, 0}, {-47, -26}, {85, 36},
    {-35, -54}, {54, -21}, {64, 89}, {55, -17}, {17, -25}, {-61, 66}, {-61, 26},
    {17, -72}, {79, 38}, {-62, -2}, {-90, -68}, {52, 66}, {-54, -50}, {8, -84},
    {37, -90}, {-83, 49}, {35, -1}, {7, 59}, {12, 48}, {57, 95}, {92, 28},
    {-3, 97}, {-7, 52}, {42, -15}, {77, -43}, {59, -49}, {25, 91}, {69, -14},
    {-82, -19},{74, -70}, {69, 59}, {29, 33}, {-97, 9}, {-58, 9}, {28, 93},
    {7, 73}, {-28, 73}, {-76, 55}, {41, 42}, {92, 40}, {-84, -29}, {-12, 42},
    {51, -45}, {-37, 46}, {-97, 35}, {14, 89}, {60, 58}, {-63, -75}, {-18, 34},
    {-46, -82}, {-86, -79}, {-43, -30}, {-44, 7}, {-3, -20}, {36, 41}, {-30, -94},
    {79, -62}, {51, 70}, {-61, -26}, {6, 94}, {-19, -62}, {-20, 51}, {-81, 37},
    {7, 31}, {52, 12}, {83, -91}, {-7, -92}, {82, -74}, {-70, 85}, {-83, -30},
    {71, -61}, {85, 11}, {66, -48}, {78, -87}, {9, -79}, {-36, 4}, {66, 39},
    {92, -79}, {-46, -17}, {-30, -63}, {-42, 63}, {20, 42}, {15, 98}, {1, -17},
    {64, 20}, {-96, 85}, {93, -29}, {-40, -84}, {86, 35}, {91, 36}, {62, -8},
    {-24, 4}, {11, 96}, {-53, 62}, {-28, -71}, {7, -4}, {95, -9}, {-3, 17},
    {53, -90}, {58, -19}, {-83, 84}, {-1, 49}, {-4, -3}, {-82, 17}, {-43, 47},
    {6, -6}, {70, 99}, {68, -29}, {-94, -30}, {-94, -20}, {-21, 77}, {64, 37},
    {-70, -19}, {88, 65}, {2, 29}, {33, 57}, {-70, 6}, {-38, -56}, {-80, -95},
    {-5, -39}, {8, -22}, {-61, -76}, {76, -22}, {49, -71}, {-30, -68}, {1, 34},
    {77, 79}, {-58, -97}, {82, 64}, {-80, 55}, {81, -86}, {39, -49}, {-67, 72},
    {-25, -89}, {-44, -95}, {32, -68}, {-17, 49}, {93, 49}, {99, 81}, {10, -49},
    {63, -41}, {38, 39}, {-28, 39}, {-2, -47}, {38, 8}, {-42, -6}, {-67, 88},
    {19, 93}, {40, 27}, {-61, 56}, {43, 33}, {-18, -39}, {-69, -18}, {75, 19},
    {31, 85}, {25, 58}, {-16, 36}, {91, 15}, {60, -39}, {49, -47}, {42, 33},
    {16, -81}, {-78, 53}, {53, -80}, {-46, -26}, {-25, -54}, {69, -46}, {0, -78},
    {-84, 74}, {-16, 16}, {-63, -14}, {51, -77}, {-39, 61}, {5, 97}, {-55, 39},
    {70, -14}, {0, 95}, {-45, -24}, {38, 7}, {50, -37}, {59, 71}, {-73, -96},
    {-29, 72}, {-47, 12}, {-88, -61}, {-88, 36}, {-46, -3}, {26, -37}, {-39, -67},
    {92, 27}, {-80, -31}, {93, -50}, {-20, -5}, {-22, 73}, {-4, -7}, {54, -48},
    {-70, 39}, {54, -82}, {29, 41}, {-87, 51}, {-96, -36}, {49, 8}, {-5, 43},
    {-26, 54}, {-11, 60}, {40, 61}, {82, 35}, {-92, 12}, {-93, -86}, {-66, 63},
    {-72, -87}, {-57, -84}, {23, 52}, {-56, -62}, {-19, 59}, {63, -14}, {-13, 38},
    {-19, 87}, {44, -84}, {98, -17}, {-16, 62}, {3, 66}, {26, 22}, {-38, -81},
    {70, 80}, {17, -35}, {96, -83}, {-77, 44}, {-14, 80}};
    
    final static int[] CustomerDemand ={0,6,72,93,78,5,43,1,36,28,63,25,50,57,1,66,37,51,47,53,75,48,40,8,69,93,29,5,53,88,24,53,13,47,57,9,74,83,96,8,80,22,56,43,12,73,32,8,79,42,4,14,17,19,44,5,37,100,62,79,57,44,37,80,60,95,56,56,9,90,15,4,58,73,5,12,3,8,31,39,3,52,99,29,12,50,98,4,56,48,33,45,98,4,36,72,26,71,84,24,99,33,84,74,93,25,39,42,77,21,50,42,71,85,78,64,5,93,18,68,29,81,4,23,11,86,2,31,54,38,17,81,72,10,50,25,71,85,51,87,55,45,100,38,11,82,50,39,6,29,83,22,24,69,97,65,97,79,79,87,52,39,94,97,18,3,23,19,40,46,96,58,15,21,56,67,10,36,84,49,85,60,33,62,70,79,98,99,18,59,75,94,89,13,19,19,90,35,76,55,11,98,92,1,2,63,57,50,19,3,14,18,77,28,72,49,58,84,58,24,98,77,57,39,99,83,54,86,2,41,42,14,55,2,18,17,22,28,3,14,53,15,36,98,96,92,65,64,43,50};
    
    /* Distance Matrix */
    final static double[][] DistanceMatrix = getDistanceMatrix();
    
    
    
    // get the distance between two points
    static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
    }
    
    static double[][] getDistanceMatrix() {
        double[][] matrix = new double[500][500];
        for(int i=0; i<coordinateArray.length; i++) {
            for(int j=0; j<coordinateArray.length; j++) {
                if(i==j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = getDistance(coordinateArray[i][0], coordinateArray[i][1], coordinateArray[j][0], coordinateArray[j][1]);
                }
            }
        }
        return matrix;
    }
    
}