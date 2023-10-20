import java.util.Scanner;

public class Remote {
    private Television myTV;

    public Remote(Television television) {
        myTV = television;
    }

    public void processInput(Scanner scanner) {
        System.out.print(
            "Enter Remote Command (0 = Power On, 1 = Channel Up, 2 = Channel Down, 3 = Volume Up, 4 = Volume Down, 5 = Power Off): ");
        try {
            int input = scanner.nextInt();
            if (input == 0) {
                myTV.powerOn();
            } else if (input == 1) {
                myTV.channelUp();
            } else if (input == 2) {
                myTV.channelDown();
            } else if (input == 3) {
                myTV.volumeUp();
            } else if (input == 4) {
                myTV.volumeDown();
            } else if (input == 5) {
                myTV.powerOff();

            }
        } catch (Exception e) {
            myTV.powerOff();
            System.exit(0);
        }
    }

}
