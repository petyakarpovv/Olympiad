import java.util.*;

public class Olympiad {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ярослав", "Баярунас", "Игоревич", Arrays.asList(2, 4, 5, 5)));
        students.add(new Student("Дарья", "Январина", "Игоревна", Arrays.asList(4, 3, 2, 5)));
        students.add(new Student("Алексей", "Маршалко", "Операторович", Arrays.asList(8, 3, 1, 3)));
        students.add(new Student("Николай", "Филлипов", "Лаптевич", Arrays.asList(5, 2, 7, 4)));
        students.add(new Student("Сергей", "Хохлов", "Настолкович", Arrays.asList(7, 2, 4, 4)));
        printWinners(students);
    }

    private static void printWinners(List<Student> students) {
        sortStudents(students);
        System.out.println("Победители Олимпиады:");

        for (int i = students.size(); i > students.size() - 3; i--) {
            Student student = students.get(i - 1);
            System.out.println(student.getName() + " " + student.getSurname() + " " + student.getPatronymic() + " " + getAverage(student.getScore()));
        }
    }

    private static void sortStudents(List<Student> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (getAverage(students.get(j + 1).getScore()) < getAverage(students.get(j).getScore())) {
                    Student swap = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, swap);
                }
            }
        }
    }

    private static double getAverage(List<Integer> score) {
        int tasksCount = 0;
        double sumMarks = 0;
        for (Integer mark : score) {
            sumMarks += mark;
            tasksCount++;
        }
        return sumMarks / tasksCount;
    }
}