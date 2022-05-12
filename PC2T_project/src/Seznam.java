import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Seznam {

    private HashMap<Integer, Student> valuesHashMap = new HashMap<>();

    int id;
    String group;

    public void setStudentTO(String name, String surname, int day, int month, int year)
    {
        group = "technical";
        valuesHashMap.put(id, new Obor(id, name, surname, day, month, year, group));
        id++;
    }

    public void setStudentHO(String name, String surname, int day, int month, int year)
    {
        group = "humanitarian";
        valuesHashMap.put(id, new Obor(id, name, surname, day, month, year, group));
        id++;
    }

    public void setStudentKS(String name, String surname, int day, int month, int year)
    {
        group = "combined";
        valuesHashMap.put(id, new Obor(id, name, surname, day, month , year, group));
        id++;
    }

    public void setGrade (int id, int grade)
    {
        if (valuesHashMap.containsKey(id)) {
            valuesHashMap.get(id).setGradeToArrayList(grade);

        } else {
            System.out.println("Student does not exist");
        }
    }

    public void delStudent(int id)
    {
        System.out.println("Student: " + id +  " Name: " + valuesHashMap.get(id).getName() + " Surname: " + valuesHashMap.get(id).getSurname() + " Year of boarn: " + valuesHashMap.get(id).getYear());
        valuesHashMap.remove(id);
    }

    public String getStudent(int id)
    {
        if(valuesHashMap.containsKey(id)){

            System.out.println("Student: " + id +  " \tName: " + valuesHashMap.get(id).getName() + " \tSurname: " + valuesHashMap.get(id).getSurname() + " \tYear of boarn: " + valuesHashMap.get(id).getYear() +
                    " \tAverage grades: " + valuesHashMap.get(id).getAverage());
        }
        else {
            System.out.println("Student does not exist");
        }
        return "";
    }

    public String getSkill(int id)
    {
        if(valuesHashMap.containsKey(id))
        {
            if(valuesHashMap.get(id).getGrupe().equals("technical"))
            {
                id = valuesHashMap.get(id).getID();
                System.out.println("Student: " + id + " \tName: " + valuesHashMap.get(id).getName() + " \tSurname: " + valuesHashMap.get(id).getSurname() +
                        " \tYear of boarn: " + valuesHashMap.get(id).getYear() + " \tIs year leep? " + PrestupnyRok(id) + " ");
            }
            else if(valuesHashMap.get(id).getGrupe().equals("humanitarian"))
            {
                id = valuesHashMap.get(id).getID();
                System.out.println("Student: " + id + " \tName: " + valuesHashMap.get(id).getName() + " \tSurname: " + valuesHashMap.get(id).getSurname() +
                        " \tDate of birthday: " + valuesHashMap.get(id).getDay() + "." + valuesHashMap.get(id).getMonth() + "." + valuesHashMap.get(id).getYear() + " \tZodiac sign: " + Znameni(id));
            }
            else if(valuesHashMap.get(id).getGrupe().equals("combined"))
            {
                id = valuesHashMap.get(id).getID();
                System.out.println("Student: " + id + " \tName: " + valuesHashMap.get(id).getName() + " \tSurname: " + valuesHashMap.get(id).getSurname() +
                        " \tDate of birthday: " + valuesHashMap.get(id).getDay() + "." + valuesHashMap.get(id).getMonth() + "." + valuesHashMap.get(id).getYear() + " \tIs year leep? " + PrestupnyRok(id) + " \tZodiac sign: " + Znameni(id));
            }
            else System.out.println("error");
            return "";
        }
        else
        {
            System.out.println("Student does not exist");
            return "";
        }
    }

    public void Alphabetic()
    {
        ArrayList<Integer> keysArrayList= new ArrayList<Integer>(valuesHashMap.keySet());       //klíče
        Collection<Student> values = valuesHashMap.values();                                    //hodnoty
        ArrayList <Student> newHashMapList= new ArrayList<>(values);

        Collections.sort(newHashMapList, Comparator.comparing(Student::getSurname));

        System.out.println("Technical specialization");
        for (Student i : newHashMapList) {
            if (i.getGrupe().equals("technical")) {
                System.out.println("Student: " + i.getID() + " \tName: " + i.getName() + " \tSurname: " + i.getSurname() + " \tDate of birthday: " + i.getDay() + "." +
                        i.getMonth() + "." + i.getYear() + " \tAverage grades: " + i.getAverage());
            }
        }

        System.out.println("Humanitarian specialization");
        for (Student i : newHashMapList) {
            if (i.getGrupe().equals("humanitarian")) {
                System.out.println("Student: " + i.getID() + " \tName: " + i.getName() + " \tSurname: " + i.getSurname() + " \tDate of birthday: " + i.getDay() + "." +
                        i.getMonth() + "." + i.getYear() + " \tAverage grades: " + i.getAverage());
            }
        }
        System.out.println("Combined specialization");
        for (Student i : newHashMapList) {
            if (i.getGrupe().equals("combined")) {
                System.out.println("Student: " + i.getID() + " \tName: " + i.getName() + " \tSurname: " + i.getSurname() + " \tDate of birthday: " + i.getDay() + "." +
                        i.getMonth() + "." + i.getYear() + " \tAverage grades: " + i.getAverage());
            }
        }
    }

    public void studyAverageSubject()
    {
        double studyAverageTechnical = 0;
        double studyAverageHumanitarian = 0;

        ArrayList<Student> ListStudyAvrtageTechnical = new ArrayList<>();
        ArrayList<Student> ListStudyAverageHumanitaria = new ArrayList<>();

        for (Student i : valuesHashMap.values()) {
            if (i.getGrupe().equals("technical")) {
                ListStudyAvrtageTechnical.add(i);
            } else if (i.getGrupe().equals("humanitarian")){
                ListStudyAverageHumanitaria.add(i);
            }
        }
        try {
            for (Student i : ListStudyAvrtageTechnical) {
                studyAverageTechnical += i.getAverage();
            }
            studyAverageTechnical = studyAverageTechnical / ListStudyAvrtageTechnical.size();
            System.out.println("Average of technical: " + studyAverageTechnical);
        }
        catch (ArithmeticException e){
            System.out.println("No student in the group technical ");
        }

        try {
            for (Student i : ListStudyAverageHumanitaria) {
                studyAverageHumanitarian += i.getAverage();
            }
            studyAverageHumanitarian = studyAverageHumanitarian / ListStudyAverageHumanitaria.size();
            System.out.println("Average of humanitarian: " + studyAverageHumanitarian);
        }
        catch (ArithmeticException e){
            System.out.println("No student in the group humanitarian ");
        }
    }

    public void StudentsCount ()
    {
        ArrayList<Integer> keysArrayList= new ArrayList<Integer>(valuesHashMap.keySet());       //klíče
        Collection<Student> values = valuesHashMap.values();                                    //hodnoty
        ArrayList <Student> newHashMapList= new ArrayList<>(values);

        int countHO = 0;
        int countTO = 0;
        int countKS = 0;

        for (Student i : newHashMapList)
            if (i.getGrupe().equals("technical")) {
                countTO++;
            }
        System.out.println("Technical students = " + countTO);

        for (Student i : newHashMapList)
            if (i.getGrupe().equals("humanitarian")) {
                countHO++;
            }
        System.out.println("Humanitarian students = " + countHO);

        for (Student i : newHashMapList)
            if (i.getGrupe().equals("combined")) {
                countKS++;
            }
        System.out.println("Combined students = " + countKS);
    }

    public void SaveToFile() throws IOException
    {
        ArrayList<Integer> keysArrayList= new ArrayList<Integer>(valuesHashMap.keySet());       //klíče
        Collection<Student> values = valuesHashMap.values();                                    //hodnoty
        ArrayList <Student> newHashMapList = new ArrayList<>(values);


        File file = new File("data.txt");
        PrintWriter pw = new PrintWriter(new FileOutputStream("data.txt"));
        BufferedWriter bf = null;

        try {
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            // iterate map entries
            for (Student i : newHashMapList){
               pw.write(i.SaveToFile() + "\n");
            }
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bf.close();
            } catch (Exception e) {
            }
        }
    }

    public void LoadFormFile ()
    {
        BufferedReader br = null;

        try {
            System.out.println("file was loaded successfully");

            File file = new File("dataTEST.txt");
            br = new BufferedReader(new FileReader(file));

            String line = null;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",", 8);

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String surname = parts[2].trim();
                int day = Integer.parseInt(parts[3].trim());
                int month = Integer.parseInt(parts[4].trim());
                int year = Integer.parseInt(parts[5].trim());
                String group = parts[6].trim();
                String grade = parts[7].trim();

                List<Integer> intList = null;

                    String[] numberOnly = grade.replaceAll("\\[", "")                   //split grates to string array
                            .replaceAll(" ", "")
                            .replaceAll("]", "")
                            .split(",");

                try {
                    Integer[] arr2 = Stream.of(numberOnly).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);         //strig array to int array
                    for (int i = 0; i < arr2.length; i++) {
                    }

                    intList = new ArrayList<Integer>(arr2.length);
                    for (int i : arr2) {
                        intList.add(i);
                    }
                    if (!name.equals(""))
                        valuesHashMap.put(id, new Obor(id, name, surname, day, month, year, group));
                        valuesHashMap.get(id).setGradeToArrayList((ArrayList<Integer>) intList);
                } catch (NumberFormatException e) {
                    valuesHashMap.put(id, new Obor(id, name, surname, day, month, year, group));
                }
            }
        }
        catch (Exception e) {
            System.out.println("file not found");
        }
        finally {
        if (br != null) {
            try {
                br.close();
            }
            catch (Exception e) {
            };
        }
        }
    }

    public void setGradefromSQL (int id, List<Integer> intList)
    {
        try {
            valuesHashMap.get(id).setGradeToArrayList((ArrayList<Integer>) intList);
        } catch (NumberFormatException e) {
        }
    }

    public HashMap<Integer, Student> getValuesHashMap(){
        return valuesHashMap;
    }

    public void addtoHashMapfromSQL(int id, Student student){
        valuesHashMap.put(id, student);
    }

    public String PrestupnyRok(int id)
    {
        int year;
        year = valuesHashMap.get(id).getYear();
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
            return "yes";
        else
            return "no";
    }

    public String Znameni(int id)
    {
        int day = valuesHashMap.get(id).getDay();
        int month = valuesHashMap.get(id).getMonth();

        if      ((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19)) {
            return "Capricorn";
        }
        else if ((month ==  1 && day >= 20 && day <= 31) || (month ==  2 && day >= 1 && day <= 17)) {
            return "Aquarius";
        }
        else if ((month ==  2 && day >= 18 && day <= 29) || (month ==  3 && day >= 1 && day <= 19)) {
            return "Pisces";
        }
        else if ((month ==  3 && day >= 20 && day <= 31) || (month ==  4 && day >= 1 && day <= 19)){
            return "Aries";
        }
        else if ((month ==  4 && day >= 20 && day <= 30) || (month ==  5 && day >= 1 && day <= 20)) {
            return "Taurus";
        }
        else if ((month ==  5 && day >= 21 && day <= 31) || (month ==  6 && day >= 1 && day <= 20)) {
            return "Gemini";
        }
        else if ((month ==  6 && day >= 21 && day <= 30) || (month ==  7 && day >= 1 && day <= 22)) {
            return "Cancer";
        }
        else if ((month ==  7 && day >= 23 && day <= 31) || (month ==  8 && day >= 1 && day <= 22)) {
            return "Leo";
        }
        else if ((month ==  8 && day >= 23 && day <= 31) || (month ==  9 && day >= 1 && day <= 22)) {
            return "Virgo";
        }
        else if ((month ==  9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22)) {
            return "Libra";
        }
        else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21)) {
            return "Scorpio";
        }
        else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21)) {
            return "Sagittarius";
        }
        else{
            return "Wrong date";
        }
    }

}
