import java.util.*;

// Задание 1. Класс Airline
class Airline {
    private String destination;
    private String flightNumber;
    private String aircraftType;
    private String departureTime;
    private List<String> daysOfWeek;

    public Airline(String destination, String flightNumber, String aircraftType, String departureTime, List<String> daysOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.daysOfWeek = daysOfWeek;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    @Override
    public String toString() {
        return "Рейс: " + flightNumber + ", Назначение: " + destination + ", Тип самолета: " + aircraftType +
                ", Время: " + departureTime + ", Дни: " + daysOfWeek;
    }
}

// Задание 2. Классы для компонентов самолета
class Wing {
    private String type;

    public Wing(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Крыло: " + type;
    }
}

class Chassis {
    private String type;

    public Chassis(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Шасси: " + type;
    }
}

class Engine {
    private String model;

    public Engine(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Двигатель: " + model;
    }
}

// Класс Airplane
class Airplane {
    private String model;
    private Wing wing;
    private Chassis chassis;
    private Engine engine;

    public Airplane(String model, Wing wing, Chassis chassis, Engine engine) {
        this.model = model;
        this.wing = wing;
        this.chassis = chassis;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void displayComponents() {
        System.out.println("Модель самолета: " + model);
        System.out.println(wing);
        System.out.println(chassis);
        System.out.println(engine);
    }

    @Override
    public String toString() {
        return "Самолет: {Модель: " + model + ", " + wing + ", " + chassis + ", " + engine + "}";
    }
}

// Задание 3. Классы для авиакомпании
abstract class AbstractAirplane {
    private String model;
    private int capacity;
    private int cargoCapacity;
    private int flightRange;
    private int fuelConsumption;

    public AbstractAirplane(String model, int capacity, int cargoCapacity, int flightRange, int fuelConsumption) {
        this.model = model;
        this.capacity = capacity;
        this.cargoCapacity = cargoCapacity;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return model + ": [Вместимость: " + capacity + ", Грузоподъемность: " + cargoCapacity +
                ", Дальность полета: " + flightRange + ", Расход топлива: " + fuelConsumption + "]";
    }
}

class CargoAirplane extends AbstractAirplane {
    public CargoAirplane(String model, int capacity, int cargoCapacity, int flightRange, int fuelConsumption) {
        super(model, capacity, cargoCapacity, flightRange, fuelConsumption);
    }
}

class PassengerAirplane extends AbstractAirplane {
    public PassengerAirplane(String model, int capacity, int cargoCapacity, int flightRange, int fuelConsumption) {
        super(model, capacity, cargoCapacity, flightRange, fuelConsumption);
    }
}

class AirlineCompany {
    private List<AbstractAirplane> airplanes;
    private List<Airplane> detailedAirplanes;

    public AirlineCompany() {
        this.airplanes = new ArrayList<>();
        this.detailedAirplanes = new ArrayList<>();
    }

    public boolean addAirplane(AbstractAirplane airplane) {
        airplanes.add(airplane);
        System.out.println("Самолет добавлен: " + airplane);
    }

    public void addDetailedAirplane(Airplane airplane) {
        detailedAirplanes.add(airplane);
        System.out.println("Детализированный самолет добавлен: " + airplane);
    }

    public void removeAirplane(String model) {
        airplanes.removeIf(airplane -> airplane.getModel().equalsIgnoreCase(model));
        detailedAirplanes.removeIf(airplane -> airplane.getModel().equalsIgnoreCase(model));
        System.out.println("Самолет с моделью " + model + " удален.");
    }

    public void findAirplaneByRange(int minRange, int maxRange) {
        System.out.println("Самолеты с дальностью полета в диапазоне " + minRange + " - " + maxRange + ":");
        airplanes.stream()
                .filter(a -> a.getFlightRange() >= minRange && a.getFlightRange() <= maxRange)
                .forEach(System.out::println);
    }

    public void findAirplaneByFuelConsumption(int maxFuel) {
        System.out.println("Самолеты с расходом топлива меньше " + maxFuel + ":");
        airplanes.stream()
                .filter(a -> a.getFuelConsumption() <= maxFuel)
                .forEach(System.out::println);
    }

    public void displayComponentsByModel(String model) {
        detailedAirplanes.stream()
                .filter(a -> a.getModel().equalsIgnoreCase(model))
                .forEach(Airplane::displayComponents);
    }

    public void printAirplanes() {
        airplanes.forEach(System.out::println);
        detailedAirplanes.forEach(System.out::println);
    }
}

// Главное приложение
public class Main {

    public static final int AIRPLANE_LIST = 1;
    public static final int ADD_PLANE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Данныe для авиакомпании
        AirlineCompany company = new AirlineCompany();
        company.addAirplane(new CargoAirplane("CargoJet", 0, 20000, 5000, 500));
        company.addAirplane(new PassengerAirplane("PassengerJet", 180, 0, 3000, 400));
        company.addAirplane(new CargoAirplane("HeavyLifter", 0, 30000, 4000, 700));
        company.addAirplane(new PassengerAirplane("CommuterJet", 120, 0, 2000, 300));
        company.addAirplane(new PassengerAirplane("LongHaul", 250, 0, 10000, 800));
        company.addAirplane(new CargoAirplane("LightCargo", 0, 5000, 6000, 600));

        // Добавляем самолеты с компонентами
        company.addDetailedAirplane(new Airplane("CargoJet", new Wing("Большое грузовое крыло"), new Chassis("Тяжелое шасси"), new Engine("Дизельный двигатель")));
        company.addDetailedAirplane(new Airplane("PassengerJet", new Wing("Пассажирское крыло"), new Chassis("Легкое шасси"), new Engine("Реактивный двигатель")));

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Показать все самолеты");
            System.out.println("2. Добавить самолет");
            System.out.println("3. Удалить самолет");
            System.out.println("4. Найти самолет по диапазону дальности");
            System.out.println("5. Найти самолет по расходу топлива");
            System.out.println("6. Показать компоненты самолета по модели");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case AIRPLANE_LIST:
                    System.out.println("Список самолетов:");
                    company.printAirplanes();
                    break;
                case ADD_PLANE:
                    System.out.print("Введите модель: ");
                    String model = scanner.next();
                    System.out.print("Введите вместимость: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Введите грузоподъемность: ");
                    int cargoCapacity = scanner.nextInt();
                    System.out.print("Введите дальность полета: ");
                    int flightRange = scanner.nextInt();
                    System.out.print("Введите расход топлива: ");
                    int fuelConsumption = scanner.nextInt();
                    company.addAirplane(new CargoAirplane(model, capacity, cargoCapacity, flightRange, fuelConsumption));
                    System.out.println("Самолёт добавлен");
                    break;
                case 3:
                    System.out.print("Введите модель для удаления: ");
                    String removeModel = scanner.next();
                    company.removeAirplane(removeModel);
                    break;
                case 4:
                    System.out.print("Введите минимальную дальность: ");
                    int minRange = scanner.nextInt();
                    System.out.print("Введите максимальную дальность: ");
                    int maxRange = scanner.nextInt();
                    company.findAirplaneByRange(minRange, maxRange);
                    break;
                case 5:
                    System.out.print("Введите максимальный расход топлива: ");
                    int maxFuel = scanner.nextInt();
                    company.findAirplaneByFuelConsumption(maxFuel);
                    break;
                case 6:
                    System.out.print("Введите модель самолета: ");
                    String searchModel = scanner.next();
                    company.displayComponentsByModel(searchModel);
                    break;
                case 0:
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }
}
