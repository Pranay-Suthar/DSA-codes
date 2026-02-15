package HackerRank;

import java.util.*;

//Sample Input
//
//        5
//        33 Rumpa 3.68
//        85 Ashis 3.85
//        56 Samiha 3.75
//        19 Samara 3.75
//        22 Fahim 3.76
//Sample Output
//
//        Ashis
//        Fahim
//        Samara
//        Samiha
//        Rumpa

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class SortArray implements Comparator<Student>{
    public int compare(Student s1, Student s2) {

        // 1. CGPA descending
        if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }

        // 2. Name ascending
        if (!s1.getFname().equals(s2.getFname())) {
            return s1.getFname().compareTo(s2.getFname());
        }

        // 3. ID ascending
        return s1.getId() - s2.getId();
    }
}

public class Java_Sort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(new SortArray());

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}
