
public class YearlyCalendar {
	
	public static void main(String[] args)
	{
		String date;
		int year = 2015;
		int count = 0;
		int tmp = 0;
		String[] siteDatumi;
		
		//Count all days
		for(int m=1; m<=12; m++)
		{
			count+=countDays(m, year);
		}
		
		System.out.println("Vkupno denovi: "+count);
		
		siteDatumi = new String[count];
		int days;
		for(int month = 1; month <= 12; month++)
		{
			days = countDays(month, year);
			for(int day = 1; day <= days; day++)
				{
					date = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
					siteDatumi[tmp] = date;
					tmp++;
				}
		}
		
		System.out.println("All dates in the year 2015 are: ");
		for(int i = 0; i < siteDatumi.length; i++)
		{
			System.out.println(siteDatumi[i]);
		}
		
	}

	static int countDays(int month, int year)
	{
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }
                if ((year % 100 == 0) & (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;
    }
	
}
