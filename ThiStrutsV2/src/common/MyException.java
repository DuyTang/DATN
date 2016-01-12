package common;

public class MyException extends Exception {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private String description;

   public MyException(String description) {
      this.description = description;
   }
   
   public String getMessage() {
      return description;
  }
}
