package assignment8.StudentGUI;

public class Student implements Comparable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return this.gender;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return this.country;
    }

    private String id;
    private String name;
    private String gender;
    private String country;

    public Student(String id, String name, String gender,String country) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.country = country;
    }

    public Student() {

    }

    public String toString() {
        return "[Name,Id] = [" + getName() + "," + getId() + "]";
    }

    public int hashCode() {
        return this.getId().hashCode();
    }

    public boolean equals(Object o) {
        Student s = (Student) o;
        return s.getId().equals(this.getId());
    }

    public int compareTo(Object o) {
        Student s = (Student) o;
        return this.getName().compareTo(s.getName());
        // return this.getId().compareTo(s.getId());
    }

}

