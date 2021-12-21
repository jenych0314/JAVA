public class InterfaceEx {
    public static void main(String[] args) {
        SamsungPhone phone = new SamsungPhone();
        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();
        phone.play();
        System.out.println("3과 5을 더하면 " + phone.calculate(3, 5));
        phone.schedule();
    }
}
