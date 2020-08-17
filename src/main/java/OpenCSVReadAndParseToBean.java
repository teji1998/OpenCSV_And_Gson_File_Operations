import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

	public class OpenCSVReadAndParseToBean {

		private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\PRITHVIL5\\Desktop\\tejigames\\fellowship\\openCSV\\src\\main\\resources\\users.csv";

		public static void main(String[] args) throws IOException {
			try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH))) {
				CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();

				List<CSVUser> csvUsers = csvToBean.parse();

				for (CSVUser iterator: csvUsers) {
					System.out.println("Name : " + iterator.getName());
					System.out.println("Email : " + iterator.getEmail());
					System.out.println("Phone : " + iterator.getPhoneNo());
					System.out.println("Country : " + iterator.getCountry());
					System.out.println(" --------------------------------- ");
				}
			}

		}
    }
