interface PhoneInterface {
    public static final int TIMEOUT = 10000; // public static final 생략 가능
    public abstract void sendCall();
    public abstract void receiveCall();
    public default void printLogo() {
        System.out.println("Phone");
    }
}
