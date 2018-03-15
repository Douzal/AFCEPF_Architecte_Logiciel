package fr.afcepf.ai102.pattern;

public class TestSingleton {
    public static void main(String[] args) {
        UnSingleton single =
           UnSingleton.getInstance();
        System.out.println(single);
        for(int i = 0 ; i < 10 ; i++) {
            UnSingleton single2 =
                UnSingleton.getInstance();
            System.out.println(single2);
        }
    }
}
