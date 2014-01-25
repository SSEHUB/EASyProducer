package operationList;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * Get all known IDatatype specific Operations.
 * @author tebbje
 */
public class operationList {
	
	/**
	 * Just for using System.out after it has been redirected.
	 */
	@SuppressWarnings("unused")
	private static PrintStream console;
	
	/**
	 * You can choose between 
	 * 0|0 for plain text in the console
	 * 1|0 for plain text in file
	 * 0|1 for html table in console
	 * 1|1 for html table in file
	 */
	private static int printFile = 1;
	private static int asHtml = 1;

	/**
	 * Name of the Output File.
 	 * e.g.	*.html for HTML output
	 * e.g. *.txt for plain text output 
	 */
	private static String file = "operation_list.html";
	
	/**
	 * Main for invoking the Method
	 * @param args
	 */
	public static void main(String[] args) {
	
		showOperationList();
		
	}
		
	/**
	 * This Method prints the in types[] given IDatatypes with their related Operations.
	 */
	public static void showOperationList() {
	
		/**
		 * Known IDatatypes.
		 */
		IDatatype types[] = { 
				IntegerType.TYPE, 
				RealType.TYPE,
				BooleanType.TYPE, 
				StringType.TYPE,
				Compound.TYPE,
				Sequence.TYPE,
				Container.TYPE,
				Enum.TYPE,
				OrderedEnum.TYPE,
				Set.TYPE, 
				ConstraintType.TYPE,
				MetaType.TYPE
				};
		
		if (printFile == 1) {
			System.out.println("printFile = 1 -> OutputStream redirected to \"" + file + "\"");
	        try {
				PrintStream ps = new PrintStream(
						new BufferedOutputStream(
								new FileOutputStream(
										new File(file)
									)
							), true
						);
				console = System.out;
				System.setOut(ps);         
				System.setErr(ps);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		if (asHtml == 1) System.out.println("<html><body><table border=\"0\">");
		for (IDatatype thisType : types) {
			if (asHtml == 1) System.out.print("<tr><td colspan=\"6\"><b>");
			System.out.print(getTypeName(thisType)	+ " Operations " 
					+ "(" + thisType.getOperationCount() + ") " + ":");
			if (asHtml == 0) System.out.println();
			if (asHtml == 1) System.out.println("</b></td></tr>");
			if (asHtml == 1) System.out.println(
				  "<tr align=\"center\">"
				+ "<td><u>Itemise</u></td>"
				+ "<td><u>Operand</u></td>"
				+ "<td><u>Operator</u></td>"
				+ "<td><u>Parameter</u></td>"
				+ "<td><u>Equal</u></td>"
				+ "<td><u>Result</u></td>"
				+ "</tr>"
				);
			for (int i = 0; i < thisType.getOperationCount(); i++) {
				if (asHtml == 1) System.out.print("<tr align=\"center\">");
				if (asHtml == 1) System.out.print("<td>&nbsp;&nbsp;");
				System.out.print(1 + i + ") ");
				if (asHtml == 1) System.out.print("&nbsp;&nbsp;</td>");
				if (asHtml == 1) System.out.print("<td>");
				System.out.print(" " + getTypeName(thisType.getOperation(i).getOperand()) + " ");
				if (asHtml == 1) System.out.print("</td><td>");
				System.out.print(" " + thisType.getOperation(i).getName() + " ");
				if (asHtml == 1) System.out.print("</td><td>");
				for (int a = 0; a < thisType.getOperation(i).getParameterCount(); a++) {
					if (a != 0)	System.out.print(", ");
					System.out.print(" " + getTypeName(thisType.getOperation(i).getParameter(a)) + " ");
				}
				if (asHtml == 1) System.out.print("</td><td>");
				System.out.print(" = ");
				if (asHtml == 1) System.out.print("</td><td>");
				if (thisType.getOperation(i).getReturnTypeMode().getGenericTypeIndex() == 0) {
					System.out.print("&lt;T&gt;");
				} else {
					System.out.print(getTypeName(thisType.getOperation(i).getReturns()));
				}
				if (asHtml == 1) System.out.println("</td></tr>");
				if (asHtml == 0) System.out.println();
			}
		}
		if (asHtml == 1) System.out.println("</table></body></html>");
	}
	
	/**
	 * Removes angle brackets from datatype names.
	 * @param type the type, which name should be returned.
	 * @return The name of the datytype without angle brackets.
	 */
	private static String getTypeName(IDatatype type) {
		String name = type.getName();
		name = name.replaceAll(">", "");
		name = name.replaceAll("<", "");
		
		return name;
	}
}
