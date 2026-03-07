//enum class can have variables, constructor, methods
//enum class doesn't extend other classes
//It cannot be initiated
//Tt can implement interfaces
//No other class can extend enum classes

public enum enumSample {

    MONDAY(1, "This is Monday."),
    TUESDAY(2, "This is Tuesday."),
    WEDNESDAY(3, "This is Wednesday"),
    THURSDAY(4, "This is Thursday"),
    FRIDAY(5, "This is Friday"),
    SATURDAY(6, "This is Saturday"),
    SUNDAY(7, "This is Sunday");

    int key;
    String val;

    enumSample(int key, String val) {
        this.key = key;
        this.val = val;
    }
    public static enumSample getComment(int key) {
        for(enumSample d : enumSample.values()){
            if(d.key == key){
                System.out.println(d.val);
                System.out.println("It's ordinal is: " + d.ordinal());
            }
        }
        return null;
    }

}
