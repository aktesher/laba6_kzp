package ki301_kutsenko_lab6;
/**
 * Класс, представляющий пассажира с именем и возрастом.
 * 
 * Реализует интерфейс {@link Comparable} для сравнения пассажиров по возрасту.
 */
public class Passenger implements Comparable<Passenger> 
{
	/**
     * Имя пассажира.
     */
    private String name;
    /**
     * Возраст пассажира.
     */
    private int age;
    /**
     * Конструктор для создания экземпляра пассажира.
     * 
     * @param name Имя пассажира.
     * @param age  Возраст пассажира.
     */
    public Passenger(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }
    /**
     * Сравнивает текущего пассажира с другим пассажиром по возрасту.
     * 
     * @param other Другой экземпляр {@link Passenger}, с которым производится сравнение.
     * @return Отрицательное число, если текущий пассажир моложе другого.
     *         Ноль, если их возраст равен.
     *         Положительное число, если текущий пассажир старше другого.
     */
    @Override
    public int compareTo(Passenger other)
    {
        return Integer.compare(this.age, other.age);
    }
    /**
     * Возвращает строковое представление пассажира.
     * 
     * @return Строка, содержащая имя и возраст пассажира в формате 
     *         "Passenger{name='имя', age=возраст}".
     */
    @Override
    public String toString()
    {
        return "Passenger{name='" + name + "', age=" + age + "}";
    }
}