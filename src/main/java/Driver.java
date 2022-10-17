import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Driver {

    int i;
    ArrayList<Student> studentArray = new ArrayList<>();
    Random random = new Random();


    Module softwareEngineering = new Module();
    Module hardwareDesign = new Module();
    Module anatomy = new Module();
    Module maths = new Module();
    Module structuralDesign = new Module();

    static courseProgramme computerScience = new courseProgramme();
    static courseProgramme computerEngineering = new courseProgramme();
    static courseProgramme medicine = new courseProgramme();
    String[] names = {"Michael", "Christopher", "Jessica", "Matthew", "Ashley", "Jennifer", "Joshua", "Amanda", "Daniel", "David", "James", "Robert", "John", "Joseph", "Andrew", "Ryan", "Brandon", "Jason", "Justin", "Sarah", "William", "Jonathan", "Stephanie", "Brian", "Nicole"};

    String[] lecturers = {"Steve", "John", "Ashley", "Jason", "Brain"};

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.generateStudentArray();
        driver.createModules();
        driver.addStudentsToModulesAndCourse();
        driver.createCourseProgrammes();

        driver.printCourses(computerScience);
        driver.printCourses(computerEngineering);
        driver.printCourses(medicine);


    }

    //prints courses
    private void printCourses(courseProgramme course) {
        //prints course name
        String output;
        System.out.println("Course Name: " + course.getName());

        //prints modules
        for (Module module : course.getModulesList()) {
            System.out.println("\t" + module.getModuleName());

            //prints students and their usernames
            for (Student student : module.getStudentList()) {
                output = String.format("\t\t%s %s\n\t\t\t%s",
                        student.getfName(), student.getlName(),student.getUsername()) ;

                //getting student modules and course
                String tempModuleOutput = "";
                for (Module module1 : student.getRegisteredModules()){
                    tempModuleOutput += module1.getModuleName() + "\n\t\t\t\t";
                }
                output += String.format("\n\t\t\t\t%s\t%s",
                        tempModuleOutput, student.getRegisteredCourse().get(0).getName());
//                if (module.getStudentList().contains(student)){
//                    output += String.format("\n\t\t\t\t%s\n\t\t\t\t\t%s",
//                            module.getModuleName(), student.getRegisteredCourse().get(0));
//                }


                System.out.println(output);

            }
        }

//        //prints students
//        for (Student student : course.getStudentsEnrolled()) {
//            System.out.println(student.getUsername());
//        }
//
//        //prints student usernames
//        for (Student student : course.getStudentsEnrolled()) {
//            System.out.println(student.getUsername());
//        }
//
//        //prints student modules
//        for (Student student : course.getStudentsEnrolled()) {
//            for (Student student1 : course.getStudentsEnrolled()) {
//                if (course.getStudentsEnrolled().contains(student1)) {
//                    System.out.println(student1);
//                }
//            }
//        }
//
//        //prints student courses
//        for (Student student : course.getStudentsEnrolled()) {
//            for (Student student1 : course.getStudentsEnrolled()) {
//                if (course.getStudentsEnrolled().contains(student1)) {
//                    System.out.println(student1);
//                }
//            }
//        }

    }

    //creates random students
    public void generateStudentArray() {
        for (i = 0; i < 25; i++) {
            Student inputStudent = new Student();
            inputStudent.setfName(names[i]);
            inputStudent.setlName(names[names.length - (i + 1)]);
            inputStudent.setAge(18 + i);
            inputStudent.setID(123 + 2 * i);
            inputStudent.setDOB(generateRandomDate());
            inputStudent.getUsername();

            studentArray.add(inputStudent);
        }
    }

    //creating course programmes
    private void createCourseProgrammes() {
        computerScience.setName("Computer Science");
        computerScience.setModulesList(softwareEngineering);
        computerScience.setModulesList(maths);

        computerEngineering.setName("Computer Engineering");
        computerEngineering.setModulesList(hardwareDesign);
        computerEngineering.setModulesList(structuralDesign);
        computerEngineering.setModulesList(maths);

        medicine.setName("Medicine");
        medicine.setModulesList(anatomy);


    }

    //create modules
    private void createModules() {
        softwareEngineering.setModuleName("Software Engineering");
        softwareEngineering.setID(123);

        hardwareDesign.setModuleName("Hardware Design");
        hardwareDesign.setID(124);

        anatomy.setModuleName("Anatomy");
        anatomy.setID(125);

        maths.setModuleName("Maths");
        maths.setID(126);

        structuralDesign.setModuleName("Structural Design");
        structuralDesign.setID(127);
    }

    //adding students to modules
    private void addStudentsToModulesAndCourse() {
        for (i = 0; i < 5; i++) {
            Student testStudent = new Student();

            //gets random student
            testStudent = studentArray.get(random.nextInt(studentArray.size()));
            testStudent.addModule(softwareEngineering);
            testStudent.addCourse(computerScience);
            softwareEngineering.addStudentToList(testStudent);

            testStudent = studentArray.get(random.nextInt(studentArray.size()));
            testStudent.addModule(hardwareDesign);
            testStudent.addCourse(computerEngineering);
            hardwareDesign.addStudentToList(testStudent);

            testStudent = studentArray.get(random.nextInt(studentArray.size()));
            testStudent.addModule(anatomy);
            testStudent.addCourse(medicine);
            anatomy.addStudentToList(testStudent);

            testStudent = studentArray.get(random.nextInt(studentArray.size()));
            testStudent.addModule(maths);
            testStudent.addCourse(computerScience);
            maths.addStudentToList(testStudent);

            testStudent = studentArray.get(random.nextInt(studentArray.size()));
            testStudent.addModule(structuralDesign);
            testStudent.addCourse(computerEngineering);
            structuralDesign.addStudentToList(testStudent);
        }


    }

    //creates random LocalDates
    private LocalDate generateRandomDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
