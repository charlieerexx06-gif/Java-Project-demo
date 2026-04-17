class Owner extends User {

    Owner(String name, String studentId) {
        super(name, studentId);
    }

    void showRole() {
        System.out.println("This is an owner");
    }
}