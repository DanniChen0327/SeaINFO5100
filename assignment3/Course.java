package assignment3;

public class Course {
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

    public Course(int courseId){
        this.courseId = courseId;
    }

    public Course(int courseId, int professorId){
        this(courseId);
        this.professorId = professorId;
    }

    public Course(int courseId, int professorId, int credits){
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
    }

    public String getCourseName(){     //getCourseName
        return courseName;

    }
    public void setMaxCapacity(int maxCapacity){    //setMaxCapacity
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity(){    //getMaxCapacity
        return maxCapacity;
    }

    public void setProfessorId(int professorId){    //setProfessorId
        this.professorId = professorId;
    }

    public int getProfessorId(){    //getProfessorId
        return professorId;

    }

    public void setCredits(int credits){    //setCredits
        this.credits = credits;
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
}
