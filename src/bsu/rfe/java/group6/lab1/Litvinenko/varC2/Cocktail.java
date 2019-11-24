package bsu.rfe.java.group6.lab1.Litvinenko.varC2;

public class Cocktail extends Food {

    private String drink;
    private String fruit;

    public Cocktail(String drink, String fruit){

        super("Коктейль");
        this.drink = drink;
        this.fruit = fruit;
    }

    public void consume() {
        System.out.println(this+ " выпит" + "   Калорийность: " + this.calculateCalories());
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if(((Cocktail)arg0).fruit == null && ((Cocktail)arg0).drink == null) return true;
            if (!(arg0 instanceof Cocktail)) return false;
            if (drink.equals(((Cocktail)arg0).drink)) {
                if (fruit.equals(((Cocktail)arg0).fruit))
                    return true;
            }
            return false;
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " : " + drink + " + " + fruit;
    }

    @Override
    public int calculateCalories() {
        int calories = 0;
        if(drink.equals("Молоко")) {
            calories += 60;
        }
        if(drink.equals("Сок")) {
            calories += 45;
        }
        if(fruit.equals("Банан")) {
            calories += 65;
        }
        if(fruit.equals("Апельсин")) {
            calories += 40;
        }
        return calories;
    }
}
