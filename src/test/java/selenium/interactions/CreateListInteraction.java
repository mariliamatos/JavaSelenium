package selenium.interactions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import selenium.pageobjects.CreateListPage;

public class CreateListInteraction extends CreateListPage {

	private final Logger log = Logger.getLogger(CreateListInteraction.class);
	public static String nameList = "";// nome da lista
	public int typeDownloadList; // tipo do download

	public CreateListInteraction(final WebDriver driver) {
		super(driver);
	}

	public void firstFilter(String listName) throws Exception {
		try {
			// Primeiro filtro
//			String windows = driver.getWindowHandle();
//			driver.switchTo().window(windows);
			log.info("List " + listName + " is being created"); //
			log.info("Starting choosing filters"); //
			Thread.sleep(4000);
		} catch (Exception e) {
			log.error("It was not possible to check the first filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void verifyListCreation(String listName) throws Exception {
		// Verifica se a lista consta no histórico
		// Metódo da refresh na página até o status da lista estiver igual a "Baixar
		// Lista"
		try {
			Thread.sleep(5000);
			log.info("Entering in history page");
			if (firstListName.getText().equals(nameList)) {
				while (firstListStatus.getText().equals("Aguardando")) { // lista no status aguardando
					log.info("List " + firstListName.getText() + " is not ready yet");
					log.info("List " + firstListName.getText());
					driver.navigate().refresh();
					Thread.sleep(10000);
				}
				if (firstListStatus.getText().equals("Baixar Lista")) { // verifica se a lista está pronta
					Thread.sleep(15000);
					log.info("List " + firstListName.getText() + " was created");
					log.info("List Id : " + firstListId.getText());
					log.info("List " + firstListName.getText() + " is ready to be downloaded");
					driver.navigate().refresh();
				} else {
					log.error("List " + firstListName.getText() + " was created with an error");
					log.error("List Id : " + firstListId.getText());
					throw new Exception("List " + firstListName.getText() + " was created with an error");
				}
			} else {
				log.error("List " + nameList + " was not created");
				throw new Exception("List " + nameList + " was not created");
			}
		} catch (Exception e) {
			log.error("It was not possible to check the name of the list created= " + listName);
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void downloadList(int typeDownload) throws Exception {
		// Metódo para o download de lista
		try {
			waitToElementAndClick(firstListStatus);// click para fazer download da primeira lista
			log.info("File will be downloaded");
			typeDownloadList = typeDownload;
			if (typeDownload == 1) { // Enviando 1 - Escolha Excel
				waitToElementAndClick(btXlsx); // botão x0lsx
				log.info("Excel was choosen");
			}
			if (typeDownload == 2) {// Enviando 2 - Escolha Txt
				waitToElementAndClick(btTxt);// botão txt
				log.info("Txt was choosen");
			}
			if (typeDownload == 3) {// Enviando 3 - Escolha Csv
				waitToElementAndClick(btCsv);// botão csv
				log.info("Csv was choosen");
			}
			log.info("File was downloaded");
			Thread.sleep(15000);
		} catch (Exception e) {
			log.error("It was not possible to download the file");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void copyFile() throws IOException, InterruptedException {
		// copiando arquivo para dentro da pasta /lista aplicação
		Thread.sleep(5000);
		log.info("Starting copying File");
		String separator = File.separator;// Separador de arquivo do Sistema Operacional
		String pathTo = "target" + separator + "Lista" + separator;
		String pathFrom = new File(
				"src" + separator + "test" + separator + "resources" + separator + "downloads" + separator)
						.getAbsolutePath();

		File destPathCopy = new File(pathTo);

		if (!destPathCopy.exists())
			destPathCopy.mkdir();

		// String pathFrom = "C:\\Users\\gsw.mariliam\\Downloads\\"; // pasta do
		// download do arquivo
		//

		pathFrom = pathFrom + separator;
		System.out.println("separator " + separator);
		System.out.println("caminho - " + pathFrom);

		pathFrom = pathFrom + separator;
		File source = new File(pathFrom + firstListName.getText() + firstListId.getText() + ".zip");// pasta da qual o
																									// copiado
		File destination = new File(pathTo + firstListName.getText() + firstListId.getText() + ".zip"); // pasta que o
																										// arquivo será
																										// copiado
		FileChannel sourceChannel = null;
		FileChannel destinationChannel = null;
		try {
			sourceChannel = new FileInputStream(source).getChannel();
			destinationChannel = new FileOutputStream(destination).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
			source.delete();
			log.info("File was copied");
		} catch (Exception e) {
			log.error("It was impossible to copy the file");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		} finally {
			if (sourceChannel != null && sourceChannel.isOpen()) {
				sourceChannel.close();
			}
			if (destinationChannel != null && destinationChannel.isOpen())
				destinationChannel.close();
		}
	}

	public void UnzipFile() throws Exception {
		// Descompactando o arquivo arquivo
		log.info("Starting decompress the file");
		String separator = File.separator;// Separador de arquivo do Sistema Operacional
		String path = "target" + separator + "Lista" + separator;
		String destDir = path;// diretório destino
		File dir = new File(destDir);
		// create output directory if it doesn't exist
		if (!dir.exists())
			dir.mkdirs();
		FileInputStream fis;
		// buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(path + firstListName.getText() + firstListId.getText() + ".zip");
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			if (ze == null) { // verifica se tem arquivo pra ser descompactado
				throw new Exception("It was impossible to decompress the file");
			}
			while (ze != null) {// lendo os arquivos dentro do zip
				String fileName = ze.getName();// pegando o nome do arquivo dentro do zip
				File newFile = new File(destDir + File.separator + fileName);
				log.info("Unzipping to " + newFile.getAbsolutePath());
				// create directories for sub directories in zip
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) { // lendo e descompactando o arquivo
					fos.write(buffer, 0, len);
				}
				fos.close();
				// close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			// close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
			log.info("File was decompressed");
			new File(path + firstListName.getText() + firstListId.getText() + ".zip").deleteOnExit();
		} catch (IOException e) {
			log.error("It was impossible to decompress the file");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickMenuCreateList() throws InterruptedException {
		try {
			// click no menu de criação da lista
			Thread.sleep(2000);
			waitToElementAndClick(btmenucreateList);
		} catch (Exception e) {
			log.error("It was possible to go to create list menu");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickCreateListButton() throws InterruptedException {
		try {
			Thread.sleep(2000);
			waitToElementAndClick(btcreateList); // click no botão de criação d lista
		} catch (Exception e) {
			log.error("It was possible to click to create list button");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void readCsv(Map<String, Integer> mapAttributes, int listType) throws Exception {
		// Método para ler o arquivo CSV
		log.info("Reading csv file");

		List<String> fileList = new ArrayList<>();
		String ln = "";

		String separator = File.separator; // separador de arquivos do Sistema operacional

		String path = "target" + separator + "Lista" + separator + firstListName.getText() + firstListId.getText()
				+ ".csv";

		try (FileReader file = new FileReader(path); BufferedReader readFile = new BufferedReader(file)) {

			String linha = null;
			int idx = 0;
			while ((linha = readFile.readLine()) != null) { // lendo as linhas do arquivo
				idx++;
				String[] array = linha.split("\"");
				if (array.length >= 2) {
					String re = array[1].replaceAll(";", "***");// tratamento do separador do csv (;)
					linha = array[0].replace("\"", "");
					linha = linha + re + array[2];
				}
				linha = linha.replace(";", "|");
				linha = linha.replace("***", ";");
				if (idx == 1) {
					ln = linha;// primeira linha - headers
					continue;
				}
				fileList.add(linha);
			}
			if (fileList.size() == 0) {
				log.error("File is Empty");
				// throw new Exception("File is Empty");
			}

			StringTokenizer st = new StringTokenizer(ln);
			int contador = 0;
			st.nextToken("|");
			contador = st.countTokens(); // verificando quantas colunas a primeira linha tem
			String[] header = ln.split("\\|");// lista dos headers

			for (int i = 0; i < fileList.size(); i++) {// substituindo espaços em branco do arquivo - FileList é a lista
														// que recebe cada linha do arquivo
				String temp = fileList.get(i);
				temp = temp + "|";// adicionando o caracter | no final de cada linha
				temp = temp.replace("||", "|abcd|");
				temp = temp.replace("||", "|abcd|");
				temp = temp.replace("||", "|");
				if (temp.substring(0, 1).equals("|"))
					temp = "abcd" + temp;
				fileList.set(i, temp);
			}

			for (int i = 0; i <= contador; i++) {// percorrendo as linhas do arquivo e encontrando as respectivas
													// colunas
				int cont = 0;
				for (String line : fileList) {
					st = new StringTokenizer(line);
					String token = "";
					for (int y = 0; y <= i; y++) {
						token = st.nextToken("|");
					}
					if (!token.equals("abcd")) {
						cont++;
					}
				}
				verifyQuantity(header[i], cont, mapAttributes);// verifica se a quantidade selecionada é a

			}
			log.info("Finishing csv file reading");
		} catch (

		FileNotFoundException fe) {
			log.error("File was not found " + fe.getMessage());
			// throw fe;
		} catch (IOException e) {
			log.error("It was not possible to open the file");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		} catch (Exception e) {
			log.error("Error reading Csv File");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void readTxt(Map<String, Integer> mapAttributes, int listType) throws Exception {
		// método para ler o arquivo .txt
		log.info("Reading txt file");
		String separator = File.separator; // separador do sistema operacional

		String path = "target" + separator + "Lista" + separator + firstListName.getText() + firstListId.getText()
				+ ".txt"; // caminho do arquivo txt

		List<String> fileList = new ArrayList<>();
		String ln = "";
		try (FileReader file = new FileReader(path); BufferedReader readFile = new BufferedReader(file)) {

			String linha = null;
			int idx = 0;
			while ((linha = readFile.readLine()) != null) { // lendo as linhas do arquivo
				idx++;
				if (idx == 1) {
					ln = linha; // primeira linha
					continue;
				}
				fileList.add(linha);
			}
			if (fileList.size() == 0) {
				log.error("File is Empty");
				// throw new Exception("File is Empty");
			}
			StringTokenizer st = new StringTokenizer(ln);
			int contador = 0;
			st.nextToken("|");
			contador = st.countTokens(); // verificando quantas colunas a primeira linha tem
			String[] header = ln.split("\\|");// lista dos headers

			for (int i = 0; i < fileList.size(); i++) {// substituindo espaços em branco do arquivo - FileList é a lista
														// que recebe cada linha do arquivo
				String temp = fileList.get(i);
				temp = temp + "|";// adicionando o caracter | no final de cada linha
				temp = temp.replace("||", "|abcd|");
				temp = temp.replace("||", "|abcd|");
				temp = temp.replace("||", "|");
				if (temp.substring(0, 1).equals("|"))
					temp = "abcd" + temp;
				fileList.set(i, temp);
			}

			for (int i = 0; i <= contador; i++) {// percorrendo as linhas do arquivo e encontrando as respectivas
													// colunas
				int cont = 0;
				for (String line : fileList) {
					st = new StringTokenizer(line);
					String token = "";
					for (int y = 0; y <= i; y++) {
						token = st.nextToken("|");// percorre até a coluna correspondente
					}
					if (!token.equals("abcd")) {
						cont++;
					}
				}
				System.out.println("  " + cont);
				verifyQuantity(header[i], cont, mapAttributes);// verifica se a quantidade selecionada é a
																// mesma do arquivo (pessoa física)

			}
			log.info("Finishing txt file reading");
		} catch (FileNotFoundException fe) {
			log.error("File was not found " + fe.getMessage());
			throw fe;
		} catch (IOException e) {
			log.error("It was not possible to open the file");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		} catch (Exception e) {
			log.error("Error reading Txt File");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void readExcel(Map<String, Integer> mapAttributes, int typeList) throws Exception {
		try {
			// Método responsável por ler o arquivo Excel
			// Método para ler o arquivo CSV
			log.info("Reading excel file");
			String separator = File.separator; // separador padrão do Sistema opercacional

			String path = "target" + separator + "Lista" + separator + firstListName.getText() + firstListId.getText()
					+ "1.xlsx"; // caminho do arquivo Excel s

			File file = new File(path);
			String name = file.toString();
			int pos = name.lastIndexOf('.');
			String ext = name.substring(pos + 1);
			FileInputStream fileIn = new FileInputStream(file);
			Workbook obj = null;

			// verificando a extensão do arquivo enviados
			if (ext.equals("xlsx")) {
				try {
					// Metodo aceita o path do arquivo
					obj = new XSSFWorkbook(fileIn);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			} else if (ext.equals("xls")) {
				try {
					// Metodo nao aceita string do path do arquivo
					obj = new HSSFWorkbook(fileIn);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			} else {
				log.error("Received file does not have a standard excel extension.");
				throw new IllegalArgumentException("Received file does not have a standard excel extension.");
			}

			Sheet worksheet = obj.getSheet("Sheet1");
			if (worksheet.getPhysicalNumberOfRows() < 1) {
				log.error("File is Empty");
				throw new Exception("File is Empty");
			}

			Cell cell = null;

			int num = worksheet.getLastRowNum();// última linha do arquivo
			int contagem = 0;
			int colunas = worksheet.getRow(0).getPhysicalNumberOfCells(); // quantidades de colunas

			for (int i = 0; i < colunas; i++) { // calculando a quantidade de registros não nulos de cada coluna - for
												// pra cada coluna
				Cell cellHeader = worksheet.getRow(0).getCell(i);// header da coluna - Primeira linha
				for (int j = 1; j <= num; j++) { // for em cada linha
					// somando cada coluna

					cell = worksheet.getRow(j).getCell(i);// Linha zero de cada coluna
					try {
						if (cell.getNumericCellValue() > 0) {
							contagem++;// soma de registros não nulos da respectiva coluna
						}
					} catch (Exception e) {
						try {
							if (!cell.getStringCellValue().isEmpty() || !cell.getStringCellValue().equals("")) {
								contagem++;// soma de registros não nulos da respectiva coluna
							}
						} catch (Exception ex) {
							continue;
						}
					}
				}
				// System.out.println(" " + cellHeader.getStringCellValue() + " Valor = " +
				// contagem);
				verifyQuantity(cellHeader.getStringCellValue(), contagem, mapAttributes); // verifica se a quantidade
																							// selecionada é a mesma do
				cell = null; // arquivo
				contagem = 0;
			}

			/*
			 * char letra1 = 'A'; char letra2 = 'A'; char letra3 = 'V';
			 * 
			 * for (int i = 0; i < colunas; i++) { // calculando a quantidade de registros
			 * não nulos de cada coluna - // fazendo um for por coluna Cell cellHeader =
			 * worksheet.getRow(0).getCell(i);// header da coluna - Primeira linha cell =
			 * worksheet.createRow(num).createCell(i);// célula que recebe a soma da
			 * respectiva coluna cell.setCellType(Cell.CELL_TYPE_FORMULA); String formula =
			 * ""; // verifica as celulas que serão somadas if (letra3 == 'V') { formula =
			 * "COUNTA(" + letra1 + "2:" + letra1 + "" + (num - 1) + ")"; // coluna somente
			 * tem uma letra // - Coluna A até Z letra1++; } else { formula = "COUNTA(" +
			 * letra1 + letra2 + "2:" + letra1 + letra2 + (num - 1) + ")";// coluna passou
			 * da // letra "Z" e // agora tem // duas letras // na fórmula = // Colunas AA
			 * // até ZZ letra2++; } System.out.println("formula  " + formula);
			 * cell.setCellFormula(formula); // setando a fórmula FormulaEvaluator
			 * formulaEvaluator = obj.getCreationHelper().createFormulaEvaluator();
			 * formulaEvaluator.evaluateAll(); obj.getForceFormulaRecalculation(); int
			 * contagem = (int) cell.getNumericCellValue(); // soma dos registros não nulos
			 * da coluna row = worksheet.getRow(0); cell = row.getCell(i);
			 * System.out.println(" " + cellHeader.getStringCellValue() + "  Valor = " +
			 * contagem); verifyQuantity(cellHeader.getStringCellValue(), contagem,
			 * mapAttributes); // verifica se a // quantidade // selecionada é a // mesma do
			 * arquivo // (pessoa física) // if (mapAttributes.length == 31) //
			 * verifyQuantityPJS(cellHeader.getStringCellValue(), contagem, //
			 * mapAttributes);// // verifica se a // quantidade // selecionada é a // mesma
			 * do arquivo // (pessoa jurídica)
			 * 
			 * if (letra1 == '[') { // ajustando a fórmula letra1 = 'A'; letra2 = 'A';
			 * letra3 = 'C'; } if (letra2 == '[') { letra1++; letra2 = 'A'; letra3 = 'C'; }
			 * }
			 * 
			 * /
			 */
			log.info("Finishing Excel file reading");
		} catch (FileNotFoundException e) {
			log.error("File was not found");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		} catch (IOException e) {
			log.error("It was not possible to open the file");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		} catch (Exception e) {
			log.error("Error reading Excel File");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void verifyQuantityPJ(int indice, int quantity, int[] arrayQ) throws Exception {
		// Verificando se quantidade selecionada e a mesma do arquivo
		// Verificamos o header e temos o array de 31 posições que guardou q quantidade
		// de cada atributo que foi selecionado
		// Pessoa Jurídica

		if (indice == 0) {
			log.info("Quantity of CNPJ choosen  " + arrayQ[0]);
			log.info("Quantity of CNPJ in the file " + quantity);
			if (arrayQ[0] != quantity) {
				log.error("Quantity of CNPJ in the file is invalid");
				// throw new Exception("Quantity of CNPJ in the file is invalid");
			}
		}
		if (indice == 1) {
			log.info("Quantity of Razão Social choosen  " + arrayQ[1]);
			log.info("Quantity of Razão Social in the file " + quantity);
			if (arrayQ[1] != quantity) {
				log.error("Quantity of Razão Social in the file is invalid");
				// throw new Exception("Quantity of Razão Social in the file is invalid");
			}
		}
		if (indice == 2) {
			log.info("Quantity of Situação da Receita Federal choosen  " + arrayQ[2]);
			log.info("Quantity of Situação da Receita Federal  in the file " + quantity);
			if (arrayQ[2] != quantity) {
				log.error("Quantity of Situacao Receita Federal in the file is invalid");
				// throw new Exception("Quantity of Situacao Receita Federal in the file is
				// invalid");
			}
		}
		if (indice == 3) {
			log.info("Quantity of Data Fundação choosen " + arrayQ[3]);
			log.info("Quantity of Data Fundação in the file " + quantity);
			if (arrayQ[3] != quantity) {
				log.error("Quantity of Data Fundação in the file is invalid");
				// throw new Exception("Quantity of Data Fundação in the file is invalid");
			}

		}
		if (indice == 4) {
			log.info("Quantity of Nome Fantasia choosen " + arrayQ[4]);
			log.info("Quantity of Nome Fantasia in the file " + quantity);
			if (arrayQ[4] != quantity) {
				log.error(" Quantity of Nome Fantasia  in the file is invalid");
				// throw new Exception(" Quantity of Nome Fantasia in the file is invalid");
			}
		}
		if (indice == 5) {
			log.info("Quantity of Email choosen " + arrayQ[5]);
			log.info("Quantity of Email de nascimento in the file " + quantity);
			if (arrayQ[5] != quantity) {
				log.error("Quantity of Email  in the file is invalid");
				// throw new Exception("Quantity of Email in the file is invalid");
			}
		}

		if (indice == 6) {
			log.info("Quantity of Telefone 1 choosen " + arrayQ[6]);
			log.info("Quantity of Telefone 1 in the file " + quantity);
			if (arrayQ[6] != quantity) {
				log.error(" Quantity of Telefone 1 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 1 in the file is invalid");
			}
		}
		if (indice == 8) {
			log.info("Quantity of Telefone 2 choosen " + arrayQ[7]);
			log.info("Quantity of Telefone 2 in the file " + quantity);
			if (arrayQ[7] != quantity) {
				log.error(" Quantity of Telefone 2 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 2 in the file is invalid");
			}
		}
		if (indice == 10) {
			log.info("Quantity of Telefone 3 choosen " + arrayQ[8]);
			log.info("Quantity of Telefone 3 in the file " + quantity);
			if (arrayQ[8] != quantity) {
				log.error(" Quantity of Telefone 3 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 3 in the file is invalid");
			}
		}
		if (indice == 12) {
			log.info("Quantity of Telefone 4 choosen " + arrayQ[9]);
			log.info("Quantity of Telefone 4 in the file " + quantity);
			if (arrayQ[9] != quantity) {
				log.error(" Quantity of Telefone 4 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 4 in the file is invalid");
			}
		}
		if (indice == 14) {
			log.info("Quantity of Telefone 5 choosen " + arrayQ[10]);
			log.info("Quantity of Telefone 5 in the file " + quantity);
			if (arrayQ[10] != quantity) {
				log.error(" Quantity of Telefone 5 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 5 in the file is invalid");
			}
		}
		if (indice == 16) {
			log.info("Quantity of Celular 1 choosen " + arrayQ[11]);
			log.info("Quantity of Celular 1 in the file " + quantity);
			if (arrayQ[11] != quantity) {
				log.error(" Quantity of Celular 1 in the file is invalid");
				// throw new Exception(" Quantity of Celular 1 in the file is invalid");
			}
		}
		if (indice == 18) {
			log.info("Quantity of Celular 2 choosen " + arrayQ[12]);
			log.info("Quantity of Celular 2 in the file " + quantity);
			if (arrayQ[12] != quantity) {
				log.error(" Quantity of Celular 2 in the file is invalid");
				// throw new Exception(" Quantity of Celular 2 in the file is invalid");
			}
		}
		if (indice == 20) {
			log.info("Quantity of Celular 3 choosen " + arrayQ[13]);
			log.info("Quantity of Celular 3 in the file " + quantity);
			if (arrayQ[13] != quantity) {
				log.error(" Quantity of Celular 3 in the file is invalid");
				// throw new Exception(" Quantity of Celular 3 in the file is invalid");
			}
		}
		if (indice == 22) {
			log.info("Quantity of Celular 4 choosen " + arrayQ[14]);
			log.info("Quantity of Celular 4 in the file " + quantity);
			if (arrayQ[14] != quantity) {
				log.error(" Quantity of Celular 4 in the file is invalid");
				// throw new Exception(" Quantity of Celular 4 in the file is invalid");
			}
		}
		if (indice == 24) {
			log.info("Quantity of Celular 5 choosen " + arrayQ[15]);
			log.info("Quantity of Celular 5 in the file " + quantity);
			if (arrayQ[15] != quantity) {
				log.error(" Quantity of Celular 5 in the file is invalid");
				// throw new Exception(" Quantity of Celular 5 in the file is invalid");
			}
		}
		if (indice == 26) {
			log.info("Quantity of Whatsapp Celular 1 choosen " + arrayQ[16]);
			log.info("Quantity of Whatsapp Celular 1 in the file " + quantity);
			if (arrayQ[16] != quantity) {
				log.error(" Quantity of Whatsapp Celular 1 in the file is invalid");
				// throw new Exception(" Quantity of Celular 1 in the file is invalid");
			}
		}
		if (indice == 27) {
			log.info("Quantity of Whatsapp Celular 2 choosen " + arrayQ[17]);
			log.info("Quantity of Whatsapp Celular 2 in the file " + quantity);
			if (arrayQ[17] != quantity) {
				log.error(" Quantity of Whatsapp Celular 2 in the file is invalid");
				// throw new Exception(" Quantity of Celular 2 in the file is invalid");
			}
		}
		if (indice == 28) {
			log.info("Quantity of Whatsapp Celular 3 choosen " + arrayQ[18]);
			log.info("Quantity of Whatsapp Celular 3 in the file " + quantity);
			if (arrayQ[18] != quantity) {
				log.error(" Quantity of Whatsapp Celular 3 in the file is invalid");
				// throw new Exception(" Quantity of Celular 3 in the file is invalid");
			}
		}
		if (indice == 29) {
			log.info("Quantity of Whatsapp Celular 4 choosen " + arrayQ[19]);
			log.info("Quantity of Whatsapp Celular 4 in the file " + quantity);
			if (arrayQ[19] != quantity) {
				log.error(" Quantity of Whatsapp Celular 4 in the file is invalid");
				// throw new Exception(" Quantity of Celular 4 in the file is invalid");
			}
		}
		if (indice == 30) {
			log.info("Quantity of Whatsapp Celular 5 choosen " + arrayQ[20]);
			log.info("Quantity of Whatsapp Celular 5 in the file " + quantity);
			if (arrayQ[20] != quantity) {
				log.error(" Quantity of Whatsapp Celular 5 in the file is invalid");
				// throw new Exception(" Quantity of Celular 5 in the file is invalid");
			}
		}
		if (indice == 31) {
			log.info("Quantity of Cnae choosen " + arrayQ[21]);
			log.info("Quantity of Cnae in the file " + quantity);
			if (arrayQ[21] != quantity) {
				log.error(" Quantity of Cnae in the file is invalid");
				// throw new Exception(" Quantity of Cnae in the file is invalid");
			}
		}
		if (indice == 32) {
			log.info("Quantity of Porte da Empresa choosen " + arrayQ[22]);
			log.info("Quantity of Porte da Empresa in the file " + quantity);
			if (arrayQ[22] != quantity) {
				log.error(" Quantity of Porte da Empresa in the file is invalid");
				// throw new Exception(" Quantity of Porte da Empresa in the file is invalid");
			}
		}
		if (indice == 33) {
			log.info("Quantity of Número de Funcionários choosen " + arrayQ[23]);
			log.info("Quantity of Número de Funcionários  in the file " + quantity);
			if (arrayQ[23] != quantity) {
				log.error(" Quantity of Número de Funcionários in the file is invalid");
				// throw new Exception(" Quantity of Número de Funcionários in the file is
				// invalid");
			}
		}
		if (indice == 34) {
			log.info("Quantity of Faturamento Presumido choosen " + arrayQ[24]);
			log.info("Quantity of Faturamento Presumido in the file " + quantity);
			if (arrayQ[24] != quantity) {
				log.error(" Quantity of Faturamento Presumido in the file is invalid");
				// throw new Exception(" Quantity of Faturamento Presumido in the file is
				// invalid");
			}
		}
		if (indice == 35) {
			log.info("Quantity of Sócio 1 choosen " + arrayQ[25]);
			log.info("Quantity of Sócio 1 in the file " + quantity);
			if (arrayQ[25] != quantity) {
				log.error(" Quantity of Sócio 1 in the file is invalid");
				// throw new Exception(" Quantity of Sócio 1 in the file is invalid");
			}
		}
		if (indice == 36) {
			log.info("Quantity of Sócio 2 choosen " + arrayQ[26]);
			log.info("Quantity of Sócio 2 in the file " + quantity);
			if (arrayQ[26] != quantity) {
				log.error(" Quantity of Sócio 2 in the file is invalid");
				// throw new Exception(" Quantity of Sócio 2 in the file is invalid");
			}
		}
		if (indice == 37) {
			log.info("Quantity of Sócio 3 choosen " + arrayQ[27]);
			log.info("Quantity of Sócio 3 in the file " + quantity);
			if (arrayQ[27] != quantity) {
				log.error(" Quantity of Sócio 3 in the file is invalid");
				// throw new Exception(" Quantity of Sócio 3 in the file is invalid");
			}
		}
		if (indice == 38) {
			log.info("Quantity of Restricao Financeira choosen " + arrayQ[28]);
			log.info("Quantity of Restricao Financeira in the file " + quantity);
			if (arrayQ[28] != quantity) {
				log.error(" Quantity of Restricao Financeira in the file is invalid");
				// throw new Exception(" Quantity of Restricao Financeira in the file is
				// invalid");
			}
		}
		if (indice == 39) {
			log.info("Quantity of Síntegra choosen " + arrayQ[29]);
			log.info("Quantity of Síntegra in the file " + quantity);
			if (arrayQ[29] != quantity) {
				log.error(" Quantity of Síntegra in the file is invalid");
				// throw new Exception(" Quantity of Síntegra in the file is invalid");
			}
		}
		if (indice == 40) {
			log.info("Quantity of Endereço choosen " + arrayQ[30]);
			log.info("Quantity of Endereço in the file " + quantity);
			if (arrayQ[30] != quantity) {
				log.error(" Quantity of Endereço in the file is invalid");
				// throw new Exception(" Quantity of Endereço in the file is invalid");
			}
		}
	}

	public void verifyQuantityPJS(String header, int quantity, int[] arrayQ) throws Exception {

		// Verificando se quantidade selecionada e a mesma do arquivo
		// Verificamos o header e temos o array de 31 posições que guardou q quantidade
		// de cada atributo que foi selecionado
		// Pessoa Jurídica

		if (header.equals("cnpj")) {
			log.info("Quantity of CNPJ choosen  " + arrayQ[0]);
			log.info("Quantity of CNPJ in the file " + quantity);
			if (arrayQ[0] != quantity) {
				log.error("Quantity of CNPJ in the file is invalid");
				// throw new Exception("Quantity of CNPJ in the file is invalid");
			}
		}
		if (header.equals("razaosocial")) {
			log.info("Quantity of Razão Social choosen  " + arrayQ[1]);
			log.info("Quantity of Razão Social in the file " + quantity);
			if (arrayQ[1] != quantity) {
				log.error("Quantity of Razão Social in the file is invalid");
				// throw new Exception("Quantity of Razão Social in the file is invalid");
			}
		}
		if (header.equals("situacaorf")) {
			log.info("Quantity of Situação da Receita Federal choosen  " + arrayQ[2]);
			log.info("Quantity of Situação da Receita Federal  in the file " + quantity);
			if (arrayQ[2] != quantity) {
				log.error("Quantity of Situacao Receita Federal in the file is invalid");
				// throw new Exception("Quantity of Situacao Receita Federal in the file is
				// invalid");
			}
		}
		if (header.equals("datafundacao")) {
			log.info("Quantity of Data Fundação choosen " + arrayQ[3]);
			log.info("Quantity of Data Fundação in the file " + quantity);
			if (arrayQ[3] != quantity) {
				log.error("Quantity of Data Fundação in the file is invalid");
				// throw new Exception("Quantity of Data Fundação in the file is invalid");
			}
		}

		if (header.equals("nomefantasia")) {
			log.info("Quantity of Nome Fantasia choosen " + arrayQ[4]);
			log.info("Quantity of Nome Fantasia in the file " + quantity);
			if (arrayQ[4] != quantity) {
				log.error(" Quantity of Nome Fantasia  in the file is invalid");
				// throw new Exception(" Quantity of Nome Fantasia in the file is invalid");
			}
		}

		if (header.equals("email")) {
			log.info("Quantity of Email choosen " + arrayQ[5]);
			log.info("Quantity of Email de nascimento in the file " + quantity);
			if (arrayQ[5] != quantity) {
				log.error("Quantity of Email  in the file is invalid");
				// throw new Exception("Quantity of Email in the file is invalid");
			}
		}

		if (header.equals("telefonefixo1")) {
			log.info("Quantity of Telefone 1 choosen " + arrayQ[6]);
			log.info("Quantity of Telefone 1 in the file " + quantity);
			if (arrayQ[6] != quantity) {
				log.error(" Quantity of Telefone 1 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 1 in the file is invalid");
			}
		}
		if (header.equals("telefonefixo2")) {
			log.info("Quantity of Telefone 2 choosen " + arrayQ[7]);
			log.info("Quantity of Telefone 2 in the file " + quantity);
			if (arrayQ[7] != quantity) {
				log.error(" Quantity of Telefone 2 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 2 in the file is invalid");
			}
		}
		if (header.equals("telefonefixo3")) {
			log.info("Quantity of Telefone 3 choosen " + arrayQ[8]);
			log.info("Quantity of Telefone 3 in the file " + quantity);
			if (arrayQ[8] != quantity) {
				log.error(" Quantity of Telefone 3 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 3 in the file is invalid");
			}
		}
		if (header.equals("telefonefixo4")) {
			log.info("Quantity of Telefone 4 choosen " + arrayQ[9]);
			log.info("Quantity of Telefone 4 in the file " + quantity);
			if (arrayQ[9] != quantity) {
				log.error(" Quantity of Telefone 4 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 4 in the file is invalid");
			}
		}
		if (header.equals("telefonefixo5")) {
			log.info("Quantity of Telefone 5 choosen " + arrayQ[10]);
			log.info("Quantity of Telefone 5 in the file " + quantity);
			if (arrayQ[10] != quantity) {
				log.error(" Quantity of Telefone 5 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 5 in the file is invalid");
			}
		}
		if (header.equals("telefonecelular1")) {
			log.info("Quantity of Celular 1 choosen " + arrayQ[11]);
			log.info("Quantity of Celular 1 in the file " + quantity);
			if (arrayQ[11] != quantity) {
				log.error(" Quantity of Celular 1 in the file is invalid");
				// throw new Exception(" Quantity of Celular 1 in the file is invalid");
			}
		}
		if (header.equals("telefonecelular2")) {
			log.info("Quantity of Celular 2 choosen " + arrayQ[12]);
			log.info("Quantity of Celular 2 in the file " + quantity);
			if (arrayQ[12] != quantity) {
				log.error(" Quantity of Celular 2 in the file is invalid");
				// throw new Exception(" Quantity of Celular 2 in the file is invalid");
			}
		}
		if (header.equals("telefonecelular3")) {
			log.info("Quantity of Celular 3 choosen " + arrayQ[13]);
			log.info("Quantity of Celular 3 in the file " + quantity);
			if (arrayQ[13] != quantity) {
				log.error(" Quantity of Celular 3 in the file is invalid");
				// throw new Exception(" Quantity of Celular 3 in the file is invalid");
			}
		}
		if (header.equals("telefonecelular4")) {
			log.info("Quantity of Celular 4 choosen " + arrayQ[14]);
			log.info("Quantity of Celular 4 in the file " + quantity);
			if (arrayQ[14] != quantity) {
				log.error(" Quantity of Celular 4 in the file is invalid");
				// throw new Exception(" Quantity of Celular 4 in the file is invalid");
			}
		}
		if (header.equals("telefonecelular5")) {
			log.info("Quantity of Celular 5 choosen " + arrayQ[15]);
			log.info("Quantity of Celular 5 in the file " + quantity);
			if (arrayQ[15] != quantity) {
				log.error(" Quantity of Celular 5 in the file is invalid");
				// throw new Exception(" Quantity of Celular 5 in the file is invalid");
			}
		}
		if (header.equals("whatsapp1")) {
			log.info("Quantity of Whatsapp Celular 1 choosen " + arrayQ[16]);
			log.info("Quantity of Whatsapp Celular 1 in the file " + quantity);
			if (arrayQ[16] != quantity) {
				log.error(" Quantity of Whatsapp Celular 1 in the file is invalid");
				// throw new Exception(" Quantity of Celular 1 in the file is invalid");
			}
		}
		if (header.equals("whatsapp2")) {
			log.info("Quantity of Whatsapp Celular 2 choosen " + arrayQ[17]);
			log.info("Quantity of Whatsapp Celular 2 in the file " + quantity);
			if (arrayQ[17] != quantity) {
				log.error(" Quantity of Whatsapp Celular 2 in the file is invalid");
				// throw new Exception(" Quantity of Celular 2 in the file is invalid");
			}
		}
		if (header.equals("whatsapp3")) {
			log.info("Quantity of Whatsapp Celular 3 choosen " + arrayQ[18]);
			log.info("Quantity of Whatsapp Celular 3 in the file " + quantity);
			if (arrayQ[18] != quantity) {
				log.error(" Quantity of Whatsapp Celular 3 in the file is invalid");
				// throw new Exception(" Quantity of Celular 3 in the file is invalid");
			}
		}
		if (header.equals("whatsapp4")) {
			log.info("Quantity of Whatsapp Celular 4 choosen " + arrayQ[19]);
			log.info("Quantity of Whatsapp Celular 4 in the file " + quantity);
			if (arrayQ[19] != quantity) {
				log.error(" Quantity of Whatsapp Celular 4 in the file is invalid");
				// throw new Exception(" Quantity of Celular 4 in the file is invalid");
			}
		}
		if (header.equals("whatsapp5")) {
			log.info("Quantity of Whatsapp Celular 5 choosen " + arrayQ[20]);
			log.info("Quantity of Whatsapp Celular 5 in the file " + quantity);
			if (arrayQ[20] != quantity) {
				log.error(" Quantity of Whatsapp Celular 5 in the file is invalid");
				// throw new Exception(" Quantity of Celular 5 in the file is invalid");
			}
		}
		if (header.equals("cnae")) {
			log.info("Quantity of Cnae choosen " + arrayQ[21]);
			log.info("Quantity of Cnae in the file " + quantity);
			if (arrayQ[21] != quantity) {
				log.error(" Quantity of Cnae in the file is invalid");
				// throw new Exception(" Quantity of Cnae in the file is invalid");
			}
		}
		if (header.equals("porte")) {
			log.info("Quantity of Porte da Empresa choosen " + arrayQ[22]);
			log.info("Quantity of Porte da Empresa in the file " + quantity);
			if (arrayQ[22] != quantity) {
				log.error(" Quantity of Porte da Empresa in the file is invalid");
				// throw new Exception(" Quantity of Porte da Empresa in the file is invalid");
			}
		}
		if (header.equals("numerofuncionarios")) {
			log.info("Quantity of Número de Funcionários choosen " + arrayQ[23]);
			log.info("Quantity of Número de Funcionários  in the file " + quantity);
			if (arrayQ[23] != quantity) {
				log.error(" Quantity of Número de Funcionários in the file is invalid");
				// throw new Exception(" Quantity of Número de Funcionários in the file is
				// invalid");
			}
		}
		if (header.equals("faturamentopresumido")) {
			log.info("Quantity of Faturamento Presumido choosen " + arrayQ[24]);
			log.info("Quantity of Faturamento Presumido in the file " + quantity);
			if (arrayQ[24] != quantity) {
				log.error(" Quantity of Faturamento Presumido in the file is invalid");
				// throw new Exception(" Quantity of Faturamento Presumido in the file is
				// invalid");
			}
		}
		if (header.equals("socio1")) {
			log.info("Quantity of Sócio 1 choosen " + arrayQ[25]);
			log.info("Quantity of Sócio 1 in the file " + quantity);
			if (arrayQ[25] != quantity) {
				log.error(" Quantity of Sócio 1 in the file is invalid");
				// throw new Exception(" Quantity of Sócio 1 in the file is invalid");
			}
		}
		if (header.equals("socio2")) {
			log.info("Quantity of Sócio 2 choosen " + arrayQ[26]);
			log.info("Quantity of Sócio 2 in the file " + quantity);
			if (arrayQ[26] != quantity) {
				log.error(" Quantity of Sócio 2 in the file is invalid");
				// throw new Exception(" Quantity of Sócio 2 in the file is invalid");
			}
		}
		if (header.equals("socio3")) {
			log.info("Quantity of Sócio 3 choosen " + arrayQ[27]);
			log.info("Quantity of Sócio 3 in the file " + quantity);
			if (arrayQ[27] != quantity) {
				log.error(" Quantity of Sócio 3 in the file is invalid");
				// throw new Exception(" Quantity of Sócio 3 in the file is invalid");
			}
		}
		if (header.equals("restricaofinanceira")) {
			log.info("Quantity of Restricao Financeira choosen " + arrayQ[28]);
			log.info("Quantity of Restricao Financeira in the file " + quantity);
			if (arrayQ[28] != quantity) {
				log.error(" Quantity of Restricao Financeira in the file is invalid");
				// throw new Exception(" Quantity of Restricao Financeira in the file is
				// invalid");
			}
		}
		if (header.equals("sintegra")) {
			log.info("Quantity of Síntegra choosen " + arrayQ[29]);
			log.info("Quantity of Síntegra in the file " + quantity);
			if (arrayQ[29] != quantity) {
				log.error(" Quantity of Síntegra in the file is invalid");
				// throw new Exception(" Quantity of Síntegra in the file is invalid");
			}
		}
		if (header.equals("logradouro")) {
			log.info("Quantity of Endereço choosen " + arrayQ[30]);
			log.info("Quantity of Endereço in the file " + quantity);
			if (arrayQ[30] != quantity) {
				log.error(" Quantity of Endereço in the file is invalid");
				// throw new Exception(" Quantity of Endereço in the file is invalid");
			}
		}
	}

	public void verifyQuantityPF(int indice, int quantity, int[] arrayQ) throws Exception {

		// verificando se quantidade selecionada e a mesma do arquivo
		// verificamos o header e temos o array de 40 posições que guardou q quantidade
		// de cada atributo que foi selecionado

		if (indice == 0) {
			log.info("Quantity of cpf choosen " + arrayQ[0]);
			log.info("Quantity of cpf in the file " + quantity);
			if (arrayQ[0] != quantity) {
				log.error("Quantity of Cpf in the file is invalid");
				// throw new Exception("Quantity of Cpf in the file is invalid");
			}
		}
		if (indice == 1) {
			log.info("Quantity of Nome choosen " + arrayQ[1]);
			log.info("Quantity of Nome in the file " + quantity);
			if (arrayQ[1] != quantity) {
				log.error("Quantity of Nome in the file is invalid");
				// throw new Exception("Quantity of Nome in the file is invalid");
			}
		}
		if (indice == 2) {
			log.info("Quantity of Situação da Receita Federal choosen " + arrayQ[2]);
			log.info("Quantity of Situação da Receita Federal  in the file " + quantity);
			if (arrayQ[2] != quantity) {
				log.error("Quantity of Situacao Receita Federal in the file is invalid");
				// throw new Exception("Quantity of Situacao Receita Federal in the file is
				// invalid");
			}
		}
		if (indice == 4) {
			log.info("Quantity of Endereço choosen " + arrayQ[3]);
			log.info("Quantity of Endereço in the file " + quantity);
			if (arrayQ[3] != quantity) {
				log.error("Quantity of Endereço in the file is invalid");
				// throw new Exception("Quantity of Endereço in the file is invalid");
			}

		}
		if (indice == 11) {
			log.info("Quantity of Data de nascimento choosen " + arrayQ[4]);
			log.info("Quantity of Data de nascimento in the file " + quantity);
			if (arrayQ[4] != quantity) {
				log.error("Quantity of Data de nascimento  in the file is invalid");
				// throw new Exception("Quantity of Data de nascimento in the file is invalid");
			}
		}
		if (indice == 12) {
			log.info("Quantity of Gênero choosen " + arrayQ[5]);
			log.info("Quantity of Gênero in the file " + quantity);
			if (arrayQ[5] != quantity) {
				log.error(" Quantity of Gênero  in the file is invalid");
				// throw new Exception(" Quantity of Gênero in the file is invalid");
			}
		}
		if (indice == 13) {
			log.info("Quantity of Escolaridade choosen " + arrayQ[6]);
			log.info("Quantity of Escolaridade in the file " + quantity);
			if (arrayQ[6] != quantity) {
				log.error(" Quantity of Escolaridade in the file is invalid");
				// throw new Exception(" Quantity of Escolaridade in the file is invalid");
			}
		}
		if (indice == 14) {
			log.info("Quantity of Nome Pai choosen " + arrayQ[7]);
			log.info("Quantity of Nome Pai in the file " + quantity);
			if (arrayQ[7] != quantity) {
				log.error(" Quantity of Nome Pai in the file is invalid");
				// throw new Exception(" Quantity of Nome Pai in the file is invalid");
			}
		}
		if (indice == 15) {
			log.info("Quantity of Nome da Mãe choosen " + arrayQ[8]);
			log.info("Quantity of Nome da Mãe in the file " + quantity);
			if (arrayQ[8] != quantity) {
				log.error(" Quantity of Nome Mãe in the file is invalid");
				// throw new Exception(" Quantity of Nome Mãe in the file is invalid");
			}
		}
		if (indice == 16) {
			log.info("Quantity of Profissão choosen " + arrayQ[9]);
			log.info("Quantity of Profissão in the file " + quantity);
			if (arrayQ[9] != quantity) {
				log.error(" Quantity of Profissão in the file is invalid");
				// throw new Exception(" Quantity of Profissão in the file is invalid");

			}
		}
		if (indice == 17) {
			log.info("Quantity of Email choosen " + arrayQ[10]);
			log.info("Quantity of Email in the file " + quantity);
			if (arrayQ[10] != quantity) {
				log.error("Quantity of Email in the file is invalid");
				// throw new Exception(" Quantity of Email in the file is invalid");
			}
		}
		if (indice == 18) {
			log.info("Quantity of Telefone 1 choosen " + arrayQ[11]);
			log.info("Quantity of Telefone 1 in the file " + quantity);
			if (arrayQ[11] != quantity) {
				log.error(" Quantity of Telefone 1 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 1 in the file is invalid");
			}
		}
		if (indice == 20) {
			log.info("Quantity of Telefone 2 choosen " + arrayQ[12]);
			log.info("Quantity of Telefone 2 in the file " + quantity);
			if (arrayQ[12] != quantity) {
				log.error(" Quantity of Telefone 2 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 2 in the file is invalid");
			}
		}
		if (indice == 22) {
			log.info("Quantity of Telefone 3 choosen " + arrayQ[13]);
			log.info("Quantity of Telefone 3 in the file " + quantity);
			if (arrayQ[13] != quantity) {
				log.error(" Quantity of Telefone 3 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 3 in the file is invalid");
			}
		}
		if (indice == 24) {
			log.info("Quantity of Telefone 4 choosen " + arrayQ[14]);
			log.info("Quantity of Telefone 4 in the file " + quantity);
			if (arrayQ[14] != quantity) {
				log.error(" Quantity of Telefone 4 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 4 in the file is invalid");
			}
		}
		if (indice == 26) {
			log.info("Quantity of Telefone 5 choosen " + arrayQ[15]);
			log.info("Quantity of Telefone 5 in the file " + quantity);
			if (arrayQ[15] != quantity) {
				log.error(" Quantity of Telefone 5 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 5 in the file is invalid");
			}
		}
		if (indice == 28) {
			log.info("Quantity of Celular 1 choosen " + arrayQ[16]);
			log.info("Quantity of Celular 1 in the file " + quantity);
			if (arrayQ[16] != quantity) {
				log.error(" Quantity of Celular 1 in the file is invalid");
				// throw new Exception(" Quantity of Celular 1 in the file is invalid");
			}
		}
		if (indice == 30) {
			log.info("Quantity of Celular 2 choosen " + arrayQ[17]);
			log.info("Quantity of Celular 2 in the file " + quantity);
			if (arrayQ[17] != quantity) {
				log.error(" Quantity of Celular 2 in the file is invalid");
				// throw new Exception(" Quantity of Celular 2 in the file is invalid");
			}
		}
		if (indice == 32) {
			log.info("Quantity of Celular 3 choosen " + arrayQ[18]);
			log.info("Quantity of Celular 3 in the file " + quantity);
			if (arrayQ[18] != quantity) {
				log.error(" Quantity of Celular 3 in the file is invalid");
				// throw new Exception(" Quantity of Celular 3 in the file is invalid");
			}
		}
		if (indice == 34) {
			log.info("Quantity of Celular 4 choosen " + arrayQ[19]);
			log.info("Quantity of Celular 4 in the file " + quantity);
			if (arrayQ[19] != quantity) {
				log.error(" Quantity of Celular 4 in the file is invalid");
				// throw new Exception(" Quantity of Celular 4 in the file is invalid");
			}
		}
		if (indice == 36) {
			log.info("Quantity of Celular 5 choosen " + arrayQ[20]);
			log.info("Quantity of Celular 5 in the file " + quantity);
			if (arrayQ[20] != quantity) {
				log.error(" Quantity of Celular 5 in the file is invalid");
				// throw new Exception(" Quantity of Celular 5 in the file is invalid");
			}
		}
		if (indice == 38) {
			log.info("Quantity of Whatsapp Celular 1 choosen " + arrayQ[21]);
			log.info("Quantity of Whatsapp Celular 1 in the file " + quantity);
			if (arrayQ[21] != quantity) {
				log.error(" Quantity of Whatsapp Celular 1 in the file is invalid");
				// throw new Exception(" Quantity of Celular 1 in the file is invalid");
			}
		}
		if (indice == 39) {
			log.info("Quantity of Whatsapp Celular 2 choosen " + arrayQ[22]);
			log.info("Quantity of Whatsapp Celular 2 in the file " + quantity);
			if (arrayQ[22] != quantity) {
				log.error(" Quantity of Whatsapp Celular 2 in the file is invalid");
				// throw new Exception(" Quantity of Celular 2 in the file is invalid");
			}
		}
		if (indice == 40) {
			log.info("Quantity of Whatsapp Celular 3 choosen " + arrayQ[23]);
			log.info("Quantity of Whatsapp Celular 3 in the file " + quantity);
			if (arrayQ[23] != quantity) {
				log.error(" Quantity of Whatsapp Celular 3 in the file is invalid");
				// throw new Exception(" Quantity of Celular 3 in the file is invalid");
			}
		}
		if (indice == 41) {
			log.info("Quantity of Whatsapp Celular 4 choosen " + arrayQ[24]);
			log.info("Quantity of Whatsapp Celular 4 in the file " + quantity);
			if (arrayQ[24] != quantity) {
				log.error(" Quantity of Whatsapp Celular 4 in the file is invalid");
				// throw new Exception(" Quantity of Celular 4 in the file is invalid");
			}
		}
		if (indice == 42) {
			log.info("Quantity of Whatsapp Celular 5 choosen " + arrayQ[25]);
			log.info("Quantity of Whatsapp Celular 5 in the file " + quantity);
			if (arrayQ[25] != quantity) {
				log.error(" Quantity of Whatsapp Celular 5 in the file is invalid");
				// throw new Exception(" Quantity of Celular 5 in the file is invalid");
			}
		}
		if (indice == 43) {
			log.info("Quantity of Veículo choosen " + arrayQ[26]);
			log.info("Quantity of Veículo in the file " + quantity);
			if (arrayQ[26] != quantity) {
				log.error(" Quantity of Veículo in the file is invalid");
				// throw new Exception(" Quantity of Veículo in the file is invalid");
			}
		}
		if (indice == 44) {
			log.info("Quantity of Faixa de Renda choosen " + arrayQ[27]);
			log.info("Quantity of Faixa de Renda in the file " + quantity);
			if (arrayQ[27] != quantity) {
				log.error(" Quantity of Faixa de Renda in the file is invalid");
				// throw new Exception(" Quantity of Faixa de Renda in the file is invalid");
			}
		}
		if (indice == 45) {
			log.info("Quantity of Óbito choosen " + arrayQ[28]);
			log.info("Quantity of Óbito in the file " + quantity);
			if (arrayQ[28] != quantity) {
				log.error(" Quantity of Óbito in the file is invalid");
				// throw new Exception(" Quantity of Óbito in the file is invalid");
			}
		}
		if (indice == 46) {
			log.info("Quantity of Bolsa Família choosen " + arrayQ[29]);
			log.info("Quantity of Bolsa Família in the file " + quantity);
			if (arrayQ[29] != quantity) {
				log.error(" Quantity of Bolsa Família in the file is invalid");
				// throw new Exception(" Quantity of Bolsa Família in the file is invalid");
			}
		}
		if (indice == 47) {
			log.info("Quantity of Estado Civil choosen " + arrayQ[30]);
			log.info("Quantity of Estado Civil in the file " + quantity);
			if (arrayQ[30] != quantity) {
				log.error(" Quantity of Estado Civil in the file is invalid");
				// throw new Exception(" Quantity of Estado Civil in the file is invalid");
			}
		}
		if (indice == 48) {
			log.info("Quantity of Funcionario Clt choosen " + arrayQ[31]);
			log.info("Quantity of Funcionario Clt in the file " + quantity);
			if (arrayQ[31] != quantity) {
				log.error(" Quantity of Funcionario Clt in the file is invalid");
				// throw new Exception(" Quantity of Funcionario Clt in the file is invalid");
			}
		}

		if (indice == 49) {
			log.info("Quantity of Classe Social choosen " + arrayQ[32]);
			log.info("Quantity of Classe Social in the file " + quantity);
			if (arrayQ[32] != quantity) {
				log.error(" Quantity of Classe Social in the file is invalid");
				// throw new Exception(" Quantity of Classe Social in the file is invalid");
			}
		}
		if (indice == 50) {
			log.info("Quantity of Restrição Financeira choosen " + arrayQ[33]);
			log.info("Quantity of Restrição Financeira in the file " + quantity);
			if (arrayQ[33] != quantity) {
				log.error(" Quantity of  Restrição Financeira in the file is invalid");
				// throw new Exception(" Quantity of Restrição Financeira in the file is
				// invalid");
			}
		}
		if (indice == 51) {
			log.info("Quantity of Consignado choosen " + arrayQ[34]);
			log.info("Quantity of Consignado in the file " + quantity);
			if (arrayQ[34] != quantity) {
				log.error(" Quantity of Consignado in the file is invalid");
				// throw new Exception(" Quantity of Consignado in the file is invalid");
			}
		}
		if (indice == 52) {
			log.info("Quantity of Título de Eleitor choosen " + arrayQ[35]);
			log.info("Quantity of Título de Eleitor in the file " + quantity);
			if (arrayQ[35] != quantity) {
				log.error(" Quantity of Título de Eleitor in the file is invalid");
				// throw new Exception(" Quantity of Título de Eleitor in the file is invalid");
			}
		}
		if (indice == 53) {
			log.info("Quantity of Rg choosen " + arrayQ[36]);
			log.info("Quantity of Rg in the file " + quantity);
			if (arrayQ[36] != quantity) {
				log.error(" Quantity of Rg in the file is invalid");
				// throw new Exception(" Quantity of Rg in the file is invalid");
			}
		}
		if (indice == 54) {
			log.info("Quantity of Pis choosen " + arrayQ[37]);
			log.info("Quantity of Pis in the file " + quantity);
			if (arrayQ[37] != quantity) {
				log.error(" Quantity of Pis in the file is invalid");
				// throw new Exception(" Quantity of Pis in the file is invalid");
			}
		}
		if (indice == 55) {
			log.info("Quantity of Carteira Profissional choosen " + arrayQ[38]);
			log.info("Quantity of Carteira Profissional in the file " + quantity);
			if (arrayQ[38] != quantity) {
				log.error(" Quantity of Estado Civil in the file is invalid");
				// throw new Exception(" Quantity of Estado Civil in the file is invalid");
			}
		}
		if (indice == 56) {
			log.info("Quantity of Conselho Profissional choosen " + arrayQ[39]);
			log.info("Quantity of Conselho Profissional in the file " + quantity);
			if (arrayQ[39] != quantity) {
				log.error(" Quantity of Conselho Profissional in the file is invalid");
				// throw new Exception(" Quantity of Conselho Profissional in the file is
				// invalid");
			}
		}
	}

	public void verifyQuantity(String header, int quantity, Map<String, Integer> mapAttributes) throws Exception {
		try {
			if (mapAttributes.containsKey(header)) {
				log.info("Quantity of " + header + " choosen " + mapAttributes.get(header));
				log.info("Quantity of " + header + " in the file " + quantity);
				if (mapAttributes.get(header) != quantity)
					log.error("Quantity of " + header + " in the file is invalid");
				else {
					log.info("Quantity of " + header + " in the file is valid");
				}
			}
		} catch (Exception e) {
			log.error("It was not impossible to verify the quantity of the attribute " + header);
			log.error(e.getMessage());
		}
	}

	public void verifyQuantityPFS(String header, int quantity, int[] arrayQ) throws Exception {

		// verificando se quantidade selecionada e a mesma do arquivo
		// verificamos o header e temos o array de 40 posições que guardou q quantidade
		// de cada atributo que foi selecionado
		if (header.equals("cpf")) {
			log.info("Quantity of cpf choosen " + arrayQ[0]);
			log.info("Quantity of cpf in the file " + quantity);
			if (arrayQ[0] != quantity) {
				log.error("Quantity of Cpf in the file is invalid");
				// throw new Exception("Quantity of Cpf in the file is invalid");
			}
		}
		if (header.equals("nome")) {
			log.info("Quantity of Nome choosen " + arrayQ[1]);
			log.info("Quantity of Nome in the file " + quantity);
			if (arrayQ[1] != quantity) {
				log.error("Quantity of Nome in the file is invalid");
				// throw new Exception("Quantity of Nome in the file is invalid");
			}
		}
		if (header.equals("situacaorf")) {
			log.info("Quantity of Situação da Receita Federal choosen " + arrayQ[2]);
			log.info("Quantity of Situação da Receita Federal  in the file " + quantity);
			if (arrayQ[2] != quantity) {
				log.error("Quantity of Situacao Receita Federal in the file is invalid");
				// throw new Exception("Quantity of Situacao Receita Federal in the file is
				// invalid");
			}
		}
		if (header.equals("logradouro")) {
			log.info("Quantity of Endereço choosen " + arrayQ[3]);
			log.info("Quantity of Endereço in the file " + quantity);
			if (arrayQ[3] != quantity) {
				log.error("Quantity of Endereço in the file is invalid");
				// throw new Exception("Quantity of Endereço in the file is invalid");
			}

		}
		if (header.equals("datanascimento")) {
			log.info("Quantity of Data de nascimento choosen " + arrayQ[4]);
			log.info("Quantity of Data de nascimento in the file " + quantity);
			if (arrayQ[4] != quantity) {
				log.error("Quantity of Data de nascimento  in the file is invalid");
				// throw new Exception("Quantity of Data de nascimento in the file is invalid");
			}
		}
		if (header.equals("genero")) {
			log.info("Quantity of Gênero choosen " + arrayQ[5]);
			log.info("Quantity of Gênero in the file " + quantity);
			if (arrayQ[5] != quantity) {
				log.error(" Quantity of Gênero  in the file is invalid");
				// throw new Exception(" Quantity of Gênero in the file is invalid");
			}
		}
		if (header.equals("escolaridade")) {
			log.info("Quantity of Escolaridade choosen " + arrayQ[6]);
			log.info("Quantity of Escolaridade in the file " + quantity);
			if (arrayQ[6] != quantity) {
				log.error(" Quantity of Escolaridade in the file is invalid");
				// throw new Exception(" Quantity of Escolaridade in the file is invalid");
			}
		}
		if (header.equals("nomepai")) {
			log.info("Quantity of Nome Pai choosen " + arrayQ[7]);
			log.info("Quantity of Nome Pai in the file " + quantity);
			if (arrayQ[7] != quantity) {
				log.error(" Quantity of Nome Pai in the file is invalid");
				// throw new Exception(" Quantity of Nome Pai in the file is invalid");
			}
		}
		if (header.equals("nomemae")) {
			log.info("Quantity of Nome da Mãe choosen " + arrayQ[8]);
			log.info("Quantity of Nome da Mãe in the file " + quantity);
			if (arrayQ[8] != quantity) {
				log.error(" Quantity of Nome Mãe in the file is invalid");
				// throw new Exception(" Quantity of Nome Mãe in the file is invalid");
			}
		}
		if (header.equals("profissao")) {
			log.info("Quantity of Profissão choosen " + arrayQ[9]);
			log.info("Quantity of Profissão in the file " + quantity);
			if (arrayQ[9] != quantity) {
				log.error(" Quantity of Profissão in the file is invalid");
				// throw new Exception(" Quantity of Profissão in the file is invalid");

			}
		}
		if (header.equals("email")) {
			log.info("Quantity of Email choosen " + arrayQ[10]);
			log.info("Quantity of Email in the file " + quantity);
			if (arrayQ[10] != quantity) {
				log.error(" Quantity of Email in the file is invalid");
				// throw new Exception(" Quantity of Email in the file is invalid");
			}
		}
		if (header.equals("telefone1")) {
			log.info("Quantity of Telefone 1 choosen " + arrayQ[11]);
			log.info("Quantity of Telefone 1 in the file " + quantity);
			if (arrayQ[11] != quantity) {
				log.error(" Quantity of Telefone 1 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 1 in the file is invalid");
			}
		}
		if (header.equals("telefone2")) {
			log.info("Quantity of Telefone 2 choosen " + arrayQ[12]);
			log.info("Quantity of Telefone 2 in the file " + quantity);
			if (arrayQ[12] != quantity) {
				log.error(" Quantity of Telefone 2 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 2 in the file is invalid");
			}
		}
		if (header.equals("telefone3")) {
			log.info("Quantity of Telefone 3 choosen " + arrayQ[13]);
			log.info("Quantity of Telefone 3 in the file " + quantity);
			if (arrayQ[13] != quantity) {
				log.error(" Quantity of Telefone 3 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 3 in the file is invalid");
			}
		}
		if (header.equals("telefone4")) {
			log.info("Quantity of Telefone 4 choosen " + arrayQ[14]);
			log.info("Quantity of Telefone 4 in the file " + quantity);
			if (arrayQ[14] != quantity) {
				log.error(" Quantity of Telefone 4 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 4 in the file is invalid");
			}
		}
		if (header.equals("telefone5")) {
			log.info("Quantity of Telefone 5 choosen " + arrayQ[15]);
			log.info("Quantity of Telefone 5 in the file " + quantity);
			if (arrayQ[15] != quantity) {
				log.error(" Quantity of Telefone 5 in the file is invalid");
				// throw new Exception(" Quantity of Telefone 5 in the file is invalid");
			}
		}
		if (header.equals("celular1")) {
			log.info("Quantity of Celular 1 choosen " + arrayQ[16]);
			log.info("Quantity of Celular 1 in the file " + quantity);
			if (arrayQ[16] != quantity) {
				log.error(" Quantity of Celular 1 in the file is invalid");
				// throw new Exception(" Quantity of Celular 1 in the file is invalid");
			}
		}
		if (header.equals("celular2")) {
			log.info("Quantity of Celular 2 choosen " + arrayQ[17]);
			log.info("Quantity of Celular 2 in the file " + quantity);
			if (arrayQ[17] != quantity) {
				log.error(" Quantity of Celular 2 in the file is invalid");
				// throw new Exception(" Quantity of Celular 2 in the file is invalid");
			}
		}
		if (header.equals("celular3")) {
			log.info("Quantity of Celular 3 choosen " + arrayQ[18]);
			log.info("Quantity of Celular 3 in the file " + quantity);
			if (arrayQ[18] != quantity) {
				log.error(" Quantity of Celular 3 in the file is invalid");
				// throw new Exception(" Quantity of Celular 3 in the file is invalid");
			}
		}
		if (header.equals("celular4")) {
			log.info("Quantity of Celular 4 choosen " + arrayQ[19]);
			log.info("Quantity of Celular 4 in the file " + quantity);
			if (arrayQ[19] != quantity) {
				log.error(" Quantity of Celular 4 in the file is invalid");
				// throw new Exception(" Quantity of Celular 4 in the file is invalid");
			}
		}
		if (header.equals("celular5")) {
			log.info("Quantity of Celular 5 choosen " + arrayQ[20]);
			log.info("Quantity of Celular 5 in the file " + quantity);
			if (arrayQ[20] != quantity) {
				log.error(" Quantity of Celular 5 in the file is invalid");
				// throw new Exception(" Quantity of Celular 5 in the file is invalid");
			}
		}
		if (header.equals("whatasapp1")) {
			log.info("Quantity of Whatsapp Celular 1 choosen " + arrayQ[21]);
			log.info("Quantity of Whatsapp Celular 1 in the file " + quantity);
			if (arrayQ[21] != quantity) {
				log.error(" Quantity of Whatsapp Celular 1 in the file is invalid");
				// throw new Exception(" Quantity of Celular 1 in the file is invalid");
			}
		}
		if (header.equals("whatasapp2")) {
			log.info("Quantity of Whatsapp Celular 2 choosen " + arrayQ[22]);
			log.info("Quantity of Whatsapp Celular 2 in the file " + quantity);
			if (arrayQ[22] != quantity) {
				log.error(" Quantity of Whatsapp Celular 2 in the file is invalid");
				// throw new Exception(" Quantity of Celular 2 in the file is invalid");
			}
		}
		if (header.equals("whatasapp3")) {
			log.info("Quantity of Whatsapp Celular 3 choosen " + arrayQ[23]);
			log.info("Quantity of Whatsapp Celular 3 in the file " + quantity);
			if (arrayQ[23] != quantity) {
				log.error(" Quantity of Whatsapp Celular 3 in the file is invalid");
				// throw new Exception(" Quantity of Celular 3 in the file is invalid");
			}
		}
		if (header.equals("whatasapp4")) {
			log.info("Quantity of Whatsapp Celular 4 choosen " + arrayQ[24]);
			log.info("Quantity of Whatsapp Celular 4 in the file " + quantity);
			if (arrayQ[24] != quantity) {
				log.error(" Quantity of Whatsapp Celular 4 in the file is invalid");
				// throw new Exception(" Quantity of Celular 4 in the file is invalid");
			}
		}
		if (header.equals("whatasapp5")) {
			log.info("Quantity of Whatsapp Celular 5 choosen " + arrayQ[25]);
			log.info("Quantity of Whatsapp Celular 5 in the file " + quantity);
			if (arrayQ[25] != quantity) {
				log.error(" Quantity of Whatsapp Celular 5 in the file is invalid");
				// throw new Exception(" Quantity of Celular 5 in the file is invalid");
			}
		}
		if (header.equals("veiculo")) {
			log.info("Quantity of Veículo choosen " + arrayQ[26]);
			log.info("Quantity of Veículo in the file " + quantity);
			if (arrayQ[26] != quantity) {
				log.error(" Quantity of Veículo in the file is invalid");
				// throw new Exception(" Quantity of Veículo in the file is invalid");
			}
		}
		if (header.equals("faixarenda")) {
			log.info("Quantity of Faixa de Renda choosen " + arrayQ[27]);
			log.info("Quantity of Faixa de Renda in the file " + quantity);
			if (arrayQ[27] != quantity) {
				log.error(" Quantity of Faixa de Renda in the file is invalid");
				// throw new Exception(" Quantity of Faixa de Renda in the file is invalid");
			}
		}
		if (header.equals("obito")) {
			log.info("Quantity of Óbito choosen " + arrayQ[28]);
			log.info("Quantity of Óbito in the file " + quantity);
			if (arrayQ[28] != quantity) {
				log.error(" Quantity of Óbito in the file is invalid");
				// throw new Exception(" Quantity of Óbito in the file is invalid");
			}
		}
		if (header.equals("bolsafamilia")) {
			log.info("Quantity of Bolsa Família choosen " + arrayQ[29]);
			log.info("Quantity of Bolsa Família in the file " + quantity);
			if (arrayQ[29] != quantity) {
				log.error(" Quantity of Bolsa Família in the file is invalid");
				// throw new Exception(" Quantity of Bolsa Família in the file is invalid");
			}
		}
		if (header.equals("estadocivil")) {
			log.info("Quantity of Estado Civil choosen " + arrayQ[30]);
			log.info("Quantity of Estado Civil in the file " + quantity);
			if (arrayQ[30] != quantity) {
				log.error(" Quantity of Estado Civil in the file is invalid");
				// throw new Exception(" Quantity of Estado Civil in the file is invalid");
			}
		}
		if (header.equals("funcionarioclt")) {
			log.info("Quantity of Funcionario Clt choosen " + arrayQ[31]);
			log.info("Quantity of Funcionario Clt in the file " + quantity);
			if (arrayQ[31] != quantity) {
				log.error(" Quantity of Funcionario Clt in the file is invalid");
				// throw new Exception(" Quantity of Funcionario Clt in the file is invalid");
			}
		}

		if (header.equals("classesocial")) {
			log.info("Quantity of Classe Social choosen " + arrayQ[32]);
			log.info("Quantity of Classe Social in the file " + quantity);
			if (arrayQ[32] != quantity) {
				log.error(" Quantity of Classe Social in the file is invalid");
				// throw new Exception(" Quantity of Classe Social in the file is invalid");
			}
		}
		if (header.equals("restricaofinanceira")) {
			log.info("Quantity of Restrição Financeira choosen " + arrayQ[33]);
			log.info("Quantity of Restrição Financeira in the file " + quantity);
			if (arrayQ[33] != quantity) {
				log.error(" Quantity of  Restrição Financeira in the file is invalid");
				// throw new Exception(" Quantity of Restrição Financeira in the file is
				// invalid");
			}
		}
		if (header.equals("consignado")) {
			log.info("Quantity of Consignado choosen " + arrayQ[34]);
			log.info("Quantity of Consignado in the file " + quantity);
			if (arrayQ[34] != quantity) {
				log.error(" Quantity of Consignado in the file is invalid");
				// throw new Exception(" Quantity of Consignado in the file is invalid");
			}
		}
		if (header.equals("tituloeleitor")) {
			log.info("Quantity of Título de Eleitor choosen " + arrayQ[35]);
			log.info("Quantity of Título de Eleitor in the file " + quantity);
			if (arrayQ[35] != quantity) {
				log.error(" Quantity of Título de Eleitor in the file is invalid");
				// throw new Exception(" Quantity of Título de Eleitor in the file is invalid");
			}
		}
		if (header.equals("rg")) {
			log.info("Quantity of Rg choosen " + arrayQ[36]);
			log.info("Quantity of Rg in the file " + quantity);
			if (arrayQ[36] != quantity) {
				log.error(" Quantity of Rg in the file is invalid");
				// throw new Exception(" Quantity of Rg in the file is invalid");
			}
		}
		if (header.equals("pis")) {
			log.info("Quantity of Pis choosen " + arrayQ[37]);
			log.info("Quantity of Pis in the file " + quantity);
			if (arrayQ[37] != quantity) {
				log.error(" Quantity of Pis in the file is invalid");
				// throw new Exception(" Quantity of Pis in the file is invalid");
			}
		}
		if (header.equals("carteiraprofissional")) {
			log.info("Quantity of Carteira Profissional choosen " + arrayQ[38]);
			log.info("Quantity of Carteira Profissional in the file " + quantity);
			if (arrayQ[38] != quantity) {
				log.error(" Quantity of Carteira Profissional in the file is invalid");
				// throw new Exception(" Quantity of Estado Civil in the file is invalid");
			}
		}
		if (header.equals("conselhoprofissional")) {
			log.info("Quantity of Conselho Profissional choosen " + arrayQ[39]);
			log.info("Quantity of Conselho Profissional in the file " + quantity);
			if (arrayQ[39] != quantity) {
				log.error(" Quantity of Conselho Profissional in the file is invalid");
				// throw new Exception(" Quantity of Conselho Profissional in the file is
				// invalid");
			}
		}
	}

	public void creatList(String lName) throws InterruptedException {
		// enviando o nome da lista
		try {
			if (!lName.equals("vazia")) {// se o nome não estiver vazio
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // acrescentando a data e horario
																						// no nome
				String strDate = dateFormat.format(date);
				strDate = strDate.replace("-", "");
				strDate = strDate.replace(" ", "");
				strDate = strDate.replace(":", "");
				nameList = lName.concat(strDate);
				sendElemet(listName, nameList); // enviando o nome
				log.info("The name of list was sent");
			}
			if (lName.equals("vazia")) {
				listName.clear();// teste para lista vazia
				// listName.sendKeys("a");
				sendElemet(listName, "a");
				listName.sendKeys(Keys.BACK_SPACE);
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("It was possible to create the list " + lName);
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void goToHistory() throws InterruptedException {
		try {
			waitToElementAndClick(btGoTohistoric); // Indo para a página de histórico
			Thread.sleep(6000);
		} catch (Exception e) {
			log.error("It was possible to go to history");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void checkMessage() {
		// Verificando a mensagem presente na tela
		if (driver.getPageSource().contains("Nome da lista não pode ser vazio")) {// Mensagem de nome da lista vazia
			log.info("It was not possible to create a list with an empty name");
		}
		if (driver.getPageSource()
				.contains("Formato inválido, este campo não pode conter caracteres especiais e espaços")) {// Mensagem
																											// de
																											// caracteres
																											// especiais
			log.info("It was not  possible to create a list with a namy using special characters");
		}

	}

	public void readFile(int downloadType, int listType, Map<String, Integer> mapAttributes) throws Exception {
		// Método para ler o arquivo
		if (downloadType == 1) // download como excel - xlsx
			readExcel(mapAttributes, listType);
		if (downloadType == 2) // download como txt
			readTxt(mapAttributes, listType);
		if (downloadType == 3) // download como csv
			readCsv(mapAttributes, listType);
	}

}
