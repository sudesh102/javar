class Date {
    int day, month, year;
    Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    int isleap() {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return 1; 
        }else {
            return 0;
        }
    }

    long calculateDay() {
        int num_leap = year - 1;
        num_leap = num_leap / 4;
        int remain_yr = year - 1 - num_leap;
        int totalDay = (366 * num_leap) + (365 * remain_yr);
        int Days[] = {31, 28 + isleap(), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            totalDay += Days[i];
        }
        totalDay += day;
        return totalDay;
    }

    public static void main(String[] args) {
        int day = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);
        Date d = new Date(day, month, year);
        long tDays = d.calculateDay();
        int dayz = (int) tDays % 7;
        switch (dayz) {
            case 0:
                System.out.println("Saturday");
                break;
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
        }
    }
}
