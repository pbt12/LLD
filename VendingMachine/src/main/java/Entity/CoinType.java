package Entity;

public enum CoinType {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    FIFTY(50),
    HUNDRED(100);

    private final int value;
    CoinType(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
