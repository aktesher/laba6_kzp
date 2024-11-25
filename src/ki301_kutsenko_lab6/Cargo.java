package ki301_kutsenko_lab6;
/**
 * Класс, представляющий груз с именем и весом.
 * 
 * Реализует интерфейс {@link Comparable} для сравнения грузов по их весу.
 */
public class Cargo implements Comparable<Cargo>
{
	 /**
     * Название груза.
     */
    private String name;
    /**
     * Вес груза в условных единицах.
     */
    private int weight;
    /**
     * Конструктор для создания экземпляра груза.
     * 
     * @param name  Название груза.
     * @param weight Вес груза.
     */
    public Cargo(String name, int weight) 
    {
        this.name = name;
        this.weight = weight;
    }
    /**
     * Сравнивает текущий груз с другим грузом по весу.
     * 
     * @param other Другой экземпляр {@link Cargo}, с которым производится сравнение.
     * @return Отрицательное число, если текущий груз легче другого.
     *         Ноль, если их веса равны.
     *         Положительное число, если текущий груз тяжелее другого.
     */
    @Override
    public int compareTo(Cargo other) 
    {
        return Integer.compare(this.weight, other.weight);
    }
    /**
     * Возвращает строковое представление груза.
     * 
     * @return Строка, содержащая название и вес груза в формате 
     *         "Cargo{name='имя', weight=вес}".
     */
    @Override
    public String toString()
    {
        return "Cargo{name='" + name + "', weight=" + weight + "}";
    }
}
