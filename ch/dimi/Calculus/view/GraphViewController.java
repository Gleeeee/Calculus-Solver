package ch.dimi.Calculus.view;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GraphViewController {

	@FXML private LineChart<Number, Number> graph;
	@FXML private NumberAxis xAxis;
	@FXML private NumberAxis yAxis;
	
	public static void main(String[] args) {
		
	}

	public void setData() {
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("x");
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("y");

		XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();
		dataSeries.setName("Values");
		
		for (int i = 0; i < 100 ; i++) {
			dataSeries.getData().add(new XYChart.Data<>(i, getValueFromFunction(i)));
		}
		
		graph.getData().add(dataSeries);
	}
	
	public void initialize() {
		
	}
	
	public double getValueFromFunction(double value) {
		double valueOut;
		valueOut = (value - 50) * (value - 50) * (value - 50) + 50;
		return valueOut;
	}
}
