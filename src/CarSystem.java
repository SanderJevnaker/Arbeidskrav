import java.util.*;

public class CarSystem {
    ArrayList<Person> personList = new ArrayList<>();
    ArrayList<Car> carList = new ArrayList<>();
    ArrayList<Integer> personAgeList = new ArrayList<>();
    ArrayList<Integer> carAgeList = new ArrayList<>();
    ArrayList<Integer> carMilageList = new ArrayList<>();


    Calendar calendar = Calendar.getInstance();

    public CarSystem() {
    }

    public void create() {

        Person person1 = new Person("Sander Jevnaker", 1996);
        Person person2 = new Person("Fredrik Wæge", 1988);
        Person person3 = new Person("Daniel Engelstad", 2000);
        Person person4 = new Person("Marcus Øksnes", 1996);
        personList.addAll(List.of(new Person[]{person1, person2, person3, person4}));

        Car car1 = new Car.Truck("Volvo", "FM LNG", 2016, 42000, "2018-06-06", person1);
        Car car2 = new Car.Van("Ford", "Transit", 2021, 3020, "2022-02-15", person2);
        Car car3 = new Car.Personal("Toyota", "Prius", 2009, 162903, "2021-10-11", person2);
        Car car4 = new Car.Personal("Ferrari", "F150", 2019, 50006, "2020-03-01", person4);
        carList.addAll(List.of(new Car[]{car1, car2, car3, car4}));

        carAgeList.addAll(List.of(calendar.get(Calendar.YEAR) - car1.getProductionYear(),
                (calendar.get(Calendar.YEAR) - car2.getProductionYear()),
                (calendar.get(Calendar.YEAR) - car3.getProductionYear()),
                (calendar.get(Calendar.YEAR) - car4.getProductionYear())));

        personAgeList.addAll(List.of((calendar.get(Calendar.YEAR) - person1.getBirthYear()),
                (calendar.get(Calendar.YEAR) - person2.getBirthYear()),
                (calendar.get(Calendar.YEAR) - person3.getBirthYear()),
                (calendar.get(Calendar.YEAR) - person4.getBirthYear())));

        carMilageList.addAll(List.of(car1.getMilage(),
                car2.getMilage(),
                car3.getMilage(),
                car4.getMilage()));
    }

    public void display() {
        for (Person person : personList) {
            person.display();
            for (Car car : carList) {
                if (car.getOwnedBy() == person.getId()) {
                    car.display();
                }
            }
        }
    }

    public void displayAverageAgePerson() {

        int averageAgePerson = (int) personAgeList.stream()
                .mapToInt(d -> d)
                .average()
                .orElse(0);

        System.out.println("The average car owner age is: " + averageAgePerson);
    }

    public void displayAverageCarAge() {

        int averageCarAge = (int) carAgeList.stream()
                .mapToInt(d -> d)
                .average()
                .orElse(0);

        System.out.println("The average car age is: " + averageCarAge);
    }

    public void displayAverageCarMilage() {

        int averageCarMilage = (int) carMilageList.stream()
                .mapToInt(d -> d)
                .average()
                .orElse(0);

        System.out.println("The average car milage is: " + averageCarMilage);
// FDLDD
    }
}
