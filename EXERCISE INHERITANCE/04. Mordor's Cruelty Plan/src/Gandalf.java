public class Gandalf {
    private int foodPoints;

    public Gandalf() {

    }

    public void eatFood(String food) {
        switch (food.toLowerCase()) {
            case "cram":
                this.foodPoints += 2;
                break;
            case "lembas":
                this.foodPoints += 3;
                break;
            case "apple":
                this.foodPoints += 1;
                break;
            case "melon":
                this.foodPoints += 1;
                break;
            case "honeycake":
                this.foodPoints += 5;
                break;
            case "mushrooms":
                this.foodPoints -= 10;
                break;
            default:
                this.foodPoints -= 1;
                break;
        }
    }

    public int getFoodPoints() {
        return this.foodPoints;
    }

    public String getMood() {
        if (this.foodPoints < -5) {
            return "Angry";
        }
        else if(this.foodPoints < 0){
            return "Sad";
        }
        else if(this.foodPoints < 15){
            return "Happy";
        }
        else{
            return "JavaScript";
        }
    }

    @Override
    public String toString() {
        return String.format("%d%n%s",
                this.getFoodPoints(),
                this.getMood());
    }
}
