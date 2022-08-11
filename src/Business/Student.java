
package Business;

import java.util.Arrays;

/**
 *
 * @author amadou
 */
public class Student {
    private String sid, Igrade, errmsg;
    private double[] scores;
    private double  cavg, qavg;
    
    
    
public Student(String Studentid, double[] Scoreset)  {
    this.sid = Studentid;
    this.scores = Scoreset;
    this.cavg = -1;
    this.qavg = -1;
    this.Igrade = "?";
   
    if (isValid()) {
        CalcStudent();
        
    }
}

private boolean isValid() {
    this.errmsg = "";
    if(sid.isEmpty()) {
       this.errmsg += "Please enter a value for student ID.";
                  
    } else if (!sid.substring(0,1).equalsIgnoreCase("A")) {
        this.errmsg += "Student ID must start with 'A' ";
    } else if (sid.length() != 9) {
       this.errmsg += "illegal student #: must be 9 characters";
                 } else {
            try {
                     long id = Long.parseLong(sid.substring(1));
                     if (id > 0) {
                        
                     
        this.errmsg += "Digits after 'A' must be > 0";
                     }      
                 } catch (NumberFormatException e) {
        this.errmsg += "Digits after 'A' are not Numeric Bro";
                     
                 }
                 }
    
    
     for (int i=0; i<9; i++) {
     if (this.scores[i] < 0 || this.scores[i] > 100) {
         this.errmsg += " Scores Number" + i + "out of Range.";
     }
     }
     return this.errmsg.isEmpty();
    
     }
                         
  private void CalcStudent() {
      double[] q = { scores[0], scores[1], scores[2], scores[3],
                    scores[4], scores[5] };
                     
   Arrays.sort(q);  
   this.qavg = ( q[2] + q[3] + q[4] + q[5]) / 4.0;
   
   if(qavg >= 89.5 && scores[6] >= 89.5 && scores[7] >= 89.5) {
       this.cavg = (scores[6] + scores[7] + qavg) / 3.0;
       this.Igrade = "A";
      
     } else if (cavg >= 79.5) {
                      Igrade = "B";
                  } else if (cavg >= 69.5) {
                      Igrade = "C";
                      
                  } else if (cavg >= 59.5) {
                      Igrade = "D";
                  } else {
                       Igrade = "F";
                      
                  }
   
       
   
    
     
 
             
    
   

 
}//end of calcstudent
  
  public String getErrorMsg() {
      return this.errmsg;
  }
  
  public double getQuizAvg() {
      return this.qavg;
  }
   public double getCourseAvg() {
       return this.cavg;
   }
   
   public String getGrade() {
      return this.Igrade;
   }
} 