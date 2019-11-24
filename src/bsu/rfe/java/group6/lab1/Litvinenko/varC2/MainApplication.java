package bsu.rfe.java.group6.lab1.Litvinenko.varC2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class MainApplication {
    @SuppressWarnings("unchecked")
    public static void main (String[] args) throws  Exception{

        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;

        for (String arg: args) {
            String[] parts = arg.split("/");
            if(parts[0].equals("-calories")) {
                int calories = 0;
                for (Food item: breakfast) {
                    if(item != null) {
                        calories += item.calculateCalories();
                    }
                    else break;
                }
                System.out.println("Общая колорийность завтрака: " + calories);
                continue;
            }
            if (parts[0].equals("-sort")) {
                Arrays.sort(breakfast, new Comparator() {
                    public int compare(Object f1, Object f2) {
                        if (f1==null) return 1;
                        if (f2==null) return -1;
                        return ((Food)f2).calculateCalories() - ((Food)f1).calculateCalories();
                    }
                });
                continue;
            }
            try {
                Class myClass = Class.forName("bsu.rfe.java.group6.lab1.Litvinenko.varC2." + parts[0]);
                if (parts.length == 1) {
                    Constructor constructor = myClass.getConstructor();
                    breakfast[itemsSoFar] = (Food) constructor.newInstance();
                    itemsSoFar++;
                } else if (parts.length == 2) {
                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1]);
                    itemsSoFar++;
                } else if (parts.length == 3) {
                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1], parts[2]);
                    itemsSoFar++;
                }
            } catch (NoSuchMethodException |
                    ClassNotFoundException |
                    IllegalAccessException |
                    InvocationTargetException |
                    InstantiationException e) {
                System.out.println(" Продукт не может быть включен в завтрак.");
                continue;
            }
        }

        for (Food item: breakfast)
            if(item != null)
                item.consume();
            else
                break;
        count(breakfast);
        System.out.println("Всего хорошего!");
    }

    public static void count(Food[] breakfast) {
        int countApple = 0;
        int countCheese = 0;
        int countCocktail = 0;
        Apple exampleApple = new Apple(null);
        Cheese exampleCheese = new Cheese();
        Cocktail exampleCocktail = new Cocktail(null, null);
        for (Food item: breakfast) {
            if (item != null) {
                if (item.equals(exampleApple)) countApple++;
                if (item.equals(exampleCheese)) countCheese++;
                if (item.equals(exampleCocktail)) countCocktail++;
            }
            else {
                break;
            }
        }
        System.out.println("");
        System.out.println("Элементов класса Apple " + countApple);
        System.out.println("Элементов класса Cheese " + countCheese);
        System.out.println("Элементов класса Cocktail " + countCocktail);
        System.out.println("");
    }
}
