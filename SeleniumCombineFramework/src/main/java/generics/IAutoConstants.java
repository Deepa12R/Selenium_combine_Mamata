
package generics;

import java.time.LocalDateTime;

public interface IAutoConstants {
	String EXCELPATH="./src/test/resources/dataTest.xlsx";
	String JDBC_URL="jdbc:mysql://localhost:3306/advanceselenium";
	String JDBC_UN="root";
	String JDBC_PWD="root";
	String PROPERTYFILEPATH="./src/test/resources/commondata.properties";
	String SSPATH="./errorshots/";
	String TIME = LocalDateTime.now().toString().replace(":", "-");
	String DIRECTORY = System.getProperty("user.dir");
}
