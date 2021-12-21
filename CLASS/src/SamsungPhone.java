public class SamsungPhone extends PDA implements MobilePhoneInterface, MP3Interface {
    @Override
    public void sendCall() {
        System.out.println("띠리리리링");
    }
    @Override
    public void receiveCall() {
        System.out.println("전화가 왔습니다.");
    }
    public void flash() {
        System.out.println("전화기에 불이 켜졌습니다.");
    }

    @Override
    public void sendSMS() {
        System.out.println("문자 갑니다");
    }
    @Override
    public void receiveSMS() {
        System.out.println("문자 왔어요");
    }

    @Override
    public void play() {
        System.out.println("음악 연주합니다.");
    }
    @Override
    public void stop() {
        System.out.println("음악 중단합니다.");
    }

    public void schedule() {
        System.out.println("일정 관리합니다.");
    }
}
