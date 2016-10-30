//�ڱԳ�
package ch.dimi.Calculus.view;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import ch.dimi.Calculus.util.CalculatorMain;

public class OverviewController {
	
	//�׷��� �κ�
	@FXML private NumberAxis xAxis;
	@FXML private NumberAxis yAxis;
	@FXML private AreaChart<Number, Number> areaChart;
	
	//��� ��� �κ�
	@FXML private Label functionIn;
	@FXML private Label functionOut;
	@FXML private Label resultOut;
	
	//���� �κ�
	@FXML private TextField integralFrom;
	@FXML private TextField integralUntil;
	@FXML private TextField integralInput;
	
	//�̺� �κ�
	@FXML private TextField diffValue;
	@FXML private TextField diffInput;

	//��ư
	@FXML private Button integralCalc;
	@FXML private Button diffCalc;
	
	@FXML private Button function_ex;
	@FXML private Button function_lnx;
	@FXML private Button function_sinx;
	@FXML private Button function_cosx;
	@FXML private Button function_tanx;
	
	@FXML private Button input_xn;
	@FXML private Button input_e;
	
	private boolean wasIntegralSelected = true;
	
	@FXML private void initialize() {
		functionIn.setText("Input Needed");
		functionOut.setText("Input Needed");
		resultOut.setText("Input Needed");
	}
	
	@FXML private void handleIntegralCalc() {
		int from = Integer.parseInt(this.integralFrom.getText());
		int until = Integer.parseInt(this.integralUntil.getText());
		String func = this.integralInput.getText();
		
		//�̺� �Լ� ����
		CalculatorMain calculator = new CalculatorMain();
		calculator.integral(func);
		
		//�Էµ� �Լ��� ���е� �Լ��� ȭ�鿡 ǥ��
		functionIn.setText(func + " (Integral)");
		functionOut.setText(calculator.getProcessedFunction());
		resultOut.setText( Double.toString( calculator.getIntegraledValue(from, until) ) );
		
		//�׷��� ������Ʈ
		updateGraph();
	}
	
	@FXML private void handleDiffCalc() {
		System.out.println("�̺� ��ư Ŭ����");
		
		int value = Integer.parseInt(this.diffValue.getText());
		String func = this.diffInput.getText();
		func = func.trim();
		
		System.out.println("�̺� ĭ�� �Է¹��� �Լ� : " + func);
		System.out.println("�̺� ĭ�� �Է¹��� �� : " + value);
		
		// �̺� �Լ� ����
		CalculatorMain calculator = new CalculatorMain();
		calculator.differential(func);

		// �Էµ� �Լ��� ���е� �Լ��� ȭ�鿡 ǥ��
		functionIn.setText(func + " (Differential)");
		functionOut.setText(calculator.getProcessedFunction());
		resultOut.setText( Double.toString( calculator.getDifferentialedValue(value) ) );

		// �׷����� ������ ���� ǥ�� �� ������Ʈ
		// updateGraph();
	}
	
	private void updateGraph() {	
		areaChart.setVisible(false);
		areaChart.getData().clear();
		setDataForArea();
		areaChart.setVisible(true);
	}

	public void setDataForArea() {

		int from = Integer.parseInt(this.integralFrom.getText());
		int until = Integer.parseInt(this.integralUntil.getText());
		
		XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();
		dataSeries.setName("Values");
		
		for (double i = from; i <= until ; i += 0.1) {
			dataSeries.getData().add(new XYChart.Data<>(i, getValueFromFunction(i)));
		}
		
		areaChart.getData().add(dataSeries);
		areaChart.setLegendVisible(false);
		areaChart.setCreateSymbols(false);

		//xAxis.setAutoRanging(true);	
		xAxis.setUpperBound(until);
		xAxis.setLowerBound(from);
		
	}
	
	public double getValueFromFunction(double value) {
		double valueOut;
		
		//TODO �Լ��� ���� ����
		CalculatorMain calculator = new CalculatorMain();
		valueOut = calculator.getSpecificValue(value);
		
		return valueOut;
	}
	
	private void addToInputAndFocus(String str) {
		if (wasIntegralSelected) {
			integralInput.setText(integralInput.getText() + str);
			integralInput.requestFocus();
			integralInput.selectRange(integralInput.getLength(), integralInput.getLength());
		} else {
			diffInput.setText(diffInput.getText() + str);
			diffInput.requestFocus();
			diffInput.selectRange(diffInput.getLength(), diffInput.getLength());
		}
	}
	
	@FXML private void handleClickIntegralInput() {
		wasIntegralSelected = true;
	}
	
	@FXML private void handleClickDiffInput() {
		wasIntegralSelected = false;
	}
	
	@FXML private void handleFunction_ex() {
		addToInputAndFocus("e^x");
	}
	
	@FXML private void handleFunction_lnx() {
		addToInputAndFocus("ln x");
	}
	
	@FXML private void handleFunction_sinx() {
		addToInputAndFocus("sin x");
	}
	
	@FXML private void handleFunction_cosx() {
		addToInputAndFocus("cos x");
	}
	
	@FXML private void handleFunction_tanx() {
		addToInputAndFocus("tan x");
	}
	
	@FXML private void handleInput_xn() {
		addToInputAndFocus("x^");
	}
	
	@FXML private void handleInput_e() {
		addToInputAndFocus("e");
	}
	
	public OverviewController() {
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
