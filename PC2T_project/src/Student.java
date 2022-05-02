import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class Student{
    private int id;
    private String name;
    private String surname;
    private int day;
    private int month;
    private int year;
    private String grupe;
    private int average;
    private ArrayList<Integer> grade;


    public Student(int id, String name, String surname, int day, int month, int year, String grupe)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.day = day;
        this.month = month;
        this.year = year;
        this.grupe = grupe;
        this.average = average;
        this.grade = new ArrayList<Integer>();
    }

    public int getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public void setGradeToArrayList(int grade){ this.grade.add(grade);}

    public void setGradeToArrayList (ArrayList<Integer> grade) {this.grade = grade;}

    public String saveGradeToDatabaze() {

        String gradeString = grade.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        return gradeString;
    }
    
    public double getAverage()
    {
        return grade.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0)
    ;}

    public String getGrupe() { return grupe; }

    public String SaveToFile()
    {
        return id + "," + name + "," + surname + "," +
                day + "," + month + "," + year + "," +
                grupe + "," + grade;
    }

}
