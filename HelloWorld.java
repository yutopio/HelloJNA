import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Native;

interface HelloLib extends Library {
    HelloLib INSTANCE =
	(HelloLib) Native.loadLibrary("mynative", HelloLib.class);

    void println(String msg);
    int getInt();
    Pointer toString(int bit);
    void deleteArray(Pointer pt);
}

public class HelloWorld {
    public static void main(String[] args){
	HelloLib obj = HelloLib.INSTANCE;
 	obj.println("Hello JNA world");
 	obj.println("");

	obj.println("Calling getInt");
	int value = obj.getInt();
	obj.println("");

	obj.println("Calling toString");
	Pointer pt = obj.toString(value);
	String ret = pt.getString(0);
	obj.deleteArray(pt);
	obj.println(ret);
    }
}
