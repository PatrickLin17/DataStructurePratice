package test;

public class Student {
    private String name;
    private int age;
    private Dog dog;

    public String getName() {
        return name;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.changeColor(new Dog("pink"));
        System.out.println(student);
    }
    public void changeColor(Dog newDog){
        if (this.dog==null){
            this.dog=new Dog();
        }

        this.dog = newDog;

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

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Student(String name, int age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
    }


}
