package ECB16S1;

//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.text.ParseException;



/*
@ author: Yizhou Yang 
*/
public class ECB {

	public static void main(String[] args) throws IOException, ParseException {
      String location = "E:/Programming/JAVA/Test1/src/ECB16S1/test/contacts_1.txt";
      Record recordlist = new Record();
      recordlist.read(location);
      
      System.out.println("");
       String input="";
       String cmdloc = "E:/Programming/JAVA/Test1/src/ECB16S1/test/instructions_1.txt";
       Record cmdrd = new Record();
       cmdrd.readcomd(cmdloc);
       
      
       for(int i=0;i<cmdrd.getComd().size();i++){
    	   if(cmdrd.getComd().get(i).getCommand().equals("add")){
    		   recordlist.add(cmdrd.getComd().get(i).getName(),cmdrd.getComd().get(i).getBirthday(), cmdrd.getComd().get(i).getPhone(), cmdrd.getComd().get(i).getEmail(), cmdrd.getComd().get(i).getAddress());
    	   }
    	   else if(cmdrd.getComd().get(i).getCommand().equals("delete")){
    		   //System.out.println(cmdrd.getComd().get(i).getName());
    		   if(cmdrd.getComd().get(i).getBirthday()!="")
    		        recordlist.delete(cmdrd.getComd().get(i).getName(),cmdrd.getComd().get(i).getBirthday());
    		   else 
    			   recordlist.delete(cmdrd.getComd().get(i).getName());
    	   }
    	   else if(cmdrd.getComd().get(i).getCommand().equals("query")){
    		     if(cmdrd.getComd().get(i).getName()!=""){
    		    	 input = "name "+cmdrd.getComd().get(i).getName();
    		    	 recordlist.query(input);
    		     }
    		     else if(cmdrd.getComd().get(i).getStrbir()!=""){
    		    	 input = "birthday "+cmdrd.getComd().get(i).getStrbir();
    		    	 recordlist.query(input);
    		     }
    		     else if(cmdrd.getComd().get(i).getPhone()!=""){
    		    	 input = "phone "+cmdrd.getComd().get(i).getPhone();
    		    	 recordlist.query(input);
    		     }
    		     
    	   }
    	   else if(cmdrd.getComd().get(i).getCommand().equals("save")){
    		   recordlist.save();
    	   }
       }

    
	}
	

}
