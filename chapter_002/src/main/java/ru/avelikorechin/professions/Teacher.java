package ru.avelikorechin.professions;

/**
 * Teacher class.
 * @author Alexander Velikorechin
 * @since 06.02.2017
 */
public class Teacher extends Profession {
    /**
     * Is teacher a class teacher.
     */
    private boolean isClassTeacher;
    /**
     * School number.
     */
    private int school;

    /**
     * Constructor for teacher class.
     * @param name of teacher
     * @param specialization of teacher
     */
    public Teacher(String name, String specialization) {
        this.setName(name);
        this.setSpecialization(specialization);
    }

    /**
     * Give homework to group.
     * @param group to give task
     * @param theme of task
     */
    private void giveHomework(Group group, String theme) {
        group.setAssignedTask(theme);
    }

    /**
     * Put mark for student.
     * @param student to put mark for
     * @param mark of student
     */
    private void putMark(Student student, int mark) {
        student.setLastMark(mark);
    }

    /**
     * Check homework of student.
     * @param student to check homework of
     */
    private void checkHomework(Student student) {
        final int homeworkMark = 5;
        putMark(student, homeworkMark);
    }

    /**
     * Call student's parents.
     * @param student to call parents of
     */
    private void callParents(Student student) {
        student.setAreParentsCalled(true);
    }

    /**
     * Represent teacher to class.
     */
    private void selfRepresent() {
        System.out.println("Hello. I am your teacher. My name is " + this.getName());
        System.out.println("I will teach you " + this.getSpecialization());
    }

    /**
     * Lead parental meeting.
     * @param group to lead meeting for
     */
    private void leadParentalMeeting(Group group) {
        group.setParentalMeetingHeld(true);
    }

    /**
     * Lead lesson.
     * @param group to lead lesson for
     * @param theme of lesson
     */
    private void leadLesson(Group group, String theme) {
        group.setLastLessonTheme(theme);
    }

    /**
     * Getter for if a teacher a class teacher.
     * @return is a class teacher or not
     */
    public boolean getIsClassTeacher() {
        return this.isClassTeacher;
    }

    /**
     * Getter for school.
     * @return school in which teacher work
     */
    public int getSchool() {
        return this.school;
    }

    /**
     * Setter for isClass teacher.
     * @param newIsClassTeacher to set
     */
    public void setIsClassTeacher(boolean newIsClassTeacher) {
        this.isClassTeacher = newIsClassTeacher;
    }

    /**
     * Setter for school in which teacher works.
     * @param newSchool to set
     */
    public void setSchool(int newSchool) {
        this.school = newSchool;
    }

}
