package samplearrays;
import java.util.Arrays;

public class CourseNumbersArray {
    // 1. Initial array of registered courses
    private static int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

    // 2. Add course by allocating a larger array and copying elements
    public static int[] addCourse(int[] currentCourses, int newCourse) {
        int[] updatedCourses = new int[currentCourses.length + 1];
        for (int i = 0; i < currentCourses.length; i++) {
            updatedCourses[i] = currentCourses[i];
        }
        updatedCourses[updatedCourses.length - 1] = newCourse;
        return updatedCourses;
    }

    // 3. Print array contents
    public static void printCourses(int[] courses) {
        System.out.println("Courses: " + Arrays.toString(courses));
    }

    // 4. Check if course exists
    public static boolean containsCourse(int[] courses, int targetCourse) {
        for (int course : courses) {
            if (course == targetCourse) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        printCourses(registeredCourses);
        registeredCourses = addCourse(registeredCourses, 2200);
        printCourses(registeredCourses);
        System.out.println("Contains 2080: " + containsCourse(registeredCourses, 2080));
        System.out.println("Contains 9999: " + containsCourse(registeredCourses, 9999));
    }
}