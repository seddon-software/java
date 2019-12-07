package reflection;



import java.lang.reflect.*;


public class QueryMethods {
    public static void main(String[] args) {

        MyClass object = new MyClass(true);
        QueryForClassName(object);
        QueryForConstructors(object);
        QueryForMethods(object);
        InvokeMethods(object);
    }

    static void QueryForClassName(Object o) {
        Class<?> c = o.getClass();
        System.out.println("Classname: " + c.getName());
        System.out.println("============================");
    }

    static void QueryForConstructors(Object o) {
        Class<?> c = o.getClass();
        Constructor<?>[] constructors = c.getConstructors();

        for(int i = 0; i < constructors.length; i++) {
            Class<?>[] params = constructors[i].getParameterTypes();
            System.out.println("Constructor: " + c.getName());

            for(int j = 0; j < params.length; j++) {
                System.out.println("Parameter: " + params[j].getName());
            }
            System.out.println("============================");
        }
    }

    static void QueryForMethods(Object o) {
        Class<?> c = o.getClass();
        Method[] methods = c.getMethods();

        for(int j = 0; j < methods.length; j++) {
            Method method = methods[j];
            System.out.print("Methods: " + method.getName());
            Class<?>[] parameters = method.getParameterTypes();
            for(int k = 0; k < parameters.length; k++) {
                Class<?> parameter = parameters[k];
                System.out.print(": " + parameter.getName());
            }
            System.out.println("");      
        }
        System.out.println("============================");
    }

    static void InvokeMethods(Object o) {
        Class<?> c = o.getClass();
        Method[] methods = c.getMethods();

        for(int j = 0; j < methods.length; j++) {
            try {
                // pick methods in MyClass
                if(methods[j].getDeclaringClass().equals(MyClass.class)) {
                    methods[j].invoke(o, (Object[])null);
                }
            } catch(InvocationTargetException e) {
                System.err.println(e);
            } catch(IllegalAccessException e) {
                System.err.println(e);
            }
        }
        System.out.println("============================");
    }
}


/////////////////////////////////////////////////////////////


class MyClass {
    public MyClass(boolean b) {}
    public MyClass(int i, double d, String s) {}
    public void f1() { System.out.println("f1"); }
    public void f2() { System.out.println("f2"); }
    public void f3() { System.out.println("f3"); }
    public void f4() { System.out.println("f4"); }
}



