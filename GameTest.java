import org.junit.*;
import java.lang.reflect.*;
/**
 * This class tests the Game classes
 * 
 * @author Mr. Aronson
 */
public class GameTest extends junit.framework.TestCase
{
    String className = "Game";
    private  boolean failed = false;
    private  Class<?> c;

    public static void main(String[] args)
    {
        GameTest c = new GameTest();
        c.test();
    }

    @Test
    public void test() {

        System.out.println("Testing your Game class \n");
        System.out.println("Now testing instance variables and constructor");
        try
        {

            c = Class.forName(className);
            Object[] cArgs = {};
            Constructor constructor = c.getConstructor(new Class[] {});
            Object t1 = constructor.newInstance(cArgs);
        }
        catch (NoClassDefFoundError e)
        {
            failure("Epic Failure: missing " + className + " class");
        }
        catch (ClassNotFoundException e)
        {
            failure("Epic Failure: missing " + className + " class");
        }
        catch (Exception e) {failure(e.toString());}

        boolean hasArrayList = false;
        boolean hasArray = false;
        boolean hasNumHits = false;

        if(!failed)
        {
            Field[] fields = c.getDeclaredFields();
            if(fields.length == 0)
                failure("Game has no instance variables");
            else
            {
                for(Field field : fields)
                {
                    //System.out.println(field);
                    String temp = field.toString();

                    if (temp.contains("int[]"))
                    {
                        hasArray = true;

                    } else  if (temp.contains("ArrayList")) {

                        hasArrayList = true;
                    } else  if (temp.contains("numHits"))
                    {
                        hasNumHits = true;
                    }
                }
            }

        }

        if(!failed && hasArray)
            failure("Game class should no longer have an array");
        if(!failed && !hasArrayList)
            failure("Game class needs an ArrayList");
        if(!failed && hasNumHits)
            failure("Game class should no longer use the numHits instance variable");

        if(!failed)
            System.out.println("Passed instance variables and constructor\n");
        if (!failed)
            System.out.println("Looks like you have successfully converted Game to using ArrayList");

    }

    private void failure(String str)
    {
        System.out.println("*** Failed: " + str);
        failed = true;
        fail(str);
    }

}
