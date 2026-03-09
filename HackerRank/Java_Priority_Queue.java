package HackerRank;

import java.util.*;

//Output Format
//
//        The locked stub code prints the names of the students yet to be served in the priority order.
//                If there are no such student, then the code prints EMPTY.
//
//Sample Input 0
//
//        12
//        ENTER John 3.75 50
//        ENTER Mark 3.8 24
//        ENTER Shafaet 3.7 35
//        SERVED
//        SERVED
//        ENTER Samiha 3.85 36
//        SERVED
//        ENTER Ashley 3.9 42
//        ENTER Maria 3.6 46
//        ENTER Anik 3.95 49
//        ENTER Dan 3.95 50
//        SERVED
//
//Sample Output 0
//
//        Dan
//        Ashley
//        Shafaet
//        Maria

/*
 * Create the Student and Priorities classes here.
 */

class Student{

    String name;
    float cgpa;
    int id;

    public Student(String name, float cgpa, int id){
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName(){
        return name;
    }
}


class Priorities{
    public List<Student> getStudents(List<String> events){
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> {

            if (a.cgpa != b.cgpa)
                return Float.compare(b.cgpa, a.cgpa);

            if (!a.name.equals(b.name))
                return a.name.compareTo(b.name);

            return a.id - b.id;
        }
        );

        for (String e : events){

            if (e.startsWith("ENTER")){
                //
                String[] arr = e.split(" ");
                Student student = new Student(
                        arr[1] ,
                        Float.parseFloat(arr[2]),
                        Integer.parseInt(arr[3])
                );

                pq.add(student);

            } else {
                pq.poll();
            }

        }

        List<Student> result = new ArrayList<>();

        while (!pq.isEmpty()){
            result.add(pq.poll());
        }

        return result;
    }
}

public class Java_Priority_Queue {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}