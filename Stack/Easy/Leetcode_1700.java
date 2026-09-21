public class Leetcode_1700 {

    // Example 1:

    // Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
    // Output: 0 
    // Explanation:
    // - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
    // - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
    // - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
    // - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
    // - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
    // - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
    // - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
    // - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
    // Hence all students are able to eat.

    // Example 2:

    // Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
    // Output: 3

    public static int countStudents(int[] students, int[] sandwiches) {
        int circ = 0;
        int sqr = 0;

        for (int student : students) {
            if (student == 0) {
                circ++;
            } else {
                sqr++;
            }
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (circ == 0) {
                    return sqr;
                }
                circ--;
            } else {
                if (sqr == 0) {
                    return circ;
                }
                sqr--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};

        System.out.println(countStudents(students, sandwiches));
    }
}
