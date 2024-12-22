public class AnalogHashSet {
    private HashNode[] nodes = new HashNode[10_000_000]; // Оголошуємо новий масив типу класу HashNode розміром у 10_000_000 елементів (умовно наша ХешТаблиця)
    private int size = 0; // Поле класу - розмір нашої ХешТаблиці

    public AnalogHashSet() { // Конструктор класу
        for (int i = 0; i < nodes.length; i++) { // Кожен елемент масиву є новим об'єктом класу HashNode
            nodes[i] = new HashNode();
        }
    }

    public int returnIndex(String value) { // Метод для повернення індексу елемента за значенням
        int index = 0; // Змінна для індексу
        char[] arrayElements = value.toCharArray(); // Розбиваємо рядок на масив символів
        for (char i = 0; i < arrayElements.length; i++) { // Проходимо по кожному символу нового елемента
            index += arrayElements[i]; // Додаємо значення кожного символу до змінної index
        }
        return index; // Повертаємо значення індексу
    }

    public boolean add(String value) { // Метод для додавання нового елемента в ХешТаблицю
        int ind = returnIndex(value); // Викликаємо метод для отримання індексу
        if (contains(value)) { // Якщо елемент вже присутній
            return false; // Не додаємо його
        }
        HashNode node = new HashNode(value, null); // Створюємо новий об'єкт HashNode із заданим значенням

        if (nodes[ind].getNext() == null) { // Якщо в таблиці ще немає елементів
            nodes[ind].setNext(node); // Додаємо новий вузол
        } else { // Інакше
            node.setNext(nodes[ind].getNext()); // Вставляємо новий вузол на початок
            nodes[ind].setNext(node);
        }
        size++; // Збільшуємо розмір таблиці
        return true; // Повертаємо true - елемент додано
    }

    public boolean remove(String value) { // Метод для видалення елемента за значенням
        if (!contains(value)) { // Якщо елемент відсутній
            return false; // Нічого не робимо
        }
        int ind = returnIndex(value); // Отримуємо індекс елемента
        HashNode node = nodes[ind]; // Вузол за індексом
        HashNode node2 = node.getNext(); // Наступний вузол
        while (node2 != null) { // Поки вузол не порожній
            if (node2.getMsg().equals(value)) { // Якщо значення співпадає
                node.setNext(node2.getNext()); // Видаляємо вузол
                size--; // Зменшуємо розмір таблиці
                break; // Виходимо з циклу
            }
            node = node.getNext(); // Переходимо до наступного вузла
            node2 = node.getNext(); // Оновлюємо наступний вузол
        }
        return true; // Повертаємо true
    }

    public void print() { // Метод для виведення ХешТаблиці в консоль
        for (int i = 0; i < nodes.length; i++) { // Проходимо по всій таблиці
            HashNode node = nodes[i].getNext(); // Отримуємо вузол

            if (node != null) { // Якщо вузол не порожній
                System.out.print(i + ": "); // Виводимо індекс
                System.out.print(node.getMsg()); // Виводимо значення вузла
            } else { // Інакше
                continue; // Пропускаємо ітерацію
            }
            System.out.println(); // Розділяємо новим рядком
        }
    }

    public int size() { // Метод повертає розмір таблиці
        return size; // Повертаємо значення змінної size
    }

    public boolean contains(String value) { // Метод перевіряє наявність елемента
        int ind = returnIndex(value); // Отримуємо індекс
        HashNode node = nodes[ind].getNext(); // Отримуємо вузол

        while (node != null) { // Поки вузол не порожній
            if (node.getMsg().equals(value) && node.getMsg().charAt(0) == value.charAt(0)) { // Якщо значення збігається
                return true; // Повертаємо true
            }
            node = node.getNext(); // Переходимо до наступного вузла
        }
        return false; // Повертаємо false, якщо елемент не знайдено
    }
}
