class User {
    String name;
    String studentId;

    User(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    void showRole() {
        System.out.println("This is a user");
    }
}