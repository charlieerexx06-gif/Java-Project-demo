class Finder extends User {

    Finder(String name, String studentId) {
        super(name, studentId);
    }

    void showRole() {
        System.out.println("This is a finder");
    }
}