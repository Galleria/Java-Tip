import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;


public class Functional {

	public static void main(String[] args) throws ScriptException {
		// TODO Auto-generated method stub
		System.out.println("="+ multiply(2) ); 
		System.out.println("="+ multiply(3) );
		System.out.println("="+ multiply(4) );
		Algebra();
	}

	public static int multiply(int x){
		if( x == 1 ){
			System.out.print("1");
			return 1;
		}else{
			System.out.print(x+"*");
			return x*multiply(x-1);
		}
	}
	
	public static void Algebra() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("x", 2);
        vars.put("y", 1);
        vars.put("z", 3);
        System.out.println("result = "+engine.eval("x + y + z", new SimpleBindings(vars)));
    }
}

