package intelligentUnderworld;

public class Dead {
	public String status;
		
	public double degOfCert;
	
	Dead(String status, double degOfCert){
		if(status.contentEquals("good")|| status.contentEquals("natural")|| status.contentEquals("bad")) {
			this.status=status;
		}else {
			throw new IllegalArgumentException("status cannnot be that, try good, natural or bad!");
		}
		
		if(0 <= degOfCert || 1>= degOfCert) {
			this.degOfCert=degOfCert;
		}else {
			throw new IllegalArgumentException("degOfCertmust be between 0 and 1!");
		}		
	}
	
}
