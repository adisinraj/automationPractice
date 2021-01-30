package coderbyte;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeString {
	 public static String StringChallenge(String[] strArr) throws ParseException {
		 long smallestDifference=0;  
		 for(int j=0; j< strArr.length;j++){
		        for(int i=0; i<strArr.length;i++){
		          DateFormat date = new SimpleDateFormat("H:mma");
		          Date fromDate = date.parse(strArr[j]);
		          Date toDate = date.parse(strArr[i]); 
		          System.out.println(date.format(fromDate)+" :from------to:"+date.format(toDate));

		          long diff = Math.abs(toDate.getTime()-fromDate.getTime());
		          long diffInMinute = diff/(60*1000);
		           System.out.println("---->"+diffInMinute);
		           if(smallestDifference ==0 || (smallestDifference> diffInMinute && diffInMinute !=0))
		            smallestDifference = diffInMinute;
		        }
		      }

		      return smallestDifference+"";

		  }

		  public static void main (String[] args) throws ParseException {  
		    // keep this function call here     
		    Scanner s = new Scanner(System.in);
		    System.out.print(StringChallenge(new String[] {"10:00am", "11:45pm", "5:00am", "12:01am"})); 
		   // StringChallenge(new String[] {"1:10pm", "4:40am", "5:00pm"});
		  }

}
