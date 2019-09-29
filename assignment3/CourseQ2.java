package assignment3;

public class CourseQ2 {
    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private int credits;
    private int[] studentIds = new int[100];

    public void registerStudent(int studentId){
        for(int currentnum = 0; currentnum < studentIds.length; currentnum++){
            this.studentIds[currentnum] = studentId;
        }

    }

    public CourseQ2(int courseId){
        this.courseId = courseId;
        if(courseId <= 0)
            throw new IllegalArgumentException("the courseId should not be negative or 0, please input a new Id");
    }

    public CourseQ2(int courseId, int professorId){
        this(courseId);
        this.professorId = professorId;
    }

    public CourseQ2(int courseId, int professorId, int credits){
        this(courseId, professorId);
        this.credits = credits;
    }
    public void setCourseId(int courseId){    //setCourseId
        this.courseId = courseId;

    }

    public int getCourseId(){   //getCourseId
        return courseId;
    }

    public void setCourseName(String courseName){    //setCourseName
        this.courseName = courseName;
        if(courseName.length() < 10 || courseName.length() > 60){
            throw new IllegalArgumentException("the courseName should be a string with minimum length 10 and maximum 60");
        }
    }

    public String getCourseName(){     //getCourseName
        return courseName;

    }
    public void setMaxCapacity(int maxCapacity){    //setMaxCapacity
        this.maxCapacity = maxCapacity;
        if(maxCapacity < 10 || maxCapacity > 100){
            throw new IllegalArgumentException("maxCapacity should between 10 and 100");
        }
    }

    public int getMaxCapacity(){    //getMaxCapacity
        return maxCapacity;
    }

    public void setProfessorId(int professorId){    //setProfessorId
        this.professorId = professorId;
        int count = 0;
        while(professorId >= 1){
            professorId /= 10;
            count++;
        }
        if(count != 6){
            throw new IllegalArgumentException("processorId should be a six digit integer");
        }
    }

    public int getProfessorId(){    //getProfessorId
        return professorId;

    }

    public void setCredits(int credits){    //setCredits
        this.credits = credits;
        if(credits <= 0 || credits > 9){
            throw new IllegalArgumentException("credits should be a single digit but greater than 0");
        }
    }

    public int getCredits(){    //getCredits
        return credits;

    }

    public void setStudentIds(int studentIds[]){     //setStudentIds
        this.studentIds = studentIds;

    }

    public int getStudentIds(int i){     //getStudentIds
        return studentIds[i];

    }
    public static void main(String[] args){
        CourseQ2 test= new CourseQ2(1,200000);
        test.setProfessorId(300000);
        //test.setCourseName("agsuxgi");
        //test.setMaxCapacity(150);
        test.setCredits(8);
        System.out.println(test.getProfessorId());
        System.out.println(test.getCredits());

    }
}
