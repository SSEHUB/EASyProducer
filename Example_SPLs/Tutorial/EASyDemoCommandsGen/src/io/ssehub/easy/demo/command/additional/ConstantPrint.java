package io.ssehub.easy.demo.command.additional;

import java.util.Map;

/**
 * Just a constant print to be integrated by generation.
 * 
 * @author SSE@SUH
 */
public class ConstantPrint {

	/**
	 * Executes the operation.
	 * 
	 * @param args the operation arguments
	 * @param data the shared data
	 * @return <b>null</b> in case of success, tan error message else
	 */
	public static String execute(String[] args, Map<String, Object> data) {
		System.out.println("Just printing... ignoring all arguments");
		return null;
	}
	
}
