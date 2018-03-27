package revision.myCustomException;

public class NumberNotInRangeException extends Exception {

    public Object numberEntered;
    public Object minRange;
    public Object maxRange;

    public NumberNotInRangeException(){
        super();
    }

    public NumberNotInRangeException(String message){
        super(message);
    }

    @Override
    public String toString() {
        String finalMessage = " : The number you've Entered ";
        finalMessage += numberEntered;
        finalMessage += " is not in Range of ";
        finalMessage += minRange+" and "+ maxRange;
        return super.toString() + finalMessage;
    }
}
