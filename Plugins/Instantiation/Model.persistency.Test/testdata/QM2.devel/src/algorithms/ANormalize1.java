package algorithms;

import eu.qualiMaster.families.inf.IFNormalize;

public class ANormalize1 implements IFNormalize{

	@Override
	public void calculate(IIFNormalizeInput input, IIFNormalizeOutput result) {
		String line = input.getSpringData();
		String ar[] = line.split(",");
		
		//timestamp as Date type will be parsed in setTimestamp method
		/* 
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss");
		Date timestamp;		
		
		try {
			timestamp = new Date(sdf.parse(dateStr).getTime());
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		*/		
		String id = ar[0];
		double value = Double.parseDouble(ar[1]);
		int volume = Integer.parseInt(ar[2]);
		String dateStr = ar[3];
		
		result.setStreamID(id);
		result.setQuote(value);
		result.setTimestamp(dateStr);
		result.setVolume(volume);
	}

}
