package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import enums.CSVPath;
import testData.GenerateTokenTestData;
import testData.ModelImageTestData;
import testData.ModelVariantTestData;
import testData.VehicleListTestData;
import testData.VehiclePaymentDetailsTestData;

public class DataHelper {

	private static Object getData(String pathname, Class<?> clazz) {
		List<Object> list = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(Paths.get(pathname), StandardCharsets.ISO_8859_1)) {
			CsvToBean<?> parser = new CsvToBeanBuilder<Object>(reader).withType(clazz).withIgnoreLeadingWhiteSpace(true)
					.build();
			Iterator<?> iterator = parser.iterator();
			while (iterator.hasNext())
				list.add(iterator.next());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int random = new Random().nextInt(list.size());
		return Collections.synchronizedList(list).get(random);
	}

	private static Iterator<Object[]> parseCsvData(String pathname) throws IOException {
		BufferedReader input = null;
		File file = new File(pathname);
		input = new BufferedReader(new FileReader(file));
		String line = null;
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		while ((line = input.readLine()) != null) {
			String in = line.trim();
			String[] temp = in.split(",");
			List<Object> array = new ArrayList<Object>();
			for (String s : temp)
				array.add(s);
			data.add(array.toArray());
		}
		input.close();
		return data.iterator();
	}

	public static GenerateTokenTestData getGenerateTokenData() {
		return (GenerateTokenTestData) DataHelper.getData(CSVPath.generateToken, GenerateTokenTestData.class);
	}

	public static VehicleListTestData getVehicleListData() {
		return (VehicleListTestData) DataHelper.getData(CSVPath.vehicleList, VehicleListTestData.class);
	}

	public static VehiclePaymentDetailsTestData getVehiclePaymentDetailsData() {
		return (VehiclePaymentDetailsTestData) DataHelper.getData(CSVPath.vehiclePaymentDetails,
				VehiclePaymentDetailsTestData.class);
	}

	public static ModelImageTestData getModelImageData() {
		return (ModelImageTestData) DataHelper.getData(CSVPath.modelImage, ModelImageTestData.class);
	}

	public static ModelVariantTestData getModelVariantData() {
		return (ModelVariantTestData) DataHelper.getData(CSVPath.modelVariant, ModelVariantTestData.class);
	}

}
