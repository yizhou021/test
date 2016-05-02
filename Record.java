package ECB16S1;
/*
@ author: Yizhou Yang 
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;


public class Record {
        private ArrayList<Person> personlist = new ArrayList<Person>();
        private ArrayList<Person> query = new ArrayList<Person>();
        private ArrayList<ArrayList<Person>> count = new ArrayList<ArrayList<Person>>();
        private ArrayList<Command> comd = new ArrayList<Command>();
        
        /**
        public Record( ArrayList<Command> command){
        	comd=command;
        }
        */
        
        public Record(){
        	
        }



		public void read(String location) throws IOException, ParseException{
        	 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(location)));
       		String tem = null;
       		String name="",stbirthday="",phone="",email="",address="",subaddress="";
       		
       		//
       		/*
       		 * read method to read the record line by line and add to the arraylist
       		 */
       		while((tem=br.readLine())!=null){
       			String[] temp = tem.split(" ");
       			if(temp[0].equals("name")){
       				for(int i=1;i<temp.length;i++){
       					name=name+temp[i]+" ";
       			    }
       				name=name.trim();
       			}
       			else if(temp[0].equals("birthday")){
       				stbirthday=temp[1];
       				}
       			else if(temp[0].equals("phone")){
       				phone=temp[1];
       			}
       			else if(temp[0].equals("email")){
       				email=temp[1];
       			}
       			else if(temp[0].equals("address")){
       				for(int i=1;i<temp.length;i++){
       					address=address+temp[i]+" ";
       				}
       			}
       			else if(temp[0].equals("")){
                       add(name, stbirthday, phone, email, address);
       				name="";
       				stbirthday="";
       				phone="";
       				email="";
       				address="";
       				subaddress="";
       			}
       			else{
       			    for(int i=0;i<temp.length;i++){
       			    	subaddress=subaddress+temp[i].trim()+" ";
       			    }
       			}
       		}
       		/*
       		 * add the last record
       		 */
       		 add(name, stbirthday, phone, email, address);
       			name="";
       			stbirthday="";
       			phone="";
       			email="";
       			address="";
       			subaddress="";
       			br.close();
        }
        /*
         * add method to add new record into the arraylist
         */
        public void add(String inname,String inbir,String inphone,String inemail,String inadd) throws ParseException{
        	Boolean result = true;
        	if(inname.equals("")||inbir.equals("")){
        		System.out.print("Missing Name or Birthday!  ");
        		System.out.println("invalid input record!");
        	}
        	else{
        		
        		for(int i=0;i<personlist.size();i++){
                   		
               			if(personlist.get(i).getName().equals(inname)&&personlist.get(i).getStrbir().equals(inbir)){
               				if(inadd!=""){
               					personlist.get(i).setAddress(inadd);
               				}
               				if(inemail!=""){
               					personlist.get(i).setEmail(inemail);
               				}
               				if(inphone!=""){
               					personlist.get(i).setPhone(inphone);
               				}
               				
               				result=false;
               				System.out.println("Update the record!    ");
               			}
               		}
        		
           		
        		if(result){
           			Person in = new Person(inname, inbir, inphone, inemail, inadd);
                	personlist.add(in);
           		}
            	
            	//System.out.println("Add the record seccessfully!");
        	}
 
        }
        /**
         * Delete method that remove the record and input name and birthday as conditions
         * @param inname
         * @param inbirthday
         */
        public void delete(String inname, String inbirthday){
      	     for(int i=0;i<personlist.size();i++){
      	    	   if(personlist.get(i).getName().equals(inname)&&personlist.get(i).getStrbir().equals(inbirthday)){
      	    	        	personlist.remove(i);
      	    	        	System.out.println("Remove the record: Name: "+inname+" And Born on "+inbirthday);
      	    	        }
      	    	 }
      	     System.out.println("The current size of list: "+personlist.size());
      	     }
        /**
         * Delete method that remove the record according to the name
         * @param inname
         */
        public void delete(String inname){
        	for(int i=0;i<personlist.size();i++){
   	    	   if(personlist.get(i).getName().equals(inname)){
   	    	        	personlist.remove(i);
   	    	        	System.out.println("Remove the record: name: "+inname);
   	    	        }
   	    	 }
   	     System.out.println("The current size of list: "+personlist.size());
        }
        
		/**
		 * query method use the string to find the record in arrylist by matching the name,birthday or phone.
		 * @param query
		 */
		public void query(String requery){
      	    String[] temp = requery.split(" ");
      	  //ArrayList<Person> query = new ArrayList<Person>();
      	    String name="",stbirthday="",phone="";
      	   
      	    if(temp[0].equals("name")){
      	    	
      	    	for(int i=1;i<temp.length;i++){
      	    		name=name+temp[i]+" ";
      	    	}
      	    	name=name.trim();
      	    	
      	    	for(Person t:personlist){
      	    		if(t.getName().equals(name)){
      	    			this.query.add(t);
      	    		}
      	    	}
      	    }
      	    else if(temp[0].equals("birthday")){
      	    	stbirthday=temp[1];
      	    	for(Person t:personlist){
      	    		if(t.getStrbir().equals(stbirthday))
      	    			this.query.add(t);
      	    	}
      	    }
      	    else if(temp[0].equals("phone")){
      	    	phone=temp[1];
      	    	for(Person t:personlist){
      	    		if(t.getPhone().equals(phone))
      	    			this.query.add(t);
      	    	}
      	    }
      	    System.out.println("Finished request!");
      	    if(!query.isEmpty()){
      	    	query=sort(query);
          	    
      	    }
      	    count.add(query);
      	    this.query = new ArrayList<Person>();
      	    //System.out.println(count.size());
      	    //query.clear();
      	    
        }
        

		public void save() throws IOException{
      	  String saveloc ="E:/Programming/JAVA/Test1/src/ECB16S1/test/result.txt";
      	  Writer wr=new FileWriter(saveloc,false);
      	
      	  for(int i=0;i<personlist.size();i++){
      		  if(personlist.get(i).getName()!=""){
      			wr.write("Name      "+personlist.get(i).getName()+"\r\n");
    		      wr.write("Birthday  "+personlist.get(i).getStrbir()+"\r\n");
    		      if(personlist.get(i).getPhone()!="")
    		           wr.write("Phone     "+personlist.get(i).getPhone()+"\r\n");
    		    if(personlist.get(i).getEmail()!="")
 		    	       wr.write("E-mail    "+personlist.get(i).getEmail()+"\r\n");
    		      if(personlist.get(i).getAddress()!="")
    		    	   wr.write("Address   "+personlist.get(i).getAddress()+"\r\n");
    		    wr.write("  \r\n");
      		  } 
      	  }
      	wr.close();
        	String saveque ="E:/Programming/JAVA/Test1/src/ECB16S1/test/result_query.txt";
  	        Writer wrq=new FileWriter(saveque,false);
  	      
  	        if(count.isEmpty()){
  	        	 wrq.write("Ther are No Query Command!!!\r\n");
  	        }
  	        else{
      		
        	  for(int i=0;i<count.size();i++){
        		  //System.out.println(count.size());
        		  wrq.write("Result "+(i+1)+"\r\n");
        		 
        		  wrq.write("\r\n");
        		  if(count.get(i).isEmpty()){
        			  wrq.write("Ther are No More Query Command!!!\r\n");
        		  }
        		  else{
        			  for(int j=0;j<count.get(i).size();j++){
            			  wrq.write("Name      "+count.get(i).get(j).getName()+"\r\n");
              		      wrq.write("Birthday  "+count.get(i).get(j).getStrbir()+"\r\n");
              		      if(count.get(i).get(j).getPhone()!="")
              		           wrq.write("Phone     "+count.get(i).get(j).getPhone()+"\r\n");
              		    if(count.get(i).get(j).getEmail()!="")
           		    	       wrq.write("E-mail     "+count.get(i).get(j).getEmail()+"\r\n");
              		      if(count.get(i).get(j).getAddress()!="")
              		    	   wrq.write("Address   "+count.get(i).get(j).getAddress()+"\r\n");
              		    wrq.write("\r\n");
            		  }
        		  }
        		  
        		  wrq.write("----------------------------------------------------\r\n");
        	  }
        	  wrq.close();
      	  }
      	  
      	 wrq.close();
       	
      	  System.out.println("Save successfully!");
      	  
        }
		/**
		 * sort method that input the arraylist which needed to be sorted, and sort by ascending order of person name and birthday
		 * @param input
		 * @return ArrayList input
		 */
        
        public ArrayList<Person> sort(ArrayList<Person> input){
        	Person tem = input.get(0);
        	for(int i =0;i<input.size()-1;i++){
        		for(int j=i+1;j<input.size();j++){
        			if(input.get(i).getName().compareTo(input.get(j).getName())>0){
        				tem=input.get(j);
        				input.set(j, input.get(i));
        				input.set(i, tem);
        			}
        			else if(input.get(i).getName().compareTo(input.get(j).getName())==0){
        				if(input.get(i).getBirthday().getTime()>input.get(j).getBirthday().getTime()){
        					tem=input.get(j);
            				input.set(j, input.get(i));
            				input.set(i, tem);
        				}
        			}
        		}
        	}
			return input;
        	
        }
        
        
        public void readcomd(String cmdloc) throws IOException{
        	
 		   BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(cmdloc)));
 		   String tem = null;
 		   String name="",stbirthday="",phone="",email="",address="",command="";
 		   String temstring ="";
 		   
 		   while((tem=br.readLine())!=null){
 			   String[] temp = tem.split(" ");
 			   command=temp[0];
 			   
 			   Command t = new Command();
 			   t.setCommand(command);
 			   
 			   
 			   comd.add(t);
 			   for(int i=1;i<temp.length;i++){
 				  temstring=temstring+temp[i]+" ";
 			   }
 			   temstring=temstring.replaceAll("; ", "\n");
 			   temp=temstring.split("\n");
 			 //System.out.print(temp.length+": ");
 			   for(int i=0;i<temp.length;i++){
 				   String[] t2=temp[i].split(" ");
 				 // System.out.print(t2.length+": ");
 				 //  for(int z=0;z<t2.length;z++){
 					  if(t2[0].equals("name")){
 	        				for(int j=1;j<t2.length;j++){
 	        					//System.out.println(t2[j]+"||");
 	        					name=name+t2[j]+" ";
 	        			    }
 	        				name=name.trim();
 	        			}
 					 else if(t2[0].equals("birthday")){
 	       				stbirthday=t2[1];
 	       				}
 	       			else if(t2[0].equals("phone")){
 	       				phone=t2[1];
 	       			}
 	       			else if(t2[0].equals("email")){
 	       				email=t2[1];
 	       			}
 	       		    else if(t2[0].equals("address")){
       				for(int q=1;q<temp.length;q++){
       					address=address+t2[q]+" ";
       				}
       			       }
 	       		  else if(t.getCommand().equals("delete")&&i==0){
 	       			   for(int j=0;j<t2.length;j++){
     					//System.out.println(t2[j]+"||");
     					name=name+t2[j]+" ";
     			      }
     				  name=name.trim();
	       		    }
 	       		  else if(t.getCommand().equals("delete")&&i==1){
 	       			     stbirthday=t2[0];
 	       			     
 	       		  }
 	       		
 				   }
 				   //System.out.println(temp[i]);
 				
 			  // }
 			   t.setName(name);
 			   t.setBirthday(stbirthday);
 			   t.setAddress(address);
 			   t.setEmail(email);
 			   t.setPhone(phone);
 			   t.setStrbir(stbirthday);
 			   
 			   
               //System.out.println("");
 			   temstring="";
 			  name="";
 			  stbirthday="";
 			  phone="";
 			  email="";
 			  address="";
 			  command="";
 			   
 			   //tem=tem.replaceAll("; ", "\n");
 		   }
 		   
 	   }
 	   
        
        public ArrayList<Command> getComd() {
			return this.comd;
		}

		public ArrayList<Person> getPersonlist() {
			return this.personlist;
		}
        
        public ArrayList<Person> getQuery() {
			return this.query;
		}
        
        public ArrayList<ArrayList<Person>> getCount() {
			return this.count;
		}
        

}
