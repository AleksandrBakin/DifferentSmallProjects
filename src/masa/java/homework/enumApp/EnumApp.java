package masa.java.homework.enumApp;

import java.util.GregorianCalendar;

/**
 *   Перечисление должно содержать значения времён года,. т.е.: JAN, FEB, MAR... начиная с 10ти и с  прыжком 10
 *   Перечисление должно содержать переменную, содержащую среднюю температуру в каждом времени года.
 * Создать метод int getTemprature(AverageMonthTemprature month) который принимает на входе тип "месяц" и возвращает температуру в этом месяце
 * Добавить конструктор принимающий на вход среднюю температуру.
 */

public class EnumApp {
    enum Month {
        //JAN, FAB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;
        JAN(10), FAB(20), MAR(30), APR(40), MAY(50), JUN(60), JUL(70), AUG(80), SEP(90), OCT(100), NOV(110), DEC(120);

        private static final int[] AVERAGE_TEMPERATURE = {13, 15, 17, 19, 21, 24, 26, 27, 26, 23, 20, 15};
        private static final String[] NAME_IN_ENGLISH ={
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        private static final String[] NAME_IN_RUSSIAN ={
                "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        };

        private static final String[] NAME_IN_HEBREW ={
                "ינואר", "פברואר", "מארץ", "אפריל", "מאי", "יוני",
                "יולי", "אוגוסט", "ספטמבר", "אוקטובר", "נובמבר", "דצמבר"
        };


        private int num;

        Month(int num) {
            this.num = num;
        }

        public static int getTemp(Month month){
            int i = (month.num/10) - 1;
            return AVERAGE_TEMPERATURE[i];
            //return AVERAGE_TEMPERATURE[month.ordinal()];
        }

        public static String getEngName(Month month){
            //int i = (month.num/10) - 1;
            return NAME_IN_ENGLISH[month.ordinal()];
        }

        public static String getRusName(Month month){
            //int i = (month.num/10) - 1;
            return NAME_IN_RUSSIAN[month.ordinal()];
        }

        public static String getHebName(Month month){
            //int i = (month.num/10) - 1;
            return NAME_IN_HEBREW[month.ordinal()];
        }

        public int getTemp(){
            int i = (this.num/10) - 1;
            return AVERAGE_TEMPERATURE[i];
            //return AVERAGE_TEMPERATURE[this.ordinal()];
        }

        public String getEngName(){
            //int i = (this.num/10) - 1;
            return NAME_IN_ENGLISH[this.ordinal()];
        }

        public String getRusName(){
            //int i = (this.num/10) - 1;
            return NAME_IN_RUSSIAN[this.ordinal()];
        }

        public String getHebName(){
            //int i = (this.num/10) - 1;
            return NAME_IN_HEBREW[this.ordinal()];
        }
    }

    public static void main(String[] args) {
        Month month = Month.DEC;
        System.out.println("Average temp in this month in Tel Aviv: " + month.getTemp() + " C");
        System.out.println("English name of this month: " + month.getEngName());
        System.out.println("Russian name of this month: " + month.getRusName());
        System.out.println("Hebrew name of this month: " + month.getHebName());
    }
}
