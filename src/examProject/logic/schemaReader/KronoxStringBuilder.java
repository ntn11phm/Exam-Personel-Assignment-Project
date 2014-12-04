package examProject.logic.schemaReader;

public class KronoxStringBuilder {
	private String strUrl_p1 = "http://schema.hig.se/setup/jsp/SchemaICAL.ics?startDatum=idag&intervallTyp=";
	private String strUrl_p2 = "&intervallAntal=";
	private String strUrl_p3 = "&aktivitetstyp=Tentamen&sokMedAND=true&sprak=SV&resurser=";
	private String result = "";
	
	public KronoxStringBuilder(String type, String lenght) {
		result = strUrl_p1 + type + strUrl_p2 + lenght + strUrl_p3;
	}

	public String getKronoxURL() {
		return result;
	}

}
