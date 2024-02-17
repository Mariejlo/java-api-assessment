    package com.cbfacademy.foodcatalogue.subclassfooditem.model;
    
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Column;
    import javax.validation.constraints.Min;
    import javax.validation.constraints.NotNull;
    import javax.validation.constraints.Size;
 /**
* Represents a specific food item in the catalogue.
* Includes nutritional information and a method for calculating total calories.
*/
public class FoodItem extends FoodCatalogue {
   // FoodItem specific attributes, constructors, methods

       
    @Entity // Specifies that this class is an entity and is mapped to a database table
    public class FoodItem {
        
        @Id 
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;  //Unique identifier for each food item (check if private is needed?) 


        @NotNull(message = "Name cannot be null") //Ensures field not null
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters") // Filed size within range        private String name;
        @Column(name = "food_name", nullable = false, length = 100)
        private String name;  //Name of the food item
    
        @NotNull(message = "Serving size cannot be null")
        private String servingSize; //Describes the serving size of the food (e.g.,"100g","1 cup")

        @NotNull(message = "Calories per serving cannot be null")
        private Integer caloriesPerServing;   // Number of calories per serving (e.g. 100, 1000)
           //If we got extra time more attributes like price, category will be added 
         
        // Nutritional information
        @Min(value = 0, message = "Calories cannot be negative") 
        private double calories;

        @Min(value = 0, message = "Fats cannot be negative") 
        private double fats;

        @Min(value = 0, message = "Proteins cannot be negative") 
        private double proteins;

        @Min(value = 0, message = "Carbohydrates cannot be negative") 
        private double carbohydrates;

        @Min(value = 0, message = "Sugars cannot be negative") 
        private double sugars;
        
        public FoodItem() {
            // Constructor code no arguments
        }

        private Long id;
        private String name;
        private String servingSize;
        private Integer caloriesPerServing;    
   
        }
        public FoodItem() {
            //No argument constructor
        }
           // Constructor with all the attributes
        public FoodItem(Long id, String name, String servingSize, Integer caloriesPerServing) {
            this.id = id;
            this.name = name;
            this.servingSize = servingSize;
            this.caloriesPerServing = caloriesPerServing;
            this.fats = fats;
            this.proteins = proteins;
            this.carbohydrates = carbohydrates;
            this.sugars = sugars;
        }
    
    //Getters and setters for all attributes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public Integer getCaloriesPerServing() {
        return caloriesPerServing;
    }

    public void setCaloriesPerServing(Integer caloriesPerServing) {
        this.caloriesPerServing = caloriesPerServing;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }
    @Override
    public String toString() {
        String servingSize;
        String caloriesPerServing;
        String id;
        String name;
        return "FoodItem{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", servingSize='" + servingSize + '\'' +
               ", caloriesPerServing=" + caloriesPerServing +
               '}';

    }
      /**
       * Calculates the total caloric value of the food item based on its macronutrient content.
       * Uses the standard nutritional values:
       * - Carbohydrates: 4 calories per gram
       * - Proteins: 4 calories per gram
       * - Fats: 9 calories per gram
       * 
       * @return the total caloric value of the food item.
       */
public double calculateTotalCalories() {  


    // Method to calculate total calories of the food item
    // Assuming you want to sum these values; adjust the formula as needed
        return (fats*9) + (proteins*4) + (carbohydrates*4);
        //return calories;
        //return (fats*9) + (proteins*4) + (carbohydrates*4) + (sugars*4);

    }
}  