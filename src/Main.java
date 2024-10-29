public class Main {
    public static void main(String[] args)
    {
        StudentDao studentDao = new StudentDao();
        studentDao.connect();
        Student student =studentDao.getStudent(1789);
        System.out.println(student.name);

        Student student1 = new Student();
        student1.name = "Md Mareful Hasan Maruf";
        student1.rollNo = 1707004;
        studentDao.addStudent(student1);
    }
}

