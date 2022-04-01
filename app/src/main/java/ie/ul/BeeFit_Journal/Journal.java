package ie.ul.BeeFit_Journal;

import java.io.Serializable;

public class Journal implements Serializable {

    public String foodName;
    public String foodCal;
    public String foodPro;
    public String foodFat;
    public String foodCarbs;
    public String foodFibre;
    public String foodSugar;

    public Journal() {

    }

    public Journal(String foodName, String foodCal,String foodPro,String foodFat,String foodCarbs,String foodFibre,String foodSugar){
        this.foodName=foodName;
        this.foodCal =foodCal;
        this.foodPro =foodPro;
        this.foodFat =foodFat;
        this.foodCarbs =foodCarbs;
        this.foodFibre =foodFibre;
        this.foodSugar =foodSugar;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodCal() {
        return foodCal;
    }

    public void setFoodCal(String foodCal) {
        this.foodCal = foodCal;
    }

    public String getFoodPro() {
        return foodPro;
    }

    public void setFoodPro(String foodPro) {
        this.foodPro = foodPro;
    }

    public String getFoodFat() {
        return foodFat;
    }

    public void setFoodFat(String foodFat) {
        this.foodFat = foodFat;
    }

    public String getFoodCarbs() {
        return foodCarbs;
    }

    public void setFoodCarbs(String foodCarbs) {
        this.foodCarbs = foodCarbs;
    }

    public String getFoodFibre() {
        return foodFibre;
    }

    public void setFoodFibre(String foodFibre) {
        this.foodFibre = foodFibre;
    }

    public String getFoodSugar() {
        return foodSugar;
    }

    public void setFoodSugar(String foodSugar) {
        this.foodSugar = foodSugar;
    }


}
