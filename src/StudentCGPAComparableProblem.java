/**
 * Created by Marc on 2016-11-20.
 */

/*
Context & Instructions:
You are given a list of student information: ID, FirstName, and CGPA.
Your task is to rearrange them according to their CGPA in decreasing
order. If two student have the same CGPA, then arrange them according
to their first name in alphabetical order. If those two students also
have the same first name, then order them according to their ID.
No two students have the same ID.

Input Format:
The first line of input contains an integer N, representing the total
number of students. The next N lines contains a list of student
information in the following structure:
ID Name CGPA
Example:
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

Output Format:
After rearranging the students according to the above rules, print
the first name of each student on a separate line.
Example:
Ashis
Fahim
Samara
Samiha
Rumpa

Constraints:
2 <= N <= 1,000
0 <= ID <= 100,000
5 <= |Name| <= 30
0 <= CGPA <= 4.00
The name contains only lowercase English letters. The ID contains
only integer numbers without leading zeros. The CGPA will contain,
at most, 2 digits after the decimal point.

*/
import java.util.*;

// provided Student class
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

//Complete the code in here
public class StudentCGPAComparableProblem{

    public static void main(String[] args){
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

        // Probably need to sort here using comparable / Arrays.Sort thing
        Collections.sort(studentList, new StudentSorter());

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}

class StudentSorter implements Comparator<Student>{

    public int compare(Student a, Student b) {
        // case where cgpa are same
        if(a.getCgpa() == b.getCgpa()){

            // case where cgpa and name are same
            if(a.getFname().equals(b.getFname())){
                return a.getId() - b.getId();
            }
            // case where cgpa are same but names are different
            else{
                return a.getFname().compareTo(b.getFname()); // ascending order / alphabetical order if same cgpa
            }
        }
        // case where CGPA are different
        else {
            // this will return scores in descending order.
            return ((b.getCgpa() - a.getCgpa()) > 0? 1 : -1);
        }
    }

}
