package ECB16S1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
@ author: Yizhou Yang 
*/
public class Person {
      private String name="";
      private Date birthday;
      private String phone="";
      private String email="";
      private String address="";
      private String strbir="";
      
     /*
      * constructor
      */
      public Person(String inname,String inbir,String inphone,String inemail,String inadd) throws ParseException{
            
    	  if(checkname(inname)==1 && checkdate(inbir)!=null){
    		  name=inname;
    	      birthday=checkdate(inbir);
    	      phone=checkphone(inphone);
    	      email=checkemail(inemail);
    	      address=inadd;
    	      strbir=inbir;
    	      System.out.println("Add the record successfully!");
    	      }
    	  else 
    		  System.out.println("invalid input record!");

      }
     
      /*
       * check the input e-mail formate
       */
      private String checkemail(String inemail){
    	  if(inemail.matches("(\\w+.)+\\w+@(\\w+.)+[a-z]{2,3}"))
    		  return inemail;
    	  else {
			inemail="";

			return inemail;
		} 
      }
      /*
       * check the input date formate
       */
      private Date checkdate(String inbir) throws ParseException{
    	   String[] time = inbir.split("-");
    	   int[] inttime=new int[30];
    	   for(int i =0;i<3;i++){
    		   inttime[i]=Integer.parseInt(time[i]);
    	   }  
    	  if(inbir.matches("^(0|1|2|3)?\\d-(0|1)?\\d-(\\d{2})?\\d{2}$")){
    		  if(inttime[2] % 4 == 0 && inttime[2] % 100 != 0 || inttime[2] % 400 == 0){
       		   if(inttime[1]==2&&inttime[0]>29)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==1&&inttime[0]>31)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==3&&inttime[0]>31)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==4&&inttime[0]>30)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==5&&inttime[0]>31)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==6&&inttime[0]>30)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==7&&inttime[0]>31)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==8&&inttime[0]>31)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==9&&inttime[0]>30)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==10&&inttime[0]>31)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==11&&inttime[0]>30)
       			   System.out.print("Wrong birthday input!  ");
       		   else if(inttime[1]==12&&inttime[0]>31)
       			   System.out.print("Wrong birthday input!  ");
       		   else {
         		  String pat = "dd-mm-yyyy";
        		  
        		  SimpleDateFormat form = new SimpleDateFormat(pat);
        		  
        		  Date tem = form.parse(inbir);
        		 // System.out.println(inbir);
        		  Date bir = tem;
        		  return bir;
       		   }
       	   }
    		  else{
          		   if(inttime[1]==2&&inttime[0]>28)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==1&&inttime[0]>31)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==3&&inttime[0]>31)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==4&&inttime[0]>30)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==5&&inttime[0]>31)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==6&&inttime[0]>30)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==7&&inttime[0]>31)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==8&&inttime[0]>31)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==9&&inttime[0]>30)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==10&&inttime[0]>31)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==11&&inttime[0]>30)
           			   System.out.print("Wrong birthday input!  ");
           		   else if(inttime[1]==12&&inttime[0]>31)
           			   System.out.print("Wrong birthday input!  ");
           		   else{
             		  String pat = "dd-mm-yyyy";
            		  
            		  SimpleDateFormat form = new SimpleDateFormat(pat);
            		  
            		  Date tem = form.parse(inbir);
            		 // System.out.println(inbir);
            		  Date bir = tem;
            		  return bir;
           		   }
    		  }

    	  }
    	  else 
    		  System.out.print("Wrong birthday input!  ");
    		  return null;
      }
      
      /*
       * check the input phone formate 
       */
      private String checkphone(String inphone){
    	  //if(inphone.equals(""))
    		  //System.out.print("Missing phone input!;  ");
    	  if(inphone.matches("^\\d+$"))
    		  return inphone;
    	  else{
    		  inphone="";
    		  System.out.print("Wong Phone input!  ");
    		  return inphone;
    	  }
    	 
      }
      /*
       * Check the input name formate
       */
      private int checkname(String inname){

    	  String mod="^([A-Za-z]+\\s?)*[A-Za-z]$";
    	  Pattern pat = Pattern.compile(mod);
    	  Matcher mat = pat.matcher(inname);
    	  if(mat.find())
    		  return 1;
    	  else
    		  System.out.print("Wrong name input! ");
    	      return 0;
      }

      
      
	public String getName() {
		return this.name;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getEmail() {
		return this.email;
	}

	public String getAddress() {
		return this.address;
	}

	public String getStrbir() {
		return this.strbir;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		if(email.matches("^(\\w+.)+\\w+@(\\w+.)+[a-z]{2,3}$")){
			this.email = email;
		}
		else
			System.out.println("invaild e-mail input!;  ");
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
