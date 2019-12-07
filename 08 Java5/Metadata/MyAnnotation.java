////////////////////////////////////////////////////////////
//
//	MyAnnotation.java
//
////////////////////////////////////////////////////////////

package Metadata;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.METHOD})
@interface MyAnnotation {
  String code();
  String status();
}

