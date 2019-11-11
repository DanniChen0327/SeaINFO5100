package assignment8.StudentGUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


class StudentsModel implements TableModel {

    private StudentsManager manager;

    public StudentsModel(StudentsManager manager) {
        this.manager = manager;
    }

    @Override
    public int getRowCount() {
        return manager.getStudentCount();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Student ID";
        } else if(columnIndex == 1){
            return "Student Name";
        }else if(columnIndex == 2)
            return "Student Gender";
        else
            return "Student Country";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = manager.getStudents().get(rowIndex);
        if (columnIndex == 0) {
            return s.getId();
        } else if(columnIndex == 1){
            return s.getName();
        }else if(columnIndex == 2)
            return s.getGender();
        else
            return s.getCountry();

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

}

public class UniversityFrame extends BaseFrame {

    private JLabel studentId, name,gender,country;
    private JTextField idText, nameText, countryText;
    private JComboBox genderBox;
    private JButton add,modify;

    private JTable studentsTable;

    private StudentsModel model;

    private StudentsManager manager;

    @Override
    public void create() {

        JFrame frame = new JFrame("Danni Chen's student table");

        Container con = frame.getContentPane();
        BorderLayout b = new BorderLayout();
        con.setLayout(b);
        studentId = new JLabel("Student ID : ");  // add labels
        name = new JLabel("Student Name : ");
        gender = new JLabel("Student Gender");
        country = new JLabel("student country");

        idText = new JTextField(10); // add text fields
        nameText = new JTextField(10);
        countryText = new JTextField(10);

        String[] gender = new String[]{"Female", "Male"};  //add combobox
        genderBox = new JComboBox<String>(gender);


        add = new JButton("Add");  // add buttons
        modify = new JButton("Modify");

        frame.setSize(1200,800);
        frame.setVisible(true);

        try {
           manager = new StudentsManagerFileImpl();
        } catch (Exception e) {
        }
        model = new StudentsModel(manager);
        studentsTable = new JTable(model);
    }

    @Override
    public void add(Container con) {
        addText(con);

        con.add(new JScrollPane(studentsTable), "South");

    }

    public void addText(Container con){
        FlowLayout fl = new FlowLayout();
        con.setLayout(fl);
        addIdComponents(con);
        addNameComponents(con);
        addGenderComponents(con);
        addCountryComponents(con);
        con.add(add);
        con.add(modify);

    }

    public void addStudent(){
        String studentId = idText.getText();
        String studentname = nameText.getText();
        String gender = genderBox.getSelectedItem().toString();
        String country = countryText.getText();
        try {
            manager.addStudent(new Student(studentId, studentname, gender,country));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void modifyStudent(){
        studentsTable.revalidate();
    }


    private void addComponents(Container con, Component a, Component b) {
        JPanel panel = new JPanel();
        panel.add(a);
        panel.add(b);
        con.add(panel);


    }

    private void addIdComponents(Container con){
        addComponents(con, studentId, idText );
    }

    private void addNameComponents(Container con){
        addComponents(con, name, nameText );
    }

    private void addGenderComponents(Container con){
        addComponents(con, gender, genderBox );
    }

    private void addCountryComponents(Container con){
        addComponents(con, country, countryText );
    }

    @Override
    public void addListeners() {
        // TODO Auto-generated method stub
        add.addActionListener((e) -> addStudent());
        modify.addActionListener((e) -> modifyStudent());

    }

    public static void main(String[] args) {
        new UniversityFrame();

    }

}
