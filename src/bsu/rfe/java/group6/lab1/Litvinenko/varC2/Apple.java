package bsu.rfe.java.group6.lab1.Litvinenko.varC2;

public class Apple extends Food {

    private String size;

    public Apple(String size){
        // Вызвать конструктор предка, передав ему имя класса
        super("Яблоко");
        // Инициализировать размер яблока
        this.size = size;
    }

    // Переопределить способ употребления яблока
    public void consume() {
        System.out.println(this+ " съедено" + "   Калорийность: " + this.calculateCalories());
    }

    // Селектор для доступа к полю данных РАЗМЕР
    public String getSize() {
        return size;
    }

    // Модификатор для изменения поля данных РАЗМЕР

    public void setSize(String size) {
        this.size = size;
    }

// Переопределѐнная версия метода equals(), которая при сравнении
// учитывает не только поле name (Шаг 1), но и проверяет совместимость
// типов (Шаг 2) и совпадение размеров (Шаг 3)
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (((Apple)arg0).size == null) return true;
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }

    // Переопределѐнная версия метода toString(), возвращающая не только
// название продукта, но и его размер
    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

    @Override
    public int calculateCalories() {
        if(size.equals("Большое")) {
            return 300;
        }
        if(size.equals("Маленькое")) {
            return 15;
        }
        return 20;
    }
}
