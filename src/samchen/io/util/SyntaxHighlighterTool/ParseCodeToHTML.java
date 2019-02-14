package samchen.io.util.SyntaxHighlighterTool;

public class ParseCodeToHTML {
	private String parseCodeStr = "";
	private String rtnHTMLStr = "";
	private String codeLanguage = "";

	public String getRtnSqlStr() {
		return rtnHTMLStr;
	}
	public void setCodeLanguage(String codeLanguage) {
		this.codeLanguage = codeLanguage;
	}

	public void setParseSqlStr(String parseCodeStr) {
		this.parseCodeStr = parseCodeStr;
	}
	
	public String parse() {
		String tmpStr = this.parseCodeStr;
		
		StringBuilder sb = new StringBuilder();
		sb.append("<pre class=\"brush: " + codeLanguage + ";\">\n");
		for (char c : tmpStr.toCharArray()) {
			switch (c) {
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '\t':
				sb.append("    ");
				break;
			case '&':
				sb.append("&amp;");
				break;
			default:
				sb.append(c);
				break;
			}
		} //end for loop
		sb.append("</pre> <br />");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String helloworld = "public class HelloWorld {\r\n" + 
				"    public static void main(String[] args) {\r\n" + 
				"        System.out.println(\"Hello! World!\");\r\n" + 
				"    }\r\n" + 
				"}";
		String t2 = "<link href='https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/styles/shCoreDefault.min.css' rel='stylesheet' type='text/css'/>\r\n" + 
				"<script src='https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shCore.min.js' type='text/javascript'/>\r\n" + 
				"<script src='https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shAutoloader.min.js' type='text/javascript'/>\r\n"; 
		
		ParseCodeToHTML pct = new ParseCodeToHTML();
		pct.setCodeLanguage("Xml");
		pct.setParseSqlStr(t2);
		System.out.println(pct.parse());
	}
}
