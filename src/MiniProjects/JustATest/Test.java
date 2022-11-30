package MiniProjects.JustATest;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("" + 7 + '-');
        System.out.println(7 + '-' + "");

        /*
        enum Days {
            MONDAY,
            TUESDAY,
            WEDNESDAY,
            THURSDAY
        }

        int i = 3;
        System.out.println(Days.values()[i]);
        Scanner strScanner = new Scanner(System.in);
        int timerForMinutes, timerForSeconds;

        System.out.println("Введите параметры таймера");

        System.out.print("Минуты : ");
        timerForMinutes = strScanner.nextInt();

        System.out.print("Секунды : ");
        timerForSeconds = strScanner.nextInt();
        System.out.println();

        System.out.println("Таймер на " + timerForMinutes + ":" + timerForSeconds + " готов!");
        System.out.println("Стартуем?!");
        strScanner.next();

        Date startTime = new Date();

        long endTime = startTime.getTime() + (timerForMinutes * 60 * 1000) + (timerForSeconds * 1000);  // +5 секунд
        Date endDate = new Date(endTime);
        boolean flag = false;

        while (flag == false) {
            Thread.sleep(1000);  // ждем 1 секунду
            Date currentTime = new Date();
            if (currentTime.after(endDate))//проверяем что время currentTime после endDate
            {
                System.out.println("End time!");
                flag = true;
            } else {
                System.out.println("Wait a bit!");
            }
         */
            //Date pointZero = new Date(0);
            //System.out.println("Точка отсчета " + pointZero);
            //int a = 'a';
            //int f = 'f';
            //int zero = '0';
            //int nine = '9';
            //System.out.println("a code " + a);
            //System.out.println("f code " + f);
            //System.out.println("0 code " + zero);
            //System.out.println("9 code " + nine);
            //int random = 60;
            //if( (random < '0' || random > '9') && (random < 'a' || random > 'f' )) {
            //    System.out.println("Not in range!");;
            //}
        //}
    }
}