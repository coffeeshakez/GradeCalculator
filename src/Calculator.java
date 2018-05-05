import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by david on 23/03/2018.
 */
public class Calculator {


    private boolean quit = false;
    private int grades = 0;
    private int totalStudyPoints = 0;

    public enum GRADECHART {
        A(5),
        B(4),
        C(3),
        D(2),
        E(1);

        private int value;

        GRADECHART(int value){

            this.value = value;

        }



        public int getGrade(){
            return this.value;

        }
    }

    public void getGradesFromInput() {



        Scanner scan = new Scanner(System.in);
        List<Integer> grades = new ArrayList<Integer>();

        while (!this.quit) {

            System.out.println("Enter grade: ");

            char character = Character.toUpperCase(scan.next().charAt(0));

            if ( character == 'Q' ){
                this.quit = true;
                continue;
            }

            int grade = getGradeFromCharacter(character);

            if(grade == -1){
                System.out.println("Grade has to be a-e");
                continue;
            }

            System.out.println("Enter total points for course");
            float points = scan.nextFloat();
            this.totalStudyPoints += points;

            this.grades += (grade * points);

        }
    }

    public int getGrade(){

        System.out.println("grades: " + this.grades + ", totalStudyPoints: " + totalStudyPoints);

        if(this.totalStudyPoints > 0){

            return (this.grades / this.totalStudyPoints);
        }

        return -1;
    }



    public int getGradeFromCharacter(char c){

        int grade = -1;

        switch (c){
            case 'A': grade = GRADECHART.A.getGrade();
            break;

            case 'B': grade =  GRADECHART.B.getGrade();
            break;

            case 'C': grade =  GRADECHART.C.getGrade();
            break;

            case 'D': grade = GRADECHART.D.getGrade();
            break;

            case 'E': grade =  GRADECHART.E.getGrade();
            break;


        }

        return grade;
    }


}