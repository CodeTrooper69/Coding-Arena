public class person {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
Public sclass main {
    public static void main(String[] args) {
        Person person = new Person();

        // Set the values
        person.setName("John Doe");
        person.setAge(25);
        person.setAddress("123 Main Street");

        // Retrieve the values
        String name = person.getName();
        int age = person.getAge();
        String address = person.getAddress();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}
