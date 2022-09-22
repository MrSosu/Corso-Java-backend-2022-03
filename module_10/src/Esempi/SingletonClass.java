package Esempi;

public class SingletonClass {

    private static SingletonClass singletonInstance;

    private SingletonClass() {}

    public static SingletonClass getInstance() {
        // se l'istanza è già stata creata
        if (singletonInstance != null) return singletonInstance;
        // se l'istanza non esiste
        singletonInstance = new SingletonClass();
        return singletonInstance;
    }

    public static void main(String[] args) {
        SingletonClass s1 = SingletonClass.getInstance();
        SingletonClass s2 = SingletonClass.getInstance();

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
