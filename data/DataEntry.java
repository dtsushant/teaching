package revision.data;

import revision.myCustomException.NumberNotInRangeException;

import java.util.Scanner;

public class DataEntry {

    public Integer giveAnInteger(){
        Integer i = 0;
        while(true){
            try{
                Scanner scan = new Scanner(System.in);
                i = scan.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Invalid Entry, you must enter an Integer");
            }
        }
        return i ;
    }

    public String next(){
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public Integer nextInt(){
        return giveAnInteger();
    }

    public Character nextChar(){
        Scanner scan = new Scanner(System.in);
        return scan.next().charAt(0);
    }

    public Double nextDouble(){
        Double d = 0d;
        while (true){
            try {
                Scanner scan = new Scanner(System.in);
                d = scan.nextDouble();
                break;
            }catch (Exception e){
                System.out.println("Invalid Entry, You must enter a valid Decimal Value");
            }
        }
        return d;
    }

    public int nextIntegerWithRange(int minRange, int maxRange){
        int i=0;
            while (true){
                try{
                    i=nextInt();
                    if(i<minRange || i > maxRange)
                    {
                        NumberNotInRangeException numberNotInRangeException = new NumberNotInRangeException();
                        numberNotInRangeException.numberEntered = i;
                        numberNotInRangeException.minRange = minRange;
                        numberNotInRangeException.maxRange = maxRange;
                        throw numberNotInRangeException;
                    }

                    break;
                }catch (Exception e){
                    System.out.println(e.toString());
                }
            }
        return i;
    }

    public double nextDoubleWithRange(int minRange, int maxRange){
        double i=0;
        while (true){
            try{
                i=nextDouble();
                if(i<minRange || i > maxRange)
                {
                    NumberNotInRangeException numberNotInRangeException = new NumberNotInRangeException();
                    numberNotInRangeException.numberEntered = i;
                    numberNotInRangeException.minRange = minRange;
                    numberNotInRangeException.maxRange = maxRange;
                    throw numberNotInRangeException;
                }

                break;
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
        return i;
    }



}
