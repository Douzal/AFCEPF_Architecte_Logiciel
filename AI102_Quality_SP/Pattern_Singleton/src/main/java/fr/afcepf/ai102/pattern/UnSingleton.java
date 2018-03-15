package fr.afcepf.ai102.pattern;
public class UnSingleton {
    private static UnSingleton instance;
    static {
        instance = new UnSingleton();
    }
    private UnSingleton() {
    }
    public static UnSingleton getInstance() {
        return instance;
    }
}