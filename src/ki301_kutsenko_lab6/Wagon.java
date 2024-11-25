package ki301_kutsenko_lab6;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс, представляющий универсальный вагон для хранения элементов определенного типа.
 * 
 * @param <T> Тип элементов, которые могут храниться в вагоне. Тип должен реализовывать интерфейс {@link Comparable}.
 */
public class Wagon<T extends Comparable<T>> 
{
	/**
     * Список элементов, хранящихся в вагоне.
     */
    private List<T> items;
    /**
     * Конструктор для создания пустого вагона.
     */
    public Wagon()
    {
        items = new ArrayList<>();
    }
    /**
     * Добавляет элемент в вагон.
     * 
     * @param item Элемент, который нужно добавить.
     */
    public void addItem(T item)
    {
        items.add(item);
    }
    /**
     * Удаляет элемент из вагона.
     * 
     * @param item Элемент, который нужно удалить.
     */
    public void removeItem(T item) 
    {
        items.remove(item);
    }
    /**
     * Находит максимальный элемент в вагоне.
     * 
     * @return Максимальный элемент в вагоне. Если вагон пуст, возвращается {@code null}.
     */
    public T findMaxItem() 
    {
        if (items.isEmpty()) 
        {
            return null;
        }
        T max = items.get(0);
        for (T item : items) {
            if (item.compareTo(max) > 0) 
            {
                max = item;
            }
        }
        return max;
    }
    /**
     * Отображает содержимое вагона.
     * Если вагон пуст, выводится сообщение об этом.
     * Если вагон содержит элементы, они выводятся в консоль.
     */
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Вагон пуст.");
        } else {
            System.out.println("Содержимое вагона: " + items);
        }
    }
}

