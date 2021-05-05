package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AtualizarTipoDeContratacaoTest {

	// atributo
	private WebDriver driver;

	@Dado("^Acessar a página de atualização de tipo de contratação$")
	public void acessar_a_página_de_atualização_de_tipo_de_contratação() {

		// driver googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");

		// iniciliazando o selenium WebDriver
		driver = new ChromeDriver();

		// Maximizando a janela do navegador
		driver.manage().window().maximize();

		// acessando a página de cadastro
		driver.get("http://exerctestes01-001-site1.btempurl.com/Home/Exercicio02");
	}

	@Dado("^Selecionar o funcionário desejado \"([^\"]*)\"$")
	public void selecionar_o_funcionário_desejado(String funcionario) {

		// capturando o campo de seleção de funcionário
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Funcionario\"]"));

		// tratar o campo como um DropDownList
		Select select = new Select(element);

		// Selecionar o funcionário desejado
		select.selectByVisibleText(funcionario);

	}

	@Dado("^Selecionar o tipo de contratação \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_contratação(String tipoContratacao) {
		
		//capturando o campo de seleção de funcionário
		WebElement element = driver.findElement(By.xpath("//*[@id=\"TipoContratacao\"]"));
		
		//tratar o campo como um DropDownList (campo de seleção)
		Select select = new Select(element);
		
		//Selecionar o tipo de contratação desejado
		select.selectByVisibleText(tipoContratacao);
	}

	@Quando("^Solicitar a atualização do tipo de contratação do funcionário$")
			public void solicitar_a_atualização_do_tipo_de_contratação_do_funcionário() {
			//clicando no botão de ação do formulário
			driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
			}

	@Então("^Sistema informa que o tipo de contratação do funcionário foi atualizado com sucesso$")
	public void sistema_informa_que_o_tipo_de_contratação_do_funcionário_foi_atualizado_com_sucesso() {
		
		//ler a mensagem exibida na página do sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		//comparando o resultado esperado com o resultado obtido
		assertEquals(mensagem, "Dados atualizados com sucesso");
	}

	@Então("^Sistema informa que os campos são obrigatórios para atualizar os dados$")
	public void sistema_informa_que_os_campos_são_obrigatórios_para_atualizar_os_dados() {
		
		//ler as mensagens de erro de cada campo obrigatorio
		String erroFuncionario = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/span")).getText();
		String erroTipoContratacao = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/span")).getText();
		
		//comparando as mensagens
		assertEquals(erroFuncionario, "Por favor, selecione o funcionário.");
		assertEquals(erroTipoContratacao, "Por favor, informe o tipo de contratação.");
		
		try {
			//gerando evidências do teste
			File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(evidencia, new File("c:\\testes\\Validação de campos obrigatórios na atualização do tipo de.png"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
