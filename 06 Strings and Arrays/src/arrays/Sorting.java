////////////////////////////////////////////////////////////
//
//  Sorting an array of Java beans using a comparator
//
////////////////////////////////////////////////////////////

package arrays;

import java.util.Arrays;
import java.util.Comparator;


// example bean
class JavaBean {
  private int pk;
  private String field1;
  private String field2;
  
  public JavaBean(int pk, String field1, String field2) {
    this.pk = pk;
    this.field1 = field1;
    this.field2 = field2;
  }
  
  public String getField1() { return field1; }
  public String getField2() { return field2; }
  public void setField1(String field1) { this.field1 = field1; }
  public void setField2(String field2) { this.field2 = field2; }
  public int getPk() { return pk; }
  public void setPk(int pk) { this.pk = pk; }
}



// sort an array of beans (by increasing pk)
public class Sorting {
	public static void display(JavaBean[] beans) {
		for (JavaBean bean : beans) {
			System.out.print(bean.getPk() + ",");
			System.out.print(bean.getField1() + ",");
			System.out.println(bean.getField2());
		}
	}

	public static void main(String[] args) {

    JavaBean[] beans = { 
        new JavaBean(5, "A3", "B3"),
        new JavaBean(3, "A2", "B2"),
        new JavaBean(8, "A4", "B4"),
        new JavaBean(2, "A1", "B1"),
        };
    
    Comparator<JavaBean> comparator = new Comparator<JavaBean>() { 
      public int compare(JavaBean bean1, JavaBean bean2) {
          return bean1.getPk() - bean2.getPk();
      }  
    };
    
    Arrays.sort(beans, comparator);
    display(beans);
  }
}
