package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students == null || students.length == 0) return null;
        Student oldest = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() > oldest.getAge()) {
                oldest = students[i];
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for (Student s : students) {
            if (s.isAdult()) {
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length == 0) return Double.NaN;
        double sum = 0.0;
        for (Student s : students) {
            sum += s.getGrade();
        }
        return sum / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null; // return null if not found
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        // Using Arrays.sort() with a custom comparator as suggested
        Arrays.sort(students, new Comparator() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getGrade(), s1.getGrade());
            }
        });
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student s : students) {
            if (s.getGrade() >= 15) {
                // Print only the names as instructed
                System.out.println(s.getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        boolean hasDuplicates = false;
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getName().equalsIgnoreCase(students[j].getName())) {
                    System.out.println("Duplicates found"); //
                    hasDuplicates = true;
                    return true;
                }
            }
        }
        return hasDuplicates;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newArr = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newArr[i] = students[i];
        }
        newArr[newArr.length - 1] = newStudent;
        return newArr;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students using different constructors
        Student[] arr = new Student[5];
        arr[0] = new Student(1, "Yahya"); // 2 parameters
        arr[1] = new Student(2, "Omar", 17); // 3 parameters
        arr[2] = new Student(3, "Hamza", 21, 18); // 4 parameters
        arr[3] = new Student(4, "Amine", 18, 12);
        arr[4] = new Student(5, "Yahya", 20, 15); // Duplicate name for Task 9 test

        // Print all using a for loop
        System.out.println("== All Students ==");
        for (Student s : arr) {
            System.out.println(s);
        }
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("\nOldest student: " + findOldest(arr).getName());

        // 3) Count adults
        System.out.println("Number of adults: " + countAdults(arr));

        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(arr));

        // 5) Find by name
        System.out.println("\nFind 'Charlie': " + findStudentByName(arr, "Charlie"));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr, 4, 17);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println("Updated Student Record: " + findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("\nChecking for duplicates:");
        hasDuplicateNames(arr);

        // 10) Append new student
        System.out.println("\nAppending new student...");
        arr = appendStudent(arr, new Student(6, "Eve", 22, 19));
        System.out.println("New array size: " + arr.length);
        System.out.println("Last added student: " + arr[arr.length - 1]);
    }
}