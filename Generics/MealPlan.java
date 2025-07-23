import java.util.*;

//  Interface for meal plans
interface MealPlan {
    String getMealType();
    List<String> getMeals();
}

//  Subtypes of MealPlan
class VegetarianMeal implements MealPlan {
    public String getMealType() { return "Vegetarian"; }

    public List<String> getMeals() {
        return Arrays.asList("Paneer Curry", "Vegetable Pulao", "Dal Tadka");
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() { return "Vegan"; }

    public List<String> getMeals() {
        return Arrays.asList("Tofu Stir Fry", "Quinoa Salad", "Vegan Curry");
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() { return "Keto"; }

    public List<String> getMeals() {
        return Arrays.asList("Grilled Chicken", "Avocado Salad", "Zucchini Noodles");
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() { return "High-Protein"; }

    public List<String> getMeals() {
        return Arrays.asList("Boiled Eggs", "Protein Shake", "Grilled Fish");
    }
}

//  Generic Meal Wrapper
class Meal<T extends MealPlan> {
    private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public T getPlan() {
        return plan;
    }

    public void showPlan() {
        System.out.println("=== " + plan.getMealType() + " Meal Plan ===");
        for (String meal : plan.getMeals()) {
            System.out.println("• " + meal);
        }
    }
}

//  Utility class with generic method
class MealGenerator {
    public static <T extends MealPlan> Meal<T> generatePlan(T plan) {
        System.out.println("Validating " + plan.getMealType() + " meal...");
        if (plan.getMeals().isEmpty()) {
            throw new IllegalArgumentException("Meal plan is empty!");
        }
        System.out.println("Validation successful!");
        return new Meal<>(plan);
    }
}

//  Main class to test the system
public class MealPlanSystem {
    public static void main(String[] args) {
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal protein = new HighProteinMeal();

        // Generate and show personalized plans
        Meal<VegetarianMeal> vegPlan = MealGenerator.generatePlan(veg);
        Meal<VeganMeal> veganPlan = MealGenerator.generatePlan(vegan);
        Meal<KetoMeal> ketoPlan = MealGenerator.generatePlan(keto);
        Meal<HighProteinMeal> proteinPlan = MealGenerator.generatePlan(protein);

        System.out.println();
        vegPlan.showPlan();
        System.out.println();
        veganPlan.showPlan();
        System.out.println();
        ketoPlan.showPlan();
        System.out.println();
        proteinPlan.showPlan();
    }
}
