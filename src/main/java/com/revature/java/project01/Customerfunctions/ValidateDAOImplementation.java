package com.revature.java.project01.Customerfunctions;

import java.time.LocalDate;

public class ValidateDAOImplementation implements ValidateDAO{
	public static boolean Validatemail(String email) {
		int len=email.length();
		if(len<=10) {
			return false;
		}
		String str=email.substring(len-10);
		if(str.equals("@gmail.com") || str.equals("@GMAIL.COM")) {
			return true;
		}
		else {
		return false;
		}
 }
	public static boolean ValidatePhoneNumber(String phn) {
		if(phn.length()==6 || phn.length()==10) {
			return true;
		}
		else {
		return false;
	   }
	}
	public static boolean ValidatePassword(String pwd) {
		int splCharacter=0,upperCase=0,lowerCase=0,numeral=0;
		if(pwd.length()<8 || pwd.length()>10) {
			return false;
		}
		else {
		for(int i=0;i<pwd.length();i++) {
			int ascii=(int)pwd.charAt(i);
			if(ascii>=65 && ascii<=90) {
				upperCase++;
			}
			if(ascii>=97 && ascii<=122) {
				lowerCase++;
			}
			if(ascii>=33 && ascii<=47 || ascii>=58 &&  ascii<=64 || ascii>=91 && ascii<=96) {
				splCharacter++;
			}
			if(ascii>=48 && ascii<=57) {
				numeral++;
			}
			}
		if(lowerCase>0 && upperCase>0 && splCharacter>0 && numeral>0) {
			return true;
		}
		else {
		return false;
		}
      }
	}
	public static boolean Validateage(String d,int age) {
		String yr,mn,dy;
		int age1 = 0;
		yr=d.substring(6,10);
		mn=d.substring(0,2);
		dy=d.substring(3,5);
		int year1=Integer.parseInt(yr);
		int month1=Integer.parseInt(mn);
		int day1=Integer.parseInt(dy);
	    LocalDate currentdate = LocalDate.now();
	    int year=currentdate.getYear();
	    int month=currentdate.getMonthValue();
	    int day = currentdate.getDayOfMonth();
		if(year>year1) {
			if(month>month1) {
				age1=year-year1;
			}
			else if(month1>month){
				age1= year-year1-1;
			}
			else {
				if(day>day1) {
					age=year-year1;
				}
				else {
					age1= year-year1;				
				}
			}
		}
		if(age==age1) {
			return true;
		}
		else {
			return false;
		}
	}
}
