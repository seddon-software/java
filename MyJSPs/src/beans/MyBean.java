package beans;
////////////////////////////////////////////////////////////
//
//    NameBean.java
//
////////////////////////////////////////////////////////////




public class MyBean {
  String theName;
  int    theAge;

  public String getName() { return theName; }
  public int getAge()  { return theAge;  }

  public void setName(String newName) { theName = newName; }
  public void setAge(int newAge) { theAge = newAge;   }
}
